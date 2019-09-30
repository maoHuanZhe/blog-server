package com.fgrapp.blog.blogserver.operation.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fgrapp.blog.blogserver.common.util.*;
import com.fgrapp.blog.blogserver.operation.entity.Link;
import com.fgrapp.blog.blogserver.operation.mapper.LinkMapper;
import com.fgrapp.blog.blogserver.operation.service.LinkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 友链 服务实现类
 * </p>
 *
 * @author fgr
 * @since 2019-09-26
 */
@Service
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {

    /**
     * 分页查询
     * @param link
     * @param request
     * @return
     */
    @Override
    public IPage<Link> queryPage(Link link, QueryRequest request) {
        Page<Link> page = new Page<>(request.getPageNum(), request.getPageSize());
        SortUtil.handlePageSort(request, page, "id", Constant.ORDER_ASC, false);
        return this.baseMapper.getPage(page, link);
    }

}
