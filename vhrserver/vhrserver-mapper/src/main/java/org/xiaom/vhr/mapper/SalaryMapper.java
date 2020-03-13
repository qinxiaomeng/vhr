package org.xiaom.vhr.mapper;

import org.xiaom.vhr.model.Salary;

public interface SalaryMapper {
    int insert(Salary record);

    int insertSelective(Salary record);
}