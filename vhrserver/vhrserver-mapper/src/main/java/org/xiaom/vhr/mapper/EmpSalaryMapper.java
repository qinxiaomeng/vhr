package org.xiaom.vhr.mapper;

import org.xiaom.vhr.model.EmpSalary;

public interface EmpSalaryMapper {
    int insert(EmpSalary record);

    int insertSelective(EmpSalary record);
}