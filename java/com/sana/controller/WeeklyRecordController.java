package com.sana.controller;

import com.sana.pojo.Employees;
import com.sana.pojo.WeeklyReports;
import com.sana.service.EmployeesService;
import com.sana.service.WeeklyReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class WeeklyRecordController {

    @Autowired
    private WeeklyReportsService weeklyReportsService;

    @Autowired
    private EmployeesService employeesService;

    //1.查询全部记录
    @RequestMapping("/getAllWeeklyData")
    public String getAllWeeklyData(HttpServletRequest httpServletRequest,HttpSession httpSession,Integer id) {
        System.out.println("-----------查询全部用户记录（1）--------------");
        Employees user2 = (Employees) httpSession.getAttribute("user");
        // 获取用户的所有信息(调用service方法获取）
        Employees user = employeesService.myCenter(user2);
        if (user.getAuthorization_id() == 2||user.getAuthorization_id() == 3) { //如果是经理和普通用户查看周报记录
            List<WeeklyReports> list = weeklyReportsService.getAllWeeklyDataByDepartment(id);//得到经理所在部门的所有周报记录
            System.out.println("list:" + list);
            //将查询的所有用户信息存放在request中,取名weeklyList
            httpServletRequest.setAttribute("weeklyList", list);
            List<WeeklyReports> list2 = weeklyReportsService.getAllWeeklyDataById(id);//得到当前员工的所有周报记录
            System.out.println("list2:" + list2);
            //将查询的所有用户信息存放在request中,取名weeklyList2
            httpServletRequest.setAttribute("weeklyList2", list2);
            return "weeklyDataList";
        }//否则是管理员，因为管理员没有权限
        return "weeklyDataList";//随便写的 不然报错，因为在left页面里面把管理员的权限禁用了，所以跳转了也看不到
    }

    //2.根据id删除指定用户记录
    @RequestMapping("/deleteWeeklyDataById")
    public String deleteWeeklyDataById(Integer id,HttpSession httpSession){
        System.out.println("----------根据id删除指定用户记录(2)----------");
        weeklyReportsService.deleteWeeklyDataById(id);

        // 从HttpSession中获取存储的User对象
        Employees user2 = (Employees) httpSession.getAttribute("user");
        // 获取用户的所有信息(调用service方法获取）
        Employees user = employeesService.myCenter(user2);//获取当前用户的信息，存入user中

        // 可以将用户信息存储到request中，以便在页面上显示
        httpSession.setAttribute("user", user);
        return "redirect:/user/getAllWeeklyData?id="+ user.getEmployee_id();//重定向getAllWeeklyData请求并把当前用户的Employee_id传过去
    }

    //3.根据用户修改数据
    @RequestMapping("/updateWeeklyReports")
    public String updateWeeklyReports(WeeklyReports user,HttpSession httpSession){
        System.out.println("-----------更新用户信息方法（3）--------------");
        //根据ID查找指定的用户信息
        weeklyReportsService.updateWeeklyReports(user);
        // 从HttpSession中获取存储的User对象
        Employees user2 = (Employees) httpSession.getAttribute("user");
        // 获取用户的所有信息(调用service方法获取）
        Employees user3 = employeesService.myCenter(user2);

        // 可以将用户信息存储到request中，以便在页面上显示
        httpSession.setAttribute("user", user3);
        return "redirect:/user/getAllWeeklyData?id="+ user3.getEmployee_id();//同上
    }

    //4.进入修改页面
    @RequestMapping("/toEditWeeklyRecord")
    public String toEditWeeklyRecord(Integer id,HttpServletRequest request){
        System.out.println("----------根据id修改指定用户周报信息(5)----------");
        //根据ID查找指定的用户信息
        WeeklyReports user=weeklyReportsService.getUserWeeklyReportsById(id);
        System.out.println("user----------------------:"+user);
        //将用户返回到request中
        request.setAttribute("weeklyRecord",user);
        return "editWeeklyRecord";
    }

    //5.进入周报页面
    @RequestMapping("/toWeek")
    public String toWeek( HttpSession httpSession){
        // 从HttpSession中获取存储的User对象
        Employees user2 = (Employees) httpSession.getAttribute("user");

        // 获取用户的所有信息(调用service方法获取）
        Employees user = employeesService.myCenter(user2);//用来获取当前用户的信息

        // 在控制台输出获取到的用户信息
        System.out.println("user: " + user);

        // 可以将用户信息存储到request中，以便在页面上显示
        httpSession.setAttribute("user", user);
        return "submitWeeklyData";//跳转周报页面
    }

    //6.提交周报
    @RequestMapping("/addWeeklyData")
    public String addWeeklyReports(WeeklyReports weeklyReports,HttpSession httpSession){
        System.out.println("----------------weeklyReports-----------:"+weeklyReports);
        System.out.println("-----------添加周报成功-----------");
        weeklyReportsService.addWeeklyReports(weeklyReports);//把前端收到的内容添加到数据库
        // 从HttpSession中获取存储的User对象
        Employees user2 = (Employees) httpSession.getAttribute("user");

        // 获取用户的所有信息(调用service方法获取）
        Employees user = employeesService.myCenter(user2);

        // 可以将用户信息存储到request中，以便在页面上显示
        httpSession.setAttribute("user", user);
        System.out.println("user:-----"+user);
        if(user.getAuthorization_id()==3){//如果是员工提交周报，则跳转到查询周报页面
            return "redirect:/user/getAllWeeklyData?id="+ user.getEmployee_id();
        }else{
            return "redirect:/user/getAllWeeklyData";
        }

    }
    //7.评论
    @RequestMapping("/submitWeeklyComment")
    public String submitComment(Integer id,HttpSession httpSession){
        WeeklyReports comment=new WeeklyReports();
        comment.setComments("已查看");//默认评论是已查看
        comment.setReport_id(id);
        weeklyReportsService.submitWeeklyComment(comment);
        Employees user2 = (Employees) httpSession.getAttribute("user");

        // 获取用户的所有信息(调用service方法获取）
        Employees user = employeesService.myCenter(user2);

        // 可以将用户信息存储到request中，以便在页面上显示
        httpSession.setAttribute("user", user);
        System.out.println("-----------批阅成功-----------");
        return "redirect:/user/getAllWeeklyData?id="+ user.getEmployee_id();//评论完成，重定向到周报页面
    }

}
