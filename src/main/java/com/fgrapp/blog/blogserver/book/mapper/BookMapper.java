package com.fgrapp.blog.blogserver.book.mapper;

import com.fgrapp.blog.blogserver.book.entity.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 图书表 Mapper 接口
 * </p>
 *
 * @author fgr
 * @since 2019-09-26
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {

}
