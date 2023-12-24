package com.sana.dao;

import com.sana.pojo.Authorizations;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AuthorizationsMapper {
    //1.查询所有角色
    @Select("SELECT * FROM authorizations")
    public List<Authorizations> getAllRole();
}
