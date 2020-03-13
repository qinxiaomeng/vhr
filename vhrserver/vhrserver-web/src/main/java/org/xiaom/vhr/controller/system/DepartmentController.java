package org.xiaom.vhr.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xiaom.vhr.model.Department;
import org.xiaom.vhr.model.RespBean;
import org.xiaom.vhr.service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/system/basic/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PostMapping("/")
    public RespBean addDep(@RequestBody Department dep) {
        departmentService.addDep(dep);
        return RespBean.ok("添加成功", dep);
    }

    @DeleteMapping("/{id}")
    public RespBean deleteDepById(@PathVariable Integer id) {
        Department dep = new Department();
        dep.setId(id);
        departmentService.deleteDepById(dep);
        return RespBean.ok("删除成功");
    }
}