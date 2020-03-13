package org.xiaom.vhr.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xiaom.vhr.model.Hr;
import org.xiaom.vhr.model.Role;
import org.xiaom.vhr.service.HrService;
import org.xiaom.vhr.service.RoleService;

import java.util.List;

/**
 * @author qinxiaomeng
 * @description
 * @date 2020-03-11
 */
@RestController
@RequestMapping("/system/hr")
public class HrController {

    @Autowired
    private HrService hrService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/")
    public List<Hr> getAllHrs(String keywords) {
        return hrService.selectAllHrs(keywords);
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }
}
