package org.xiaom.vhr.mapper;

import org.xiaom.vhr.model.MenuRole;

public interface MenuRoleMapper {
    int insert(MenuRole record);

    int insertSelective(MenuRole record);
}