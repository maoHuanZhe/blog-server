package com.fgrapp.blog.blogserver.operation.mapper;

import com.fgrapp.blog.blogserver.operation.entity.TagLink;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 标签多对多维护表 Mapper 接口
 * </p>
 *
 * @author fgr
 * @since 2019-09-26
 */
@Mapper
public interface TagLinkMapper extends BaseMapper<TagLink> {

}
