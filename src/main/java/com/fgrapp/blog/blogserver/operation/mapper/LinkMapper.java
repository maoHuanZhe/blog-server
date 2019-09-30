package com.fgrapp.blog.blogserver.operation.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fgrapp.blog.blogserver.operation.entity.Link;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 友链 Mapper 接口
 * </p>
 *
 * @author fgr
 * @since 2019-09-26
 */
@Mapper
public interface LinkMapper extends BaseMapper<Link> {

    /**
     * 获取分页数据
     * @param page page
     * @param link link
     * @return IPage
     */
    IPage<Link> getPage(@Param("page") Page<Link> page, @Param("link") Link link);
}
