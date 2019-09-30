package com.fgrapp.blog.blogserver.operation.service;

import com.fgrapp.blog.blogserver.operation.entity.Recommend;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fgrapp.blog.blogserver.common.util.PageUtils;
import java.util.Map;

/**
 * <p>
 * 推荐 服务类
 * </p>
 *
 * @author fgr
 * @since 2019-09-26
 */
public interface RecommendService extends IService<Recommend> {

    /**
     * 分页查询
     * @param params
     * @return
     */
     PageUtils queryPage(Map<String, Object> params);
}
