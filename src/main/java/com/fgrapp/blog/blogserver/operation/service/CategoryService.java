package com.fgrapp.blog.blogserver.operation.service;

import com.fgrapp.blog.blogserver.operation.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fgrapp.blog.blogserver.common.util.PageUtils;
import java.util.Map;

/**
 * <p>
 * 类别 服务类
 * </p>
 *
 * @author fgr
 * @since 2019-09-26
 */
public interface CategoryService extends IService<Category> {

    /**
     * 分页查询
     * @param params
     * @return
     */
     PageUtils queryPage(Map<String, Object> params);
}
