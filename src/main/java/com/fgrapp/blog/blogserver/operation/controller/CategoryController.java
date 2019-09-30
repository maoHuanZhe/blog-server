package com.fgrapp.blog.blogserver.operation.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fgrapp.blog.blogserver.operation.entity.Category;
import com.fgrapp.blog.blogserver.operation.service.CategoryService;
import com.fgrapp.blog.blogserver.common.Result;
import com.fgrapp.blog.blogserver.common.util.PageUtils;
import com.fgrapp.blog.blogserver.common.validator.ValidatorUtils;
import org.springframework.web.bind.annotation.RestController;
import com.fgrapp.blog.blogserver.common.controller.AbstractController;

/**
 * <p>
 * 类别 前端控制器
 * </p>
 *
 * @author fgr
 * @since 2019-09-26
 */
@RestController
@RequestMapping("/admin/operation/category")
@Api(value = "result",description = "类别相关操作")
public class CategoryController extends AbstractController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    @ApiOperation(value = "列表")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = categoryService.queryPage(params);
        return Result.ok().put("page", page);
    }
    @RequestMapping("/select/{type}")
    @ApiOperation(value = "树状列表")
    public Result select(@PathVariable("type")Integer type){
        List<Category> categoryList = categoryService.list(new QueryWrapper<Category>().lambda().eq(type!=null,Category::getType,type));
        //添加顶级分类
        Category root = new Category();
        root.setId(-1);
        root.setName("根目录");
        root.setParentId(-1);
        categoryList.add(root);
        return Result.ok().put("categoryList",categoryList);
    }
    @GetMapping("/info/{id}")
    @ApiOperation(value = "信息")
    public Result info(@PathVariable("id") String id){
       Category category = categoryService.getById(id);
        return Result.ok().put("category", category);
    }

    @PostMapping("/save")
    @ApiOperation(value = "保存")
    public Result save(@RequestBody Category category){
        ValidatorUtils.validateEntity(category);
        categoryService.save(category);
        return Result.ok();
    }

    @PutMapping("/update")
    @ApiOperation(value = "修改")
    public Result update(@RequestBody Category category){
        ValidatorUtils.validateEntity(category);
        categoryService.updateById(category);
        return Result.ok();
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除")
    public Result delete(@RequestBody String[] ids){
        categoryService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }
}
