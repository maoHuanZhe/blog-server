package com.fgrapp.blog.blogserver.operation.controller;

import com.fgrapp.blog.blogserver.common.util.QueryRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;
import java.util.Map;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fgrapp.blog.blogserver.operation.entity.Tag;
import com.fgrapp.blog.blogserver.operation.service.TagService;
import com.fgrapp.blog.blogserver.common.Result;
import com.fgrapp.blog.blogserver.common.validator.ValidatorUtils;
import org.springframework.web.bind.annotation.RestController;
import com.fgrapp.blog.blogserver.common.controller.AbstractController;

/**
 * <p>
 * 标签 前端控制器
 * </p>
 *
 * @author fgr
 * @since 2019-09-26
 */
@RestController
@RequestMapping("/admin/operation/tag")
@Api(value = "result",description = "标签相关操作")
public class TagController extends AbstractController {
    @Autowired
    private TagService tagService;

    @GetMapping("/list")
    @ApiOperation(value = "列表")
    public Result list(Tag tag, QueryRequest queryRequest){
        Map<String, Object> dataTable = getDataTable(tagService.queryPage(tag, queryRequest));
        return Result.ok().put("data",dataTable);
    }


    @GetMapping("/info/{id}")
    @ApiOperation(value = "信息")
    public Result info(@PathVariable("id") String id){
       Tag tag = tagService.getById(id);
        return Result.ok().put("tag", tag);
    }

    @PostMapping("/save")
    @ApiOperation(value = "保存")
    public Result save(@RequestBody Tag tag){
        ValidatorUtils.validateEntity(tag);
        tagService.save(tag);
        return Result.ok();
    }

    @PutMapping("/update")
    @ApiOperation(value = "修改")
    public Result update(@RequestBody Tag tag){
        ValidatorUtils.validateEntity(tag);
        tagService.updateById(tag);
        return Result.ok();
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除")
    public Result delete(@RequestBody String[] ids){
        tagService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }
}
