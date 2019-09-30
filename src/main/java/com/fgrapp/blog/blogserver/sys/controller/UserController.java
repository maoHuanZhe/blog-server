package com.fgrapp.blog.blogserver.sys.controller;
import	java.lang.ref.Reference;

import com.fgrapp.blog.blogserver.common.Result;
import com.fgrapp.blog.blogserver.common.annotation.ControllerEndpoint;
import com.fgrapp.blog.blogserver.common.authentication.ShiroHelper;
import com.fgrapp.blog.blogserver.common.controller.AbstractController;
import com.fgrapp.blog.blogserver.common.exception.MyException;
import com.fgrapp.blog.blogserver.common.util.QueryRequest;
import com.fgrapp.blog.blogserver.sys.entity.User;
import com.fgrapp.blog.blogserver.sys.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * UserController
 *
 * @author FGR on 2019/9/28
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/user")
public class UserController extends AbstractController {
    @Autowired
    private IUserService userService;
    @Autowired
    private ShiroHelper shiroHelper;

    @GetMapping("/getUser")
    public Result getUserDetail(){
        AuthorizationInfo authorizationInfo = shiroHelper.getCurrentuserAuthorizationInfo();
        User user = super.getCurrentUser();
        user.setPassword("It's a secret");
        Map<String,Object> map = new HashMap<>(2);
        map.put("user",userService.findByName(user.getUsername()));
        map.put("permissins",authorizationInfo.getStringPermissions());
        map.put("roles",authorizationInfo.getRoles());
        return Result.ok().put("data",map);
    }

    @GetMapping("/list")
    @RequiresPermissions("user:view")
    public Result getList(User user, QueryRequest request){
        Map<String, Object> dataTable = getDataTable(this.userService.findUserDetail(user, request));
        return Result.ok().put("data",dataTable);
    }

    @PostMapping
    @RequiresPermissions("user:add")
    @ControllerEndpoint(operation = "新增用户", exceptionMessage = "新增用户失败")
    public Result add(@Valid @RequestBody User user){
        this.userService.createUser(user);
        return Result.ok();
    }

    @PutMapping
    @RequiresPermissions("user:update")
    @ControllerEndpoint(operation = "修改用户", exceptionMessage = "修改用户失败")
    public Result update(@Valid @RequestBody User user){
        if (user.getUserId()  == null){
            throw new MyException("用户ID为空");
        }
        userService.updateUser(user);
        return Result.ok();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable("id") String id){
        User byId = userService.getUserById(id);
        return Result.ok().put("user",byId);
    }

    @DeleteMapping
    @RequiresPermissions("user:delete")
    @ControllerEndpoint(operation = "删除用户", exceptionMessage = "删除用户失败")
    public Result batchDelete(@RequestBody String[] ids){
        userService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

    @PutMapping("/reset")
    @RequiresPermissions("user:password:reset")
    @ControllerEndpoint(operation = "重置密码", exceptionMessage = "重置密码失败")
    public Result batchReset(@RequestBody String[] ids){
        userService.batchReset(Arrays.asList(ids));
        return Result.ok();
    }

}
