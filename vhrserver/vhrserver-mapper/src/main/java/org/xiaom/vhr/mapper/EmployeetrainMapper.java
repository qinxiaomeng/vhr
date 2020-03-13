package org.xiaom.vhr.mapper;

import org.xiaom.vhr.model.Employeetrain;

public interface EmployeetrainMapper {
    int insert(Employeetrain record);

    int insertSelective(Employeetrain record);
}