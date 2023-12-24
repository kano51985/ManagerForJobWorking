package com.sana.dao;

import com.sana.pojo.DailyReports;
import com.sana.pojo.WeeklyReports;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DailyReportsMapper {
    //1.根据部门ID查询当前部门的所有日报
    public List<DailyReports> getAllDailyDataByDepartment(Integer id);

    //2.根据id删除指定用户的周报记录
    @Delete("DELETE FROM daily_reports WHERE report_id=#{report_id}")
    public void deleteDailyDataById(Integer id);

    //3.根据id修改账号内容信息
    @Update("UPDATE daily_reports SET content=#{content} WHERE report_id=#{report_id}")
    public void updateDailyReports(DailyReports user);

    //4.根据id查询指定用户
    public DailyReports getUserDailyReportsById(Integer id);

    //5.添加周报信息
    @Insert("INSERT INTO daily_reports (employee_id,report_date,content) VALUES(#{employee_id},#{report_date},#{content})")
    public  void addDailyReports(DailyReports weeklyReports);

    //6.批阅评论
    @Update("UPDATE daily_reports SET comments=#{comments} WHERE report_id=#{report_id}")
    public void submitDailyComment(DailyReports user);

    //7.查询当前用户的周报记录
    public List<DailyReports> getAllDailyDataById(Integer id);
}
