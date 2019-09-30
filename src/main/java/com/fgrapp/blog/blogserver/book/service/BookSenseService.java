package com.fgrapp.blog.blogserver.book.service;

import com.fgrapp.blog.blogserver.book.entity.BookSense;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fgrapp.blog.blogserver.common.util.PageUtils;
import java.util.Map;

/**
 * <p>
 * 读后感 服务类
 * </p>
 *
 * @author fgr
 * @since 2019-09-26
 */
public interface BookSenseService extends IService<BookSense> {

    /**
     * 分页查询
     * @param params
     * @return
     */
     PageUtils queryPage(Map<String, Object> params);
}
