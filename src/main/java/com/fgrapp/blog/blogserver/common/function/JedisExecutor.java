package com.fgrapp.blog.blogserver.common.function;

import com.fgrapp.blog.blogserver.common.exception.RedisConnectException;

/**
 * JedisExecutor
 *
 * @author FGR on 2019/9/28
 */
@FunctionalInterface
public interface JedisExecutor<T, R> {
    R excute(T t) throws RedisConnectException;
}
