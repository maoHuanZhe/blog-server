package com.fgrapp.blog.blogserver.monitor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fgrapp.blog.blogserver.monitor.entity.LoginLog;
import com.fgrapp.blog.blogserver.sys.entity.User;

import java.util.List;
import java.util.Map;

/**
 * LoginLogMapper
 *
 * @author FGR on 2019/9/28
 */
public interface LoginLogMapper extends BaseMapper<LoginLog> {

    /**
     * 获取系统总访问次数
     *
     * @return Long
     */
    Long findTotalVisitCount();

    /**
     * 获取系统今日访问次数
     *
     * @return Long
     */
    Long findTodayVisitCount();

    /**
     * 获取系统今日访问 IP数
     *
     * @return Long
     */
    Long findTodayIp();

    /**
     * 获取系统近七天来的访问记录
     *
     * @param user 用户
     * @return 系统近七天来的访问记录
     */
    List<Map<String, Object>> findLastSevenDaysVisitCount(User user);
}
