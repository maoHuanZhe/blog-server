package com.fgrapp.blog.blogserver.operation.controller;

import com.fgrapp.blog.blogserver.common.annotation.Limit;
import com.fgrapp.blog.blogserver.common.util.QueryRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;
import java.util.Map;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fgrapp.blog.blogserver.operation.entity.Link;
import com.fgrapp.blog.blogserver.operation.service.LinkService;
import com.fgrapp.blog.blogserver.common.Result;
import com.fgrapp.blog.blogserver.common.util.PageUtils;
import com.fgrapp.blog.blogserver.common.validator.ValidatorUtils;
import org.springframework.web.bind.annotation.RestController;
import com.fgrapp.blog.blogserver.common.controller.AbstractController;

/**
 * <p>
 * 友链 前端控制器
 * </p>
 *
 * @author fgr
 * @since 2019-09-26
 */
@RestController
@RequestMapping("/admin/operation/link")
@Api(value = "result",description = "友链相关操作")
public class LinkController extends AbstractController {
    @Autowired
    private LinkService linkService;

    @GetMapping("/list")
    @ApiOperation(value = "列表")
    @Limit(key = "login", period = 60, count = 20, name = "登录接口", prefix = "limit")
    public Result list(Link link, QueryRequest queryRequest){
        Map<String, Object> dataTable = getDataTable(linkService.queryPage(link, queryRequest));
        return Result.ok().put("data",dataTable);
    }


    @GetMapping("/info/{id}")
    @ApiOperation(value = "信息")
    public Result info(@PathVariable("id") String id){
       Link link = linkService.getById(id);
        return Result.ok().put("link", link);
    }

    @PostMapping("/save")
    @ApiOperation(value = "保存")
    public Result save(@RequestBody Link link){
        ValidatorUtils.validateEntity(link);
        linkService.save(link);
        return Result.ok();
    }

    @PutMapping("/update")
    @ApiOperation(value = "修改")
    public Result update(@RequestBody Link link){
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
