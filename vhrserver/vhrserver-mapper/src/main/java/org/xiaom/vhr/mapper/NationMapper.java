package org.xiaom.vhr.mapper;

import org.xiaom.vhr.model.Nation;

import java.util.List;

public interface NationMapper {
    int insert(Nation record);

    int insertSelective(Nation record);

    Nation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Nation record);

    int updateByPrimaryKey(Nation record);

    List<Nation> getAllNations();
}