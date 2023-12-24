package com.sana.service.impl;

import com.sana.dao.EmployeesMapper;
import com.sana.dao.WeeklyReportsMapper;
import com.sana.pojo.Employees;
import com.sana.pojo.WeeklyReports;
import com.sana.service.WeeklyReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeeklyReportsServiceImpl implements WeeklyReportsService {
    @Autowired
    @Qualifier("weeklyReportsMapper")
    private WeeklyReportsMapper weeklyReportsMapper;

    //1.根据部门ID查询当前部门的所有周报
    public List<WeeklyReports> getAllWeeklyDataByDepartment(Integer id){
        List<WeeklyReports> list=weeklyReportsMapper.getAllWeeklyDataByDepartment(id);
        return list;
    }

    //2.根据id删除指定用户的周报记录
    public void deleteWeeklyDataById(Integer id){
        weeklyReportsMapper.deleteWeeklyDataById(id);
    }

    //3.根据id修改账号内容信息
    public void updateWeeklyReports(WeeklyReports user){
        weeklyReportsMapper.updateWeeklyReports(user);
    }

    //4.根据id查询指定用户
    public WeeklyReports getUserWeeklyReportsById(Integer id){
        WeeklyReports weeklyReports=weeklyReportsMapper.getUserWeeklyReportsById(id);
        return weeklyReports;
    }

    //5.添加周报信息
    public void addWeeklyReports(WeeklyReports weeklyReports){
        weeklyReportsMapper.addWeeklyReports(weeklyReports);
    }

    //6.批阅评论
    public void submitWeeklyComment(WeeklyReports user){
        weeklyReportsMapper.submitWeeklyComment(user);
    }

    //7.查询当前用户的周报记录
    public List<WeeklyReports> getAllWeeklyDataById(Integer id){
        List<WeeklyReports> list=weeklyReportsMapper.getAllWeeklyDataById(id);
        return list;
    }

}
