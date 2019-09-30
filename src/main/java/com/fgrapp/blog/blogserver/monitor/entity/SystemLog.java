package com.fgrapp.blog.blogserver.monitor.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * SystemLog
 *
 * @author FGR on 2019/9/29
 */
@Data
@TableName("t_log")
public class SystemLog implements Serializable {

    private static final long serialVersionUID = 2496768989898045390L;

    /**
     * 日志ID
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 操作用户
     */
    @TableField("USERNAME")
    private String username;

    /**
     * 操作内容
     */
    @TableField("OPERATION")
    private String operation;

    /**
     * 耗时
     */
    @TableField("TIME")
    private Long time;

    /**
     * 操作方法
     */
    @TableField("METHOD")
    private String method;

    /**
     * 方法参数
     */
    @TableField("PARAMS")
    private String params;

    /**
     * 操作者IP
     */
    @TableField("IP")
    private String ip;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * 操作地点
     */
    @TableField("LOCATION")
    private String location;

    private transient String createTimeFrom;
    private transient String createTimeTo;
}

