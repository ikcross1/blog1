package com.nnxy.blog.config;

import com.nnxy.blog.shiro.ShiroRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //提供一个Realm的示例
    @Bean
    ShiroRealm shiroRealm(){
        ShiroRealm shiroRealm = new ShiroRealm();
        return shiroRealm;
    }
    @Bean
    //配置一个SecurityManager，在里面SecurityManager配置Realm
    DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(new ShiroRealm());
        return manager;
    }
    @Bean
    //配置一个ShiroFilterFactoryBean，
    // 在ShiroFilterFactoryBean里指定路径拦截规则等
    ShiroFilterFactoryBean shiroFilterFactoryBean (){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();

        //指定SecuityManager
        bean.setSecurityManager(securityManager());
        //指定登录页面
        bean.setLoginUrl("admin_login");
        //指定登录成功页面
        bean.setSuccessUrl("admin_index");

        bean.setUnauthorizedUrl("/unauthorizedUrl");
        //指定路径拦截规则，有序
        /**
         * 过滤器名称
         * anon：不验证
         * authc：必须登录
         * perms：权限认证
         * roles：角色认证
         */
        Map<String,String> map = new LinkedHashMap<>();
        map.put("/login","anon");
        map.put("/tBlog/admin_blogs","authc");//必须登录
        map.put("/tType/admin_types","authc");//必须登录
        map.put("/tFriend/admin_friendsLinks","authc");//必须登录
        map.put("/tPicture/admin_pictures","authc");//必须登录
        map.put("/tBlog/admin_blogsInputs","authc");//必须登录
        map.put(" /tFriend/admin_friendsInputs","authc");//必须登录
        map.put("/tPicture/admin_picturesInputs","authc");//必须登录
        map.put("/tType/admin_typesInputs","authc");//必须登录

        bean.setFilterChainDefinitionMap(map);

        return bean;
    }
}
