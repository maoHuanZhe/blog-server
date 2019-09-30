package com.fgrapp.blog.blogserver.book.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;
import java.util.Map;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fgrapp.blog.blogserver.book.entity.BookSense;
import com.fgrapp.blog.blogserver.book.service.BookSenseService;
import com.fgrapp.blog.blogserver.common.Result;
import com.fgrapp.blog.blogserver.common.util.PageUtils;
import com.fgrapp.blog.blogserver.common.validator.ValidatorUtils;
import org.springframework.web.bind.annotation.RestController;
import com.fgrapp.blog.blogserver.common.controller.AbstractController;

/**
 * <p>
 * 读后感 前端控制器
 * </p>
 *
 * @author fgr
 * @since 2019-09-26
 */
@RestController
@RequestMapping("/admin/book/sense")
@Api(value = "result",description = "读后感相关操作")
public class BookSenseController extends AbstractController {
    @Autowired
    private BookSenseService senseService;

    @GetMapping("/list")
    @ApiOperation(value = "列表")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = senseService.queryPage(params);
        return Result.ok().put("page", page);
    }


    @GetMapping("/info/{id}")
    @ApiOperation(value = "信息")
    public Result info(@PathVariable("id") String id){
       BookSense sense = senseService.getById(id);
        return Result.ok().put("sense", sense);
    }

    @PostMapping("/save")
    @ApiOperation(value = "保存")
    public Result save(@RequestBody BookSense sense){
        ValidatorUtils.validateEntity(sense);
        senseService.save(sense);
        return Result.ok();
    }

    @PutMapping("/update")
    @ApiOperation(value = "修改")
    public Result update(@RequestBody BookSense sense){
        ValidatorUtils.validateEntity(sense);
        senseService.updateById(sense);
        return Result.ok();
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除")
    public Result delete(@RequestBody String[] ids){
        senseService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }
}
