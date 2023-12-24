package com.sana.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sana.pojo.Assets;
import com.sana.service.AssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RequestMapping("/asset")
@Controller
public class AssetsController {
    @Autowired
    private AssetsService assetsService;

    //1.获取当前部门全部资产
    @RequestMapping("/getAssetByDepartmentId")
    public String getAssetByDepartmentId(Integer id, HttpServletRequest request){
        System.out.println("-----------------1.获取当前部门全部资产-------------------");
        List<Assets> list= assetsService.getAssetsByDepartmentId(id);
        request.setAttribute("showmetheassets",list);
        return "assetList";
    }

    //2.根据aid删除资产
    @RequestMapping("/deleteAssetByAid")
    public String deleteAssetByAid(Integer id,Integer Did){
        System.out.println("-----------------2.根据aid删除资产---------------");
        assetsService.deleteAssetByAid(id);
        return "redirect:/asset/getAssetByDepartmentId?id="+Did;
    }

    //3.添加资产
    @RequestMapping("/addAsset")
    public String addAsset(Assets assets){
        System.out.println("--------------3.添加资产--------------");
        assetsService.addAsset(assets);
        return "redirect:/asset/getAssetByDepartmentId?id="+assets.getDepartment_id();
    }

    //4.根据aid修改资产
    @RequestMapping("/updateAsset")
    public String updateAsset(Assets assets){
        System.out.println("---------------4.根据aid修改资产----------------");
        assetsService.updateAsset(assets);
        return "redirect:/asset/getAssetByDepartmentId?id="+assets.getDepartment_id();
    }

    //5.根据aid查询资产信息
    @RequestMapping("/getAssetByAid")
    public String getAssetByAid(Integer id,HttpServletRequest request){
        System.out.println("------------5.根据aid查询资产信息-------------");
        Assets assets= assetsService.getAssetByAid(id);
        request.setAttribute("showmetheasset",assets);
        return "assetDetail";
    }
}
