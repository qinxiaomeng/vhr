package org.xiaom.vhr.mapper;

import org.xiaom.vhr.model.SysMsg;

public interface SysMsgMapper {
    int insert(SysMsg record);

    int insertSelective(SysMsg record);
}