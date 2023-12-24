package com.sana.dao;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sana.pojo.Assets;
import com.sana.pojo.Projects;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AssetsMapper {
    //1.查询自己部门的资产
    @Select("SELECT * FROM assets WHERE department_id=#{department_id}")
    public List<Assets> getAssetsByDepartmentId(Integer id);

    //2.根据资产id删除资产
    @Delete("DELETE FROM assets WHERE asset_id=#{asset_id}")
    public void deleteAssetByAid(Integer id);

    //3.添加资产
    @Insert("INSERT INTO assets(department_id,asset_name)"  +
            " VALUES(#{department_id},#{asset_name})")
    public void addAsset(Assets assets);

    //4.根据aid修改资产
    @Update("UPDATE assets SET asset_name=#{asset_name} " +
            " WHERE asset_id=#{asset_id}")
    public void updateAsset(Assets assets);

    //5.根据aid获取资产信息
    @Select("SELECT * FROM assets WHERE asset_id=#{asset_id}")
    public Assets getAssetByAid(Integer id);
}
