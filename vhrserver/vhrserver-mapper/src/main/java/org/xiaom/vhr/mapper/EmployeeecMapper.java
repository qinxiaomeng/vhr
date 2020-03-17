package org.xiaom.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.xiaom.vhr.model.Employeeec;

import java.util.Date;
import java.util.List;

public interface EmployeeecMapper {
    int insert(Employeeec record);

    int insertSelective(Employeeec record);

    List<Employeeec> listEmployeecInfoByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("empName") String empName,  @Param("beginDateScope") Date[] beginDateScope);
    Long getTotal(@Param("empName") String empName,  @Param("beginDateScope") Date[] beginDateScope);
}