package org.xiaom.vhr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xiaom.vhr.mapper.EmployeeMapper;
import org.xiaom.vhr.mapper.EmployeeremoveMapper;
import org.xiaom.vhr.model.Employee;
import org.xiaom.vhr.model.Employeeremove;
import org.xiaom.vhr.model.RespPageBean;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author qinxiaomeng
 * @description
 * @date 2020-03-13
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    EmployeeremoveMapper employeeremoveMapper;

    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    DecimalFormat decimalFormat = new DecimalFormat("##.00");
    public RespPageBean getEmployeeByPage(Integer page, Integer size, Employee employee, Date[] beginDateScope) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Employee> data = employeeMapper.getEmployeeByPage(page, size, employee, beginDateScope);
        Long total = employeeMapper.getTotal(employee, beginDateScope);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public Integer maxWorkID() {
        return employeeMapper.maxWorkID();
    }

    public Integer addEmp(Employee employee) {
        Date beginContract = employee.getBeginContract();
        Date endContract = employee.getEndContract();
        double month = (Double.parseDouble(yearFormat.format(endContract)) - Double.parseDouble(yearFormat.format(beginContract))) * 12 + (Double.parseDouble(monthFormat.format(endContract)) - Double.parseDouble(monthFormat.format(beginContract)));
        employee.setContractTerm(Double.parseDouble(decimalFormat.format(month / 12)));
        int result = employeeMapper.insertSelective(employee);
        //保存成功后发出offer邮件通知

        return result;
    }

    public Integer empRemove(Integer empId, Integer newDepId, Integer newJobLevelId, String reason, String remark){
        Integer removeResult = employeeMapper.employeeRemove(empId, newDepId, newJobLevelId);
        Employeeremove removeModel = new Employeeremove();
        removeModel.setEid(empId);
        removeModel.setAfterdepid(newDepId);
        removeModel.setAfterjobid(newJobLevelId);
        removeModel.setReason(reason);
        removeModel.setRemark(remark);
        removeModel.setRemovedate(new Date());
        employeeremoveMapper.insertSelective(removeModel);
        return removeResult;
    }
}
