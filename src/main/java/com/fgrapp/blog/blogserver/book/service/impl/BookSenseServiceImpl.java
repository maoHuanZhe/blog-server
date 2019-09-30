package com.fgrapp.blog.blogserver.book.service.impl;

import com.fgrapp.blog.blogserver.book.entity.BookSense;
import com.fgrapp.blog.blogserver.book.mapper.BookSenseMapper;
import com.fgrapp.blog.blogserver.book.service.BookSenseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fgrapp.blog.blogserver.common.util.Query;
import com.fgrapp.blog.blogserver.common.util.PageUtils;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 读后感 服务实现类
 * </p>
 *
 * @author fgr
 * @since 2019-09-26
 */
@Service
public class BookSenseServiceImpl extends ServiceImpl<BookSenseMapper, BookSense> implements BookSenseService {

    /**
     * 分页查询
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BookSense> page=baseMapper.selectPage(new Query<BookSense>(params).getPage(),
                new QueryWrapper<BookSense>().lambda());
        return new PageUtils(page);
    }

}
