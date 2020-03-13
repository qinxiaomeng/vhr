package org.xiaom.vhr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xiaom.vhr.mapper.RoleMapper;
import org.xiaom.vhr.model.Role;

import java.util.List;

/**
 * @author qinxiaomeng
 * @description
 * @date 2020-03-11
 */
@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;

    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    public Integer addRole(Role role) {
        if (!role.getName().startsWith("ROLE_")) {
            role.setName("ROLE_" + role.getName());
        }
        return roleMapper.insert(role);
    }

    public int deleteRoleById(Integer rid) {
        return 0;
    }
}
