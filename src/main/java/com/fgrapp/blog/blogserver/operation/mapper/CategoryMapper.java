package com.fgrapp.blog.blogserver.operation.mapper;

import com.fgrapp.blog.blogserver.operation.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 类别 Mapper 接口
 * </p>
 *
 * @author fgr
 * @since 2019-09-26
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}
