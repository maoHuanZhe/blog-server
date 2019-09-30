package com.fgrapp.blog.blogserver.article.mapper;

import com.fgrapp.blog.blogserver.article.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 文章 Mapper 接口
 * </p>
 *
 * @author fgr
 * @since 2019-09-26
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

}
