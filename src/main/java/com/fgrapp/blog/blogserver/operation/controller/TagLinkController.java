package com.fgrapp.blog.blogserver.operation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;
import java.util.Map;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fgrapp.blog.blogserver.operation.entity.TagLink;
import com.fgrapp.blog.blogserver.operation.service.TagLinkService;
import com.fgrapp.blog.blogserver.common.Result;
import com.fgrapp.blog.blogserver.common.util.PageUtils;
import com.fgrapp.blog.blogserver.common.validator.ValidatorUtils;
import org.springframework.web.bind.annotation.RestController;
import com.fgrapp.blog.blogserver.common.controller.AbstractController;

/**
 * <p>
 * 标签多对多维护表 前端控制器
 * </p>
 *
 * @author fgr
 * @since 2019-09-26
 */
@RestController
@RequestMapping("/admin/operation/taglink")
@Api(value = "result",description = "标签多对多维护表相关操作")
public class TagLinkController extends AbstractController {
    @Autowired
    private TagLinkService linkService;

    @GetMapping("/list")
    @ApiOperation(value = "列表")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = linkService.queryPage(params);
        return Result.ok().put("page", page);
    }


    @GetMapping("/info/{id}")
    @ApiOperation(value = "信息")
    public Result info(@PathVariable("id") String id){
       TagLink link = linkService.getById(id);
        return Result.ok().put("link", link);
    }

    @PostMapping("/save")
    @ApiOperation(value = "保存")
    public Result save(@RequestBody TagLink link){
        ValidatorUtils.validateEntity(link);
        linkService.save(link);
        return Result.ok();
    }

    @PutMapping("/update")
    @ApiOperation(value = "修改")
    public Result update(@RequestBody TagLink link){
        ValidatorUtils.validateEntity(link);
        linkService.updateById(link);
        return Result.ok();
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除")
    public Result delete(@RequestBody String[] ids){
        linkService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }
}
