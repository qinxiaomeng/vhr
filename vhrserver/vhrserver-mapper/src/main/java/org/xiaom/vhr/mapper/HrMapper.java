package org.xiaom.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.xiaom.vhr.model.Hr;
import org.xiaom.vhr.model.Role;

import java.util.List;

public interface HrMapper {
    int insert(Hr record);

    int insertSelective(Hr record);

    Hr loadUserByUsername(String username);

    List<Role> getHrRolesById(Integer id);

    List<Hr> selectById(Integer id);
    List<Hr> getAllHrs(@Param("hrid") Integer hrid, @Param("keywords") String keywords);
}