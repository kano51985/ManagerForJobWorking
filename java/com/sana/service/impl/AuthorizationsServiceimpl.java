package com.sana.service.impl;

import com.sana.dao.AuthorizationsMapper;
import com.sana.pojo.Authorizations;
import com.sana.service.AuthorizationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorizationsServiceimpl implements AuthorizationsService {
    @Autowired
    @Qualifier("authorizationsMapper")
    public AuthorizationsMapper authorizationsMapper;

    //1.查询所有角色
    public List<Authorizations> getAllRole(){
        List<Authorizations>list= authorizationsMapper.getAllRole();
        return list;
    };
}
