package org.xiaom.vhr.mapper;

import org.xiaom.vhr.model.MsgContent;

public interface MsgContentMapper {
    int insert(MsgContent record);

    int insertSelective(MsgContent record);
}