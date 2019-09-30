package com.fgrapp.blog.blogserver.sys.controller;

import com.fgrapp.blog.blogserver.common.Result;
import com.fgrapp.blog.blogserver.common.annotation.Limit;
import com.fgrapp.blog.blogserver.common.authentication.ShiroHelper;
import com.fgrapp.blog.blogserver.common.controller.AbstractController;
import com.fgrapp.blog.blogserver.common.exception.MyException;
import com.fgrapp.blog.blogserver.common.util.MD5Util;
import com.fgrapp.blog.blogserver.monitor.entity.LoginLog;
import com.fgrapp.blog.blogserver.monitor.service.ILoginLogService;
import com.fgrapp.blog.blogserver.sys.entity.User;
import com.fgrapp.blog.blogserver.sys.service.IUserService;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LoginController
 *
 * @author FGR on 2019/9/28
 */
@Validated
@RestController
public class LoginController extends AbstractController {
    @Autowired
    private IUserService userService;
    @Autowired
    private ILoginLogService loginLogService;
    @Autowired
    private ShiroHelper shiroHelper;

    @PostMapping("login")
    @Limit(key = "login", period = 60, count = 20, name = "登录接口", prefix = "limit")
    public Result login(
            @NotBlank(message = "{required}") String username,
            @NotBlank(message = "{required}") String password,
            boolean rememberMe, HttpServletRequest request){
        password = MD5Util.encrypt(username.toLowerCase(), password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        super.login(token);
        // 保存登录日志
        LoginLog loginLog = new LoginLog();
        loginLog.setUsername(username);
        loginLog.setSystemBrowserInfo();
        this.loginLogService.saveLoginLog(loginLog);
        return Result.ok().put("token", getSession().getId());
    }
    @PostMapping("regist")
    public Result regist(
            @NotBlank(message = "{required}") String username,
            @NotBlank(message = "{required}") String password
    ){
        User user = userService.findByName(username);
        if (user != null) {
            throw new MyException("该用户名已存在");
        }
        this.userService.regist(username, password);
        return Result.ok();
    }
    @GetMapping("index/{username}")
    public Result index(@NotBlank(message = "{required}") @PathVariable String username){
        // 更新登录时间
        this.userService.updateLoginTime(username);
        Map<String, Object> data = new HashMap<>();
        // 获取系统访问记录
        Long totalVisitCount = this.loginLogService.findTotalVisitCount();
        data.put("totalVisitCount", totalVisitCount);
        Long todayVisitCount = this.loginLogService.findTodayVisitCount();
        data.put("todayVisitCount", todayVisitCount);
        Long todayIp = this.loginLogService.findTodayIp();
        data.put("todayIp", todayIp);
        // 获取近期系统访问记录
        List<Map<String, Object>> lastSevenVisitCount = this.loginLogService.findLastSevenDaysVisitCount(null);
        data.put("lastSevenVisitCount", lastSevenVisitCount);
        User param = new User();
        param.setUsername(username);
        List<Map<String, Object>> lastSevenUserVisitCount = this.loginLogService.findLastSevenDaysVisitCount(param);
        data.put("lastSevenUserVisitCount", lastSevenUserVisitCount);
        return Result.ok().put("data", data);
    }
}
