package com.sana.service;

import com.sana.pojo.DailyReports;
import com.sana.pojo.WeeklyReports;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DailyReportsService {
    //1.根据部门ID查询当前部门的所有日报
    public List<DailyReports> getAllDailyDataByDepartment(Integer id);

    //2.根据id删除指定用户的周报记录
    public void deleteDailyDataById(Integer id);

    //3.根据id修改账号内容信息
    public void updateDailyReports(DailyReports user);

    //4.根据id查询指定用户
    public DailyReports getUserDailyReportsById(Integer id);

    //5.添加周报信息
    public  void addDailyReports(DailyReports dailyReports);

    //6.批阅评论
    public void submitDailyComment(DailyReports user);

    //7.查询当前用户的周报记录
    public List<DailyReports> getAllDailyDataById(Integer id);
}