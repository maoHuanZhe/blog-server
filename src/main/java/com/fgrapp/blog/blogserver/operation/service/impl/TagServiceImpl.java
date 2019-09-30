package com.fgrapp.blog.blogserver.operation.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fgrapp.blog.blogserver.common.util.*;
import com.fgrapp.blog.blogserver.operation.entity.Link;
import com.fgrapp.blog.blogserver.operation.entity.Tag;
import com.fgrapp.blog.blogserver.operation.mapper.TagMapper;
import com.fgrapp.blog.blogserver.operation.service.TagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 标签 服务实现类
 * </p>
 *
 * @author fgr
 * @since 2019-09-26
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

    /**
     *  分页查询
     * @param tag
     * @param queryRequest
     * @return
     */
    @Override
    public IPage<?> queryPage(Tag tag, QueryRequest queryRequest) {
        Page<Tag> page = new Page<>(queryRequest.getPageNum(), queryRequest.getPageSize());
        SortUtil.handlePageSort(queryRequest, page, "id", Constant.ORDER_ASC, false);
        return this.baseMapper.getPage(page, tag);
    }
}
