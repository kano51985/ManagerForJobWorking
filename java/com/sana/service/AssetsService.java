package com.sana.service;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sana.pojo.Assets;
import com.sana.pojo.Projects;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AssetsService {
    //1.查询自己部门的资产
    public List<Assets> getAssetsByDepartmentId(Integer id);

    //2.根据资产id删除资产
    public void deleteAssetByAid(Integer id);

    //3.添加资产
    public void addAsset(Assets assets);

    //4.根据aid修改资产
    public void updateAsset(Assets assets);

    //5.根据aid获取资产信息
    public Assets getAssetByAid(Integer id);
}
