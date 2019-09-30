package com.fgrapp.blog.blogserver.common.aspect;

import com.fgrapp.blog.blogserver.common.annotation.ControllerEndpoint;
import com.fgrapp.blog.blogserver.common.exception.MyException;
import com.fgrapp.blog.blogserver.common.util.HttpContextUtil;
import com.fgrapp.blog.blogserver.common.util.Util;
import com.fgrapp.blog.blogserver.monitor.service.ILogService;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * ControllerEndpointAspect
 *
 * @author FGR on 2019/9/29
 */
@Aspect
@Component
public class ControllerEndpointAspect extends AspectSupport {

    @Autowired
    private ILogService logService;

    @Pointcut("@annotation(com.fgrapp.blog.blogserver.common.annotation.ControllerEndpoint)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws MyException {
        Object result;
        Method targetMethod = resolveMethod(point);
        ControllerEndpoint annotation = targetMethod.getAnnotation(ControllerEndpoint.class);
        String operation = annotation.operation();
        long start = System.currentTimeMillis();
        try {
            result = point.proceed();
            if (StringUtils.isNotBlank(operation)) {
                HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
                logService.saveLog(point, targetMethod, request, operation, start);
            }
            return result;
        } catch (Throwable throwable) {
            String exceptionMessage = annotation.exceptionMessage();
            String message = throwable.getMessage();
            String error = Util.containChinese(message) ? exceptionMessage + "，" + message : exceptionMessage;
            throw new MyException(error);
        }
    }
}
