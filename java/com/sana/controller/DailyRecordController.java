package com.sana.controller;

import com.sana.pojo.DailyReports;
import com.sana.pojo.Employees;
import com.sana.service.DailyReportsService;
import com.sana.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class DailyRecordController {

    @Autowired
    private DailyReportsService dailyReportsService;

    @Autowired
    private EmployeesService employeesService;

    //1.查询全部记录
    @RequestMapping("/getAllDailyData")
    public String getAllDailyData(HttpServletRequest httpServletRequest,HttpSession httpSession,Integer id){
        System.out.println("-----------查询全部用户记录（1）--------------");
        Employees user2 = (Employees) httpSession.getAttribute("user");
        // 获取用户的所有信息(调用service方法获取）
        Employees user = employeesService.myCenter(user2);

        if (user.getAuthorization_id() == 2||user.getAuthorization_id() == 3){
            List<DailyReports> list=dailyReportsService.getAllDailyDataByDepartment(id);
            System.out.println("list:"+list);
            //将查询的所有用户信息存放在request中,取名weeklyList
            httpServletRequest.setAttribute("dailyList",list);

            List<DailyReports> list2 = dailyReportsService.getAllDailyDataById(id);
            System.out.println("list2:" + list2);
            //将查询的所有用户信息存放在request中,取名dailyList
            httpServletRequest.setAttribute("dailyList2", list2);

            return "dailyDataList";
        }
        return "dailyDataList";
    }

    //2.根据id删除指定用户记录
    @RequestMapping("/deleteDailyDataById")
    public String deleteDailyDataById(Integer id,HttpSession httpSession){
        System.out.println("----------根据id删除指定用户记录(2)----------");
        dailyReportsService.deleteDailyDataById(id);
        // 从HttpSession中获取存储的User对象
        Employees user2 = (Employees) httpSession.getAttribute("user");

        // 获取用户的所有信息(调用service方法获取）
        Employees user = employeesService.myCenter(user2);

        // 可以将用户信息存储到request中，以便在页面上显示
        httpSession.setAttribute("user", user);
        return "redirect:/user/getAllDailyData?id="+ user.getEmployee_id();
    }

    //3.根据用户修改数据
    @RequestMapping("/updateDailyReports")
    public String updateDailyReports(DailyReports user,HttpSession httpSession){
        System.out.println("-----------更新用户信息方法（3）--------------");
        //根据ID查找指定的用户信息
        dailyReportsService.updateDailyReports(user);
        // 从HttpSession中获取存储的User对象
        Employees user2 = (Employees) httpSession.getAttribute("user");

        // 获取用户的所有信息(调用service方法获取）
        Employees user3 = employeesService.myCenter(user2);

        // 可以将用户信息存储到request中，以便在页面上显示
        httpSession.setAttribute("user", user3);
        return "redirect:/user/getAllDailyData?id="+ user3.getEmployee_id();
    }

    //4.进入修改页面
    @RequestMapping("/toEditDailyRecord")
    public String toEditDailyRecord(Integer id,HttpServletRequest request){
        System.out.println("----------根据id修改指定用户周报信息(5)----------");

        //根据ID查找指定的用户信息
        DailyReports user=dailyReportsService.getUserDailyReportsById(id);
        System.out.println("user----------------------:"+user);
        //将用户返回到request中
        request.setAttribute("dailyRecord",user);

        return "editDailyRecord";
    }

    //5.进入日报页面
    @RequestMapping("/toDaily")
    public String toDaily(Integer id, HttpServletRequest request, HttpSession httpSession){
        // 从HttpSession中获取存储的User对象
        Employees user2 = (Employees) httpSession.getAttribute("user");

        // 获取用户的所有信息(调用service方法获取）
        Employees user = employeesService.myCenter(user2);//这里我是直接用的employee里的myCenter方法，用来获取当前用户的信息

        // 在控制台输出获取到的用户信息
        System.out.println("user: " + user);

        // 可以将用户信息存储到request中，以便在页面上显示
        httpSession.setAttribute("user", user);
        return "submitDailyData";
    }

    //6.提交日报
    @RequestMapping("/addDailyData")
    public String addDailyReports(DailyReports dailyReports,HttpSession httpSession){
        System.out.println("----------------DailyReports-----------:"+dailyReports);
        System.out.println("-----------添加日报成功-----------");
        dailyReportsService.addDailyReports(dailyReports);

        // 从HttpSession中获取存储的User对象
        Employees user2 = (Employees) httpSession.getAttribute("user");

        // 获取用户的所有信息(调用service方法获取）
        Employees user = employeesService.myCenter(user2);

        // 可以将用户信息存储到request中，以便在页面上显示
        httpSession.setAttribute("user", user);
        if(user.getAuthorization_id()==3){//如果是员工提交周报，则跳转个人日报页面
            return "redirect:/user/getAllDailyData?id="+ user.getEmployee_id();
        }else{
            return "redirect:/user/getAllDailyData";
        }
    }

    //7.评论
    @RequestMapping("/submitDailyComment")
    public String submitComment(Integer id,HttpSession httpSession){
        DailyReports comment=new DailyReports();
        comment.setComments("已查看");
        comment.setReport_id(id);
        dailyReportsService.submitDailyComment(comment);
        Employees user2 = (Employees) httpSession.getAttribute("user");

        // 获取用户的所有信息(调用service方法获取）
        Employees user = employeesService.myCenter(user2);
        System.out.println("-----------批阅成功-----------");
        return "redirect:/user/getAllDailyData?id="+ user.getEmployee_id();
    }

}
