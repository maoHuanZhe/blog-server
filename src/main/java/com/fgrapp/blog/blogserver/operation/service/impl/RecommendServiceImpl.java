package com.fgrapp.blog.blogserver.operation.service.impl;

import com.fgrapp.blog.blogserver.operation.entity.Recommend;
import com.fgrapp.blog.blogserver.operation.mapper.RecommendMapper;
import com.fgrapp.blog.blogserver.operation.service.RecommendService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fgrapp.blog.blogserver.common.util.Query;
import com.fgrapp.blog.blogserver.common.util.PageUtils;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 推荐 服务实现类
 * </p>
 *
 * @author fgr
 * @since 2019-09-26
 */
@Service
public class RecommendServiceImpl extends ServiceImpl<RecommendMapper, Recommend> implements RecommendService {

    /**
     * 分页查询
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<Recommend> page=baseMapper.selectPage(new Query<Recommend>(params).getPage(),
                new QueryWrapper<Recommend>().lambda());
        return new PageUtils(page);
    }

}
