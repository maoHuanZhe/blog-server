package com.fgrapp.blog.blogserver.monitor.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fgrapp.blog.blogserver.common.util.QueryRequest;
import com.fgrapp.blog.blogserver.monitor.entity.LoginLog;
import com.fgrapp.blog.blogserver.sys.entity.User;

import java.util.List;
import java.util.Map;

/**
 * ILoginLogService
 *
 * @author FGR on 2019/9/28
 */
public interface ILoginLogService extends IService<LoginLog> {

    /**
     * 获取登录日志分页信息
     *
     * @param loginLog 传参
     * @param request  request
     * @return IPage<LoginLog>
     */
    IPage<LoginLog> findLoginLogs(LoginLog loginLog, QueryRequest request);

    /**
     * 保存登录日志
     *
     * @param loginLog 登录日志
     */
    void saveLoginLog(LoginLog loginLog);

    /**
     * 删除登录日志
     *
     * @param ids 日志 id集合
     */
    void deleteLoginLogs(String[] ids);

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
