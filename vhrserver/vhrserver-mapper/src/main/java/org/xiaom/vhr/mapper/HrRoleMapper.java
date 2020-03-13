package org.xiaom.vhr.mapper;

import org.xiaom.vhr.model.HrRole;

public interface HrRoleMapper {
    int insert(HrRole record);

    int insertSelective(HrRole record);
}