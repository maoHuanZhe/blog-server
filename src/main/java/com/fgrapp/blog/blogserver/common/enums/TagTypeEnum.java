package com.fgrapp.blog.blogserver.common.enums;

import com.alibaba.fastjson.annotation.JSONType;
import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.AllArgsConstructor;

/**
 * 标签类型枚举类
 *
 * @author FGR on 2019/9/27
 */
@JSONType(serializeEnumAsJavaBean = true)
@AllArgsConstructor
public enum  TagTypeEnum implements IEnum<Integer> {

    /**
     * 文章
     */
    ARTICLE(1, "文章"),
    /**
     * 类别
     */
    CATEGORY(2, "类别");

    private int value;
    private String desc;

    @Override
    public Integer getValue() {
        return this.value;
    }

    public String getDesc(){
        return this.desc;
    }
}
