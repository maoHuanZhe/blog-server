package com.fgrapp.blog.blogserver.sys.service.impl;

import com.fgrapp.blog.blogserver.sys.entity.SysUser;
import com.fgrapp.blog.blogserver.sys.mapper.SysUserMapper;
import com.fgrapp.blog.blogserver.sys.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fgrapp.blog.blogserver.common.util.Query;
import com.fgrapp.blog.blogserver.common.util.PageUtils;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fgr
 * @since 2019-09-26
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    /**
     * 分页查询
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysUser> page=baseMapper.selectPage(new Query<SysUser>(params).getPage(),
                new QueryWrapper<SysUser>().lambda());
        return new PageUtils(page);
    }

}
