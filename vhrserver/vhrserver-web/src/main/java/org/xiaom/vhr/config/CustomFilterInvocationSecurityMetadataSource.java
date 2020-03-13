package org.xiaom.vhr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.xiaom.vhr.model.Menu;
import org.xiaom.vhr.model.Role;
import org.xiaom.vhr.service.MenuService;

import java.util.Collection;
import java.util.List;

/**
 * @author qinxiaomeng
 * @description
 * @date 2020-03-06
 */
@Component
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    MenuService menuService;

    AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //请求地址
        String requestUrl = ((FilterInvocation)o).getRequestUrl();
        /*
        获取菜单及其对应的角色列表
         */
        List<Menu> menus = menuService.getAllMenusWithRole();

        for(Menu menu : menus){
            /*
            如果请求地址和该menu的url pattern匹配，则返回对应角色的name数组
            即：这个规则的路径需要哪些角色才能访问
            问题：这里我使用url pattern来匹配，这里有一个优先级的问题，如/employee/basic/hello既能备/employee/**匹配，
            同时也能被/employee/basic/**匹配，这里我们需要将/employee/basic/**排在前面。

             排序原则：精确的排在前面，模糊匹配放在后面
             */
            if(antPathMatcher.match(menu.getUrl(), requestUrl)){
                List<Role> roles = menu.getRoles();
                String[] str = new String[roles.size()];
                for(int i = 0; i < roles.size(); i++){
                    str[i] = roles.get(i).getName();
                }
                //利用SecurityConfig.createList方法创建一个角色集合
                return SecurityConfig.createList(str);
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
