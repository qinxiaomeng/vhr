package org.xiaom.vhr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xiaom.vhr.model.RespBean;

/**
 * @author qinxiaomeng
 * @description
 * @date 2020-03-07
 */
@RestController
public class LoginController {
    @GetMapping("/login")
    public RespBean login() {
        return RespBean.error("尚未登录，请登录!");
    }
}
