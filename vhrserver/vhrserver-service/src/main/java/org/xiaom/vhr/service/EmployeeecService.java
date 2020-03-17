package org.xiaom.vhr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xiaom.vhr.mapper.EmployeeecMapper;
import org.xiaom.vhr.model.Employeeec;
import org.xiaom.vhr.model.RespPageBean;

import java.util.Date;
import java.util.List;

/**
 * @author qinxiaomeng
 * @description
 * @date 2020-03-14
 */
@Service
public class EmployeeecService {

    @Autowired
    EmployeeecMapper employeeecMapper;

    public RespPageBean listEmployeeecByPage(Integer page, Integer size, String empName, Date[] beginDateScope){
        if(page != null && size != null){
            page = (page - 1) * size;
        }

        List<Employeeec> data = employeeecMapper.listEmployeecInfoByPage(page, size, empName, beginDateScope);
        Long total = employeeecMapper.getTotal(empName, beginDateScope);

        RespPageBean rpb = new RespPageBean();
        rpb.setData(data);
        rpb.setTotal(total);

        return rpb;
    }
}
