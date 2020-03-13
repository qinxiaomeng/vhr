package org.xiaom.vhr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.xiaom.vhr.mapper.MenuMapper;
import org.xiaom.vhr.model.Hr;
import org.xiaom.vhr.model.Menu;

import java.util.List;

/**
 * @author qinxiaomeng
 * @description
 * @date 2020-03-06
 */
@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;

    /**
     * 获取所有菜单及其权限列表
     * @return
     */
    public List<Menu> getAllMenusWithRole() {
        return menuMapper.getAllMenusWithRole();
    }

    /**
     * 根据登录用户获取菜单
     * @return
     */
    public List<Menu> getMenusByHrId() {
        Hr hr = (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return menuMapper.getMenusByHrId(hr.getId());
    }

    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }

    public List<Integer> getMidsByRid(Integer rid) {
        return null;
    }

    public boolean updateMenuRole(Integer rid, Integer[] mids) {
        return false;
    }
}
