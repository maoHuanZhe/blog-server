package com.fgrapp.blog.blogserver.operation.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fgrapp.blog.blogserver.common.util.QueryRequest;
import com.fgrapp.blog.blogserver.operation.entity.Tag;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fgrapp.blog.blogserver.common.util.PageUtils;
import java.util.Map;

/**
 * <p>
 * 标签 服务类
 * </p>
 *
 * @author fgr
 * @since 2019-09-26
 */
public interface TagService extends IService<Tag> {

    /**
     * 分页查询
     * @param tag
     * @param queryRequest
     * @return
     */
    IPage<?> queryPage(Tag tag, QueryRequest queryRequest);
}
