package com.nnxy.blog.shiro;

import com.nnxy.blog.entity.TUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ShiroRealm extends AuthorizingRealm {

    @Override
    @Bean
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        TUser user = (TUser) principals.getPrimaryPrincipal();
        return null;
    }

    @Override
    @Bean
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userUsername = (String) token.getPrincipal();
        if(!"ikcross".equals(userUsername)){
            throw new UnknownAccountException("账户不存在");
        }
        return new SimpleAuthenticationInfo(userUsername,"1158199052xx",getName());
    }
}
