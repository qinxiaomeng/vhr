package org.xiaom.vhr.mapper;

import org.xiaom.vhr.model.Department;

import java.util.List;

public interface DepartmentMapper {
    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> getAllDepartmentsByParentId(Integer pid);

    void addDep(Department dep);

    void deleteDepById(Department dep);

    List<Department> getAllDepartments();

    int deleteByPrimaryKey(Integer id);
}