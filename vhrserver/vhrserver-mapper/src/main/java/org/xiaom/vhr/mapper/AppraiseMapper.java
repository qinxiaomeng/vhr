package org.xiaom.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.xiaom.vhr.model.Appraise;

import java.util.Date;
import java.util.List;

public interface AppraiseMapper {
    int insert(Appraise record);

    int insertSelective(Appraise record);

    List<Appraise> getAppraiseWithEmpByPage(@Param("page") Integer page, @Param("size") Integer Size,
                                            @Param("empName")String empName, @Param("beginDateScope") Date[] beginDateScope);
    Long getTotal(@Param("empName") String empName,  @Param("beginDateScope") Date[] beginDateScope);
}