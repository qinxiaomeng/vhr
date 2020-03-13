package org.xiaom.vhr.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author qinxiaomeng
 * @description
 * @date 2020-03-07
 */
@Component
public class CustomUrlDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        //遍历所需的权限
        for(ConfigAttribute configAttribute : configAttributes){
            //所需权限
            String needRole = configAttribute.getAttribute();
            //对ROLE_LOGIN权限单独处理
            if ("ROLE_LOGIN".equals(needRole)) {
                if (authentication instanceof AnonymousAuthenticationToken) {
                    throw new AccessDeniedException("尚未登录，请登录!");
                } else {
                    return;
                }
            }

            //获取登录用户的所有权限
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            /*
            遍历登录用户的权限列表，如果拥有所需权限的任意一个则成功
             */
            for(GrantedAuthority authority : authorities){
                if(authority.getAuthority().equals(needRole)){
                    return;
                }
            }

        }
        throw new AccessDeniedException("权限不足，请联系管理员!");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
