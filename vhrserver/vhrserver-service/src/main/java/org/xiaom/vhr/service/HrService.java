package org.xiaom.vhr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xiaom.vhr.mapper.HrMapper;
import org.xiaom.vhr.model.Hr;
import org.xiaom.vhr.utils.HrUtils;

import java.util.List;

/**
 * @author qinxiaomeng
 * @description
 * @date 2020-03-06
 */
@Service
@Transactional
public class HrService implements UserDetailsService {
    @Autowired
    HrMapper hrMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(s);
        if(hr == null){
            throw new UsernameNotFoundException("用户名错误");
        }
        hr.setRoles(hrMapper.getHrRolesById(hr.getId()));
        return hr;
    }

    public List<Hr> selectAllHrs(String keywords){
        Hr hr = HrUtils.getCurrentHr();
        return hrMapper.getAllHrs(hr.getId(), keywords);
    }
}
