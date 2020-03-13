package org.xiaom.vhr.mapper;

import org.xiaom.vhr.model.Appraise;

public interface AppraiseMapper {
    int insert(Appraise record);

    int insertSelective(Appraise record);
}