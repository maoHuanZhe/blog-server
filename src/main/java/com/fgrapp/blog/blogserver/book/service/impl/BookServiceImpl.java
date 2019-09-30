package com.fgrapp.blog.blogserver.book.service.impl;

import com.fgrapp.blog.blogserver.book.entity.Book;
import com.fgrapp.blog.blogserver.book.mapper.BookMapper;
import com.fgrapp.blog.blogserver.book.service.BookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fgrapp.blog.blogserver.common.util.Query;
import com.fgrapp.blog.blogserver.common.util.PageUtils;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 图书表 服务实现类
 * </p>
 *
 * @author fgr
 * @since 2019-09-26
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    /**
     * 分页查询
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<Book> page=baseMapper.selectPage(new Query<Book>(params).getPage(),
                new QueryWrapper<Book>().lambda());
        return new PageUtils(page);
    }

}
