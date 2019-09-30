package com.fgrapp.blog.blogserver.sys.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;
import java.util.Map;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fgrapp.blog.blogserver.sys.entity.SysUser;
import com.fgrapp.blog.blogserver.sys.service.SysUserService;
import com.fgrapp.blog.blogserver.common.Result;
import com.fgrapp.blog.blogserver.common.util.PageUtils;
import com.fgrapp.blog.blogserver.common.validator.ValidatorUtils;
import org.springframework.web.bind.annotation.RestController;
import com.fgrapp.blog.blogserver.common.controller.AbstractController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fgr
 * @since 2019-09-26
 */
@RestController
@RequestMapping("/admin/sys/user")
@Api(value = "result",description = "相关操作")
public class SysUserController extends AbstractController {
    @Autowired
    private SysUserService userService;

    @GetMapping("/list")
    @ApiOperation(value = "列表")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = userService.queryPage(params);
        return Result.ok().put("page", page);
    }


    @GetMapping("/info/{id}")
    @ApiOperation(value = "信息")
    public Result info(@PathVariable("id") String id){
       SysUser user = userService.getById(id);
        return Result.ok().put("user", user);
    }

    @PostMapping("/save")
    @ApiOperation(value = "保存")
    public Result save(@RequestBody SysUser user){
        ValidatorUtils.validateEntity(user);
        userService.save(user);
        return Result.ok();
    }

    @PutMapping("/update")
    @ApiOperation(value = "修改")
    public Result update(@RequestBody SysUser user){
        ValidatorUtils.validateEntity(user);
        userService.updateById(user);
        return Result.ok();
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除")
    public Result delete(@RequestBody String[] ids){
        userService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }
}
