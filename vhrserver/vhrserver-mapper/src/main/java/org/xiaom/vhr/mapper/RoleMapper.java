package org.xiaom.vhr.mapper;

import org.xiaom.vhr.model.Role;

import java.util.List;

public interface RoleMapper {
    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> getAllRoles();
}