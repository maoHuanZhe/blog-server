package com.fgrapp.blog.blogserver.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fgrapp.blog.blogserver.sys.entity.UserRole;

import java.util.List;

/**
 * @author FGR on 2019/9/28
 */
public interface IUserRoleService extends IService<UserRole> {

    /**
     * 通过角色 id 删除
     *
     * @param roleIds 角色 id
     */
    void deleteUserRolesByRoleId(List<String> roleIds);

    /**
     * 通过用户 id 删除
     *
     * @param userIds 用户 id
     */
    void deleteUserRolesByUserId(List<String> userIds);
}
