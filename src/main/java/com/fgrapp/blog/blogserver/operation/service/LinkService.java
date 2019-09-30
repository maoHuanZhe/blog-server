package com.fgrapp.blog.blogserver.operation.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fgrapp.blog.blogserver.common.util.QueryRequest;
import com.fgrapp.blog.blogserver.operation.entity.Link;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fgrapp.blog.blogserver.common.util.PageUtils;
import java.util.Map;

/**
 * <p>
 * 友链 服务类
 * </p>
 *
 * @author fgr
 * @since 2019-09-26
 */
public interface LinkService extends IService<Link> {

    /**
     * 分页查询
     * @param link
     * @param request
     * @return
     */
    IPage<Link> queryPage(Link link, QueryRequest request);
}
