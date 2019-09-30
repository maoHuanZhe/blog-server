package com.fgrapp.blog.blogserver.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fgrapp.blog.blogserver.sys.entity.RoleMenu;

import java.util.List;

/**
 * @author FGR on 2019/9/28
 */
public interface IRoleMenuService extends IService<RoleMenu> {

    /**
     * 通过角色 id 删除
     *
     * @param roleIds 角色 id
     */
    void deleteRoleMenusByRoleId(List<String> roleIds);

    /**
     * 通过菜单（按钮）id 删除
     *
     * @param menuIds 菜单（按钮）id
     */
    void deleteRoleMenusByMenuId(List<String> menuIds);

    /**
     * 递归删除菜单/按钮
     *
     * @param menuId menuId
     */
    void deleteRoleMenus(String menuId);
}
