package com.fgrapp.blog.blogserver.operation.service.impl;

import com.fgrapp.blog.blogserver.operation.entity.Category;
import com.fgrapp.blog.blogserver.operation.mapper.CategoryMapper;
import com.fgrapp.blog.blogserver.operation.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fgrapp.blog.blogserver.common.util.Query;
import com.fgrapp.blog.blogserver.common.util.PageUtils;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 类别 服务实现类
 * </p>
 *
 * @author fgr
 * @since 2019-09-26
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    /**
     * 分页查询
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<Category> page=baseMapper.selectPage(new Query<Category>(params).getPage(),
                new QueryWrapper<Category>().lambda());
        return new PageUtils(page);
    }

}
