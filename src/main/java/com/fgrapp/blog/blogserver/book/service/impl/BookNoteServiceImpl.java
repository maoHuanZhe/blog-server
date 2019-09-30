package com.fgrapp.blog.blogserver.book.service.impl;

import com.fgrapp.blog.blogserver.book.entity.BookNote;
import com.fgrapp.blog.blogserver.book.mapper.BookNoteMapper;
import com.fgrapp.blog.blogserver.book.service.BookNoteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fgrapp.blog.blogserver.common.util.Query;
import com.fgrapp.blog.blogserver.common.util.PageUtils;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 笔记 服务实现类
 * </p>
 *
 * @author fgr
 * @since 2019-09-26
 */
@Service
public class BookNoteServiceImpl extends ServiceImpl<BookNoteMapper, BookNote> implements BookNoteService {

    /**
     * 分页查询
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BookNote> page=baseMapper.selectPage(new Query<BookNote>(params).getPage(),
                new QueryWrapper<BookNote>().lambda());
        return new PageUtils(page);
    }

}
