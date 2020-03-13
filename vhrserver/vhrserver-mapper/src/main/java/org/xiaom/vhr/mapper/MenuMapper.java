package org.xiaom.vhr.mapper;

import org.xiaom.vhr.model.Menu;

import java.util.List;

public interface MenuMapper {
    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> getAllMenusWithRole();

    List<Menu> getAllMenus();

    List<Menu> getMenusByHrId(Integer hrId);
}