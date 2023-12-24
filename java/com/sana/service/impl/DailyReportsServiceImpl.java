package com.sana.service.impl;

import com.sana.dao.DailyReportsMapper;
import com.sana.dao.WeeklyReportsMapper;
import com.sana.pojo.DailyReports;
import com.sana.pojo.WeeklyReports;
import com.sana.service.DailyReportsService;
import com.sana.service.WeeklyReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyReportsServiceImpl implements DailyReportsService {
    @Autowired
    @Qualifier("dailyReportsMapper")
    private DailyReportsMapper dailyReportsMapper;

    //1.根据部门ID查询当前部门的所有日报
    public List<DailyReports> getAllDailyDataByDepartment(Integer id){
        List<DailyReports> list=dailyReportsMapper.getAllDailyDataByDepartment(id);
        return list;
    }

    //2.根据id删除指定用户的周报记录
    public void deleteDailyDataById(Integer id){
        dailyReportsMapper.deleteDailyDataById(id);
    }

    //3.根据id修改账号内容信息
    public void updateDailyReports(DailyReports user){
        dailyReportsMapper.updateDailyReports(user);
    }

    //4.根据id查询指定用户
    public DailyReports getUserDailyReportsById(Integer id){
        DailyReports dailyReports=dailyReportsMapper.getUserDailyReportsById(id);
        return dailyReports;
    }

    //5.添加周报信息
    public void addDailyReports(DailyReports dailyReports){
        dailyReportsMapper.addDailyReports(dailyReports);
    }

    //6.批阅评论
    public void submitDailyComment(DailyReports user){
        dailyReportsMapper.submitDailyComment(user);
    }

    //7.查询当前用户的周报记录
    public List<DailyReports> getAllDailyDataById(Integer id){
        List<DailyReports> list=dailyReportsMapper.getAllDailyDataById(id);
        return list;
    }

}
