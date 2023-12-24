package com.sana.dao;
import com.sana.pojo.WeeklyReports;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
public interface WeeklyReportsMapper {

    //1.根据部门ID查询当前部门的所有周报
    public List<WeeklyReports> getAllWeeklyDataByDepartment(Integer id);

    //2.根据id删除指定用户的周报记录
    @Delete("DELETE FROM weekly_reports WHERE report_id=#{report_id}")
    public void deleteWeeklyDataById(Integer id);

    //3.根据id修改账号内容信息
    @Update("UPDATE weekly_reports SET content=#{content} WHERE report_id=#{report_id}")
    public void updateWeeklyReports(WeeklyReports user);

    //4.根据id查询指定用户
    public WeeklyReports getUserWeeklyReportsById(Integer id);

    //5.添加周报信息
    @Insert("INSERT INTO weekly_reports (employee_id,report_date,content) VALUES(#{employee_id},#{report_date},#{content})")
    public  void addWeeklyReports(WeeklyReports weeklyReports);

    //6.批阅评论
    @Update("UPDATE weekly_reports SET comments=#{comments} WHERE report_id=#{report_id}")
    public void submitWeeklyComment(WeeklyReports user);

    //7.查询当前用户的周报记录
    public List<WeeklyReports> getAllWeeklyDataById(Integer id);
}
