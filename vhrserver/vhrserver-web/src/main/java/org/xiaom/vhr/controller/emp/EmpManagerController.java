package org.xiaom.vhr.controller.emp;

import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xiaom.vhr.model.RespBean;
import org.xiaom.vhr.model.RespPageBean;
import org.xiaom.vhr.service.AppraiseService;
import org.xiaom.vhr.service.EmployeeService;
import org.xiaom.vhr.service.EmployeeecService;

import java.util.Date;

/**
 * @author qinxiaomeng
 * @description
 * @date 2020-03-14
 */
@RestController
@RequestMapping("/emp/manager")
public class EmpManagerController {

    @Autowired
    EmployeeecService employeeecService;
    @Autowired
    AppraiseService appraiseService;
    @Autowired
    EmployeeService employeeService;


    @GetMapping("/emp_ec_info_by_page")
    public RespPageBean getEmpEcByPage(@RequestParam(defaultValue="1") Integer page,
                                       @RequestParam(defaultValue="10") Integer size, String empName, Date[] beginDateScope){
        return employeeecService.listEmployeeecByPage(page, size, empName, beginDateScope);
    }

    @GetMapping("list_appraise")
    public RespPageBean getAppraiseByPage(@RequestParam(defaultValue="1") Integer page,
                                          @RequestParam(defaultValue="10") Integer size, String empName, Date[] beginDateScope){
        return appraiseService.getAppraiseByPage(page, size, empName, beginDateScope);
    }

    @PostMapping("employee_remove")
    public RespBean employeeRemove(Integer empId, Integer newDepId, Integer newJobLevelId,
                                   String reason, String remark){

        employeeService.empRemove(empId, newDepId, newJobLevelId, reason, remark);

        return RespBean.ok("员工调动成功");
    }
}
