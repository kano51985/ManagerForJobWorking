package com.sana.service;

import com.sana.pojo.Authorizations;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AuthorizationsService {
    //1.查询所有角色
    public List<Authorizations> getAllRole();
}
