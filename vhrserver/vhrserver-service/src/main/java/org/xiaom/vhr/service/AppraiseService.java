package org.xiaom.vhr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xiaom.vhr.mapper.AppraiseMapper;
import org.xiaom.vhr.model.Appraise;
import org.xiaom.vhr.model.RespPageBean;

import java.util.Date;
import java.util.List;

/**
 * @author qinxiaomeng
 * @description
 * @date 2020-03-17
 */
@Service
public class AppraiseService {

    @Autowired
    private AppraiseMapper appraiseMapper;

    public RespPageBean getAppraiseByPage(Integer page, Integer size, String empName, Date[] beginDateScope){
        if(page != null && size != null){
            page = (page - 1) * size;
        }
        List<Appraise> results = appraiseMapper.getAppraiseWithEmpByPage(page, size, empName, beginDateScope);
        Long total = appraiseMapper.getTotal(empName, beginDateScope);

        RespPageBean rpb = new RespPageBean();
        rpb.setData(results);
        rpb.setTotal(total);

        return rpb;
    }
}
