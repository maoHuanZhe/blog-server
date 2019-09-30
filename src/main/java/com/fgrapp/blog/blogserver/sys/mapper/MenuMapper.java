package com.fgrapp.blog.blogserver.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fgrapp.blog.blogserver.sys.entity.Menu;

import java.util.List;

/**
 * @author FGR on 2019/9/28
 */
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * 查找用户权限集
     *
     * @param username 用户名
     * @return 用户权限集合
     */
    List<Menu> findUserPermissions(String username);

    /**
     * 查找用户菜单集合
     *
     * @param username 用户名
     * @return 用户菜单集合
     */
    List<Menu> findUserMenus(String username);
}
