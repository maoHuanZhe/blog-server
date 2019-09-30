package com.fgrapp.blog.blogserver.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fgrapp.blog.blogserver.sys.entity.RoleMenu;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author FGR on 2019/9/28
 */
@Mapper
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {
    /**
     * 递归删除菜单/按钮
     *
     * @param menuId menuId
     */
    void deleteRoleMenus(String menuId);
}
