package com.fgrapp.blog.blogserver.sys.controller;
import java.util.Map;
import java.util.List;
import com.fgrapp.blog.blogserver.common.Result;
import com.fgrapp.blog.blogserver.common.annotation.ControllerEndpoint;
import com.fgrapp.blog.blogserver.common.controller.AbstractController;
import com.fgrapp.blog.blogserver.common.util.QueryRequest;
import com.fgrapp.blog.blogserver.sys.entity.Role;
import com.fgrapp.blog.blogserver.sys.service.IRoleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * RoleController
 *
 * @author FGR on 2019/9/29
 */
@Slf4j
@RestController
@RequestMapping("role")
public class RoleController extends AbstractController {
    @Autowired
    private IRoleService roleService;

    @GetMapping
    public Result getAllRoles(Role role){
        List<Role> roles = roleService.findRoles(role);
        return Result.ok().put("data",roles);
    }

    @GetMapping("/list")
    @RequiresPermissions("role:view")
    public Result getList(Role role, QueryRequest request) {
        Map<String, Object> dataTable = getDataTable(roleService.findRoles(role, request));
        return Result.ok(dataTable);
    }

    @PostMapping
    @RequiresPermissions("role:add")
    @ControllerEndpoint(operation ="新增角色",exceptionMessage = "新增角色失败")
    public Result add(@Valid @RequestBody Role role){
        roleService.createRole(role);
        return Result.ok();
    }

    @PutMapping
    @RequiresPermissions("role:updata")
    @ControllerEndpoint(operation = "修改角色",exceptionMessage = "修改角色失败")
    public Result update(@Valid @RequestBody Role role) {
        roleService.updateRole(role);
        return Result.ok();
    }

    @DeleteMapping
    @RequiresPermissions("role:delete")
    @ControllerEndpoint(operation = "删除角色", exceptionMessage = "删除角色失败")
    public Result delete(@RequestBody String[] ids){
        roleService.deleteRoles(ids);
        return Result.ok();
    }

    @GetMapping("/{id}")
    public Result getRole(@PathVariable String id) {
        Role byId = roleService.getById(id);
        return Result.ok(byId);
    }
}
