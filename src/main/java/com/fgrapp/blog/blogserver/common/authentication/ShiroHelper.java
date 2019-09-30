package com.fgrapp.blog.blogserver.common.authentication;

import com.fgrapp.blog.blogserver.common.annotation.Helper;
import org.apache.shiro.authz.AuthorizationInfo;

/**
 * ShiroHelper
 *
 * @author FGR on 2019/9/29
 */
@Helper
public class ShiroHelper extends ShiroRealm {

    /**
     * 获取当前用户的角色和权限集合
     *
     * @return AuthorizationInfo
     */
    public AuthorizationInfo getCurrentuserAuthorizationInfo() {
        return super.doGetAuthorizationInfo(null);
    }
}

