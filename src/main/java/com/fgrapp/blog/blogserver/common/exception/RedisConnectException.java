package com.fgrapp.blog.blogserver.common.exception;

/**
 * Redis 连接异常
 *
 * @author FGR on 2019/9/28
 */
public class RedisConnectException extends Exception {

    private static final long serialVersionUID = 1914235761308224609L;

    public RedisConnectException(String message) {
        super(message);
    }
}
