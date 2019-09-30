package com.fgrapp.blog.blogserver.common.exception;

/**
 * 限流异常
 *
 * @author FGR on 2019/9/28
 */
public class LimitAccessException extends Exception {

    private static final long serialVersionUID = -3608667856397125671L;

    public LimitAccessException(String message) {
        super(message);
    }
}
