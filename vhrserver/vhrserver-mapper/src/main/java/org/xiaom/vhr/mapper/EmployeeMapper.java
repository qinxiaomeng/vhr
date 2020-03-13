package org.xiaom.vhr.mapper;

import org.xiaom.vhr.model.Employee;

public interface EmployeeMapper {
    int insert(Employee record);

    int insertSelective(Employee record);
}