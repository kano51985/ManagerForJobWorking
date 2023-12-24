package com.sana.service.impl;

import com.sana.dao.AssetsMapper;
import com.sana.pojo.Assets;
import com.sana.pojo.Projects;
import com.sana.service.AssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AssetsServiceImpl implements AssetsService {
    @Autowired
    @Qualifier("assetsMapper")
    private AssetsMapper assetsMapper;

    //1.查询自己部门的资产
    public List<Assets> getAssetsByDepartmentId(Integer id){
        List<Assets>list= assetsMapper.getAssetsByDepartmentId(id);
        return list;
    };

    //2.根据资产id删除资产
    public void deleteAssetByAid(Integer id){
        assetsMapper.deleteAssetByAid(id);
    };

    //3.添加资产
    public void addAsset(Assets assets){
        assetsMapper.addAsset(assets);
    };

    //4.根据aid修改资产
    public void updateAsset(Assets assets){
        assetsMapper.updateAsset(assets);
    };

    //5.根据aid获取资产信息
    public Assets getAssetByAid(Integer id){
        Assets a=assetsMapper.getAssetByAid(id);
        return a;
    };
}
