package org.xiaom.vhr.utils;


import org.springframework.security.core.context.SecurityContextHolder;
import org.xiaom.vhr.model.Hr;

/**
 * @author qinxiaomeng
 * @description
 * @date 2020-03-11
 */
public class HrUtils {
    public static Hr getCurrentHr(){
        return (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
