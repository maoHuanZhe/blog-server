package com.fgrapp.blog.blogserver.article.service.impl;

import com.fgrapp.blog.blogserver.article.entity.Article;
import com.fgrapp.blog.blogserver.article.mapper.ArticleMapper;
import com.fgrapp.blog.blogserver.article.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fgrapp.blog.blogserver.common.util.Query;
import com.fgrapp.blog.blogserver.common.util.PageUtils;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 文章 服务实现类
 * </p>
 *
 * @author fgr
 * @since 2019-09-26
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    /**
     * 分页查询
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<Article> page=baseMapper.selectPage(new Query<Article>(params).getPage(),
                new QueryWrapper<Article>().lambda());
        return new PageUtils(page);
    }

}
