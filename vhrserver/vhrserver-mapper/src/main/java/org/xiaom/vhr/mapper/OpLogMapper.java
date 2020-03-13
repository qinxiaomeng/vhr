package org.xiaom.vhr.mapper;

import org.xiaom.vhr.model.OpLog;

public interface OpLogMapper {
    int insert(OpLog record);

    int insertSelective(OpLog record);
}