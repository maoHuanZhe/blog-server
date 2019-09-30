package com.fgrapp.blog.blogserver.article.service;

import com.fgrapp.blog.blogserver.article.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fgrapp.blog.blogserver.common.util.PageUtils;
import java.util.Map;

/**
 * <p>
 * 文章 服务类
 * </p>
 *
 * @author fgr
 * @since 2019-09-26
 */
public interface ArticleService extends IService<Article> {

    /**
     * 分页查询
     * @param params
     * @return
     */
     PageUtils queryPage(Map<String, Object> params);
}
