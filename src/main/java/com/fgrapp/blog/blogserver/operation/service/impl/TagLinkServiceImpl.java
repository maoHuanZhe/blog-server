package com.fgrapp.blog.blogserver.operation.service.impl;

import com.fgrapp.blog.blogserver.operation.entity.TagLink;
import com.fgrapp.blog.blogserver.operation.mapper.TagLinkMapper;
import com.fgrapp.blog.blogserver.operation.service.TagLinkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fgrapp.blog.blogserver.common.util.Query;
import com.fgrapp.blog.blogserver.common.util.PageUtils;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 标签多对多维护表 服务实现类
 * </p>
 *
 * @author fgr
 * @since 2019-09-26
 */
@Service
public class TagLinkServiceImpl extends ServiceImpl<TagLinkMapper, TagLink> implements TagLinkService {

    /**
     * 分页查询
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TagLink> page=baseMapper.selectPage(new Query<TagLink>(params).getPage(),
                new QueryWrapper<TagLink>().lambda());
        return new PageUtils(page);
    }

}
