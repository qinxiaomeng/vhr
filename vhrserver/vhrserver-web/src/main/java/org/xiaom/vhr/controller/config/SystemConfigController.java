package org.xiaom.vhr.controller.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xiaom.vhr.model.RespBean;
import org.xiaom.vhr.service.MenuService;

/**
 * @author qinxiaomeng
 * @description
 * @date 2020-03-09
 */
@RestController
@RequestMapping("/system/config")
public class SystemConfigController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/menu")
    public RespBean getMenusByHrId(){
        return RespBean.ok("", menuService.getMenusByHrId());
    }
}
