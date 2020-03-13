package org.xiaom.vhr.mapper;

import org.xiaom.vhr.model.AdjustSalary;

public interface AdjustSalaryMapper {
    int insert(AdjustSalary record);

    int insertSelective(AdjustSalary record);
}