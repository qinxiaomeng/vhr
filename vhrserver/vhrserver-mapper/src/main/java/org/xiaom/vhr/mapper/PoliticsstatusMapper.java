package org.xiaom.vhr.mapper;

import org.xiaom.vhr.model.Politicsstatus;

import java.util.List;

public interface PoliticsstatusMapper {
    int insert(Politicsstatus record);

    int insertSelective(Politicsstatus record);

    Politicsstatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Politicsstatus record);

    int updateByPrimaryKey(Politicsstatus record);

    List<Politicsstatus> getAllPoliticsstatus();
}