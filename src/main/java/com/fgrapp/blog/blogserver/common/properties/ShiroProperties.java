package com.fgrapp.blog.blogserver.common.properties;

import lombok.Data;

/**
 * ShiroProperties
 *
 * @author FGR on 2019/9/28
 */
@Data
public class ShiroProperties {

    private long sessionTimeout;
    private int cookieTimeout;
    private String anonUrl;
    private String loginUrl;
    private String successUrl;
    private String logoutUrl;
    private String unauthorizedUrl;
}
