package com.fgrapp.blog.blogserver.book.mapper;

import com.fgrapp.blog.blogserver.book.entity.BookNote;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 笔记 Mapper 接口
 * </p>
 *
 * @author fgr
 * @since 2019-09-26
 */
@Mapper
public interface BookNoteMapper extends BaseMapper<BookNote> {

}
