package com.sana.service;

import com.sana.pojo.DailyReports;
import com.sana.pojo.Employees;
import com.sana.pojo.WeeklyReports;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface WeeklyReportsService {
    //1.根据部门ID查询当前部门的所有周报
    public List<WeeklyReports> getAllWeeklyDataByDepartment(Integer id);

    //2.根据id删除指定用户的周报记录
    public void deleteWeeklyDataById(Integer id);

    //3.根据id修改账号内容信息
    public void updateWeeklyReports(WeeklyReports user);

    //4.根据id查询指定用户
    public WeeklyReports getUserWeeklyReportsById(Integer id);

    //5.添加周报信息
    public void addWeeklyReports(WeeklyReports weeklyReports);

    //6.批阅评论
    public void submitWeeklyComment(WeeklyReports user);

    //7.查询当前用户的周报记录
    public List<WeeklyReports> getAllWeeklyDataById(Integer id);

}