package com.fgrapp.blog.blogserver.operation.service;

import com.fgrapp.blog.blogserver.operation.entity.TagLink;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fgrapp.blog.blogserver.common.util.PageUtils;
import java.util.Map;

/**
 * <p>
 * 标签多对多维护表 服务类
 * </p>
 *
 * @author fgr
 * @since 2019-09-26
 */
public interface TagLinkService extends IService<TagLink> {

    /**
     * 分页查询
     * @param params
     * @return
     */
     PageUtils queryPage(Map<String, Object> params);
}
