package com.fgrapp.blog.blogserver.operation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;
import java.util.Map;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fgrapp.blog.blogserver.operation.entity.Recommend;
import com.fgrapp.blog.blogserver.operation.service.RecommendService;
import com.fgrapp.blog.blogserver.common.Result;
import com.fgrapp.blog.blogserver.common.util.PageUtils;
import com.fgrapp.blog.blogserver.common.validator.ValidatorUtils;
import org.springframework.web.bind.annotation.RestController;
import com.fgrapp.blog.blogserver.common.controller.AbstractController;

/**
 * <p>
 * 推荐 前端控制器
 * </p>
 *
 * @author fgr
 * @since 2019-09-26
 */
@RestController
@RequestMapping("/admin/operation/recommend")
@Api(value = "result",description = "推荐相关操作")
public class RecommendController extends AbstractController {
    @Autowired
    private RecommendService recommendService;

    @GetMapping("/list")
    @ApiOperation(value = "列表")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = recommendService.queryPage(params);
        return Result.ok().put("page", page);
    }


    @GetMapping("/info/{id}")
    @ApiOperation(value = "信息")
    public Result info(@PathVariable("id") String id){
       Recommend recommend = recommendService.getById(id);
        return Result.ok().put("recommend", recommend);
    }

    @PostMapping("/save")
    @ApiOperation(value = "保存")
    public Result save(@RequestBody Recommend recommend){
        ValidatorUtils.validateEntity(recommend);
        recommendService.save(recommend);
        return Result.ok();
    }

    @PutMapping("/update")
    @ApiOperation(value = "修改")
    public Result update(@RequestBody Recommend recommend){
        ValidatorUtils.validateEntity(recommend);
        recommendService.updateById(recommend);
        return Result.ok();
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除")
    public Result delete(@RequestBody String[] ids){
        recommendService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }
}
