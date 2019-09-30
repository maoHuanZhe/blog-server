package com.fgrapp.blog.blogserver.operation.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fgrapp.blog.blogserver.operation.entity.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 标签 Mapper 接口
 * </p>
 *
 * @author fgr
 * @since 2019-09-26
 */
@Mapper
public interface TagMapper extends BaseMapper<Tag> {

    /**
     * 获取分页数据
     * @param page
     * @param tag
     * @return
     */
    IPage<?> getPage(@Param("page") Page<Tag> page, @Param("tag") Tag tag);

}
