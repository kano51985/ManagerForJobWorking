package com.sana.controller;


import com.sana.pojo.Authorizations;
import com.sana.pojo.Employees;

import com.sana.service.AuthorizationsService;
import com.sana.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class EmployeesController {

    @Autowired
    private EmployeesService employeesService;
    @Autowired
    private AuthorizationsService authorizationsService;


    //1.用户登录
    @RequestMapping("/login")
    public String login(Employees employees, HttpSession httpSession){
        System.out.println("-------------login(1)-------------");
        System.out.println("user:"+employees);
        Employees employees1=employeesService.login(employees);

        if (employees1!=null){
            // 登录成功，将用户信息employees1存储到HttpSession的user中(为个人中心（myCenter）做铺垫
            httpSession.setAttribute("user", employees1);
            return "main";
        }else{
            return "redirect:/login.jsp";
        }
    }

    //2.个人中心
    @RequestMapping("/myCenter")
    public String myCenter(HttpSession httpSession){
        System.out.println("---------------mycenter(2)------------------");
        // 从HttpSession中获取存储的User对象
        Employees user2 = (Employees) httpSession.getAttribute("user");

        // 获取用户的所有信息(调用service方法获取）
        Employees user = employeesService.myCenter(user2);

        // 在控制台输出获取到的用户信息
        System.out.println("user: " + user);

        // 可以将用户信息存储到request中，以便在页面上显示
        httpSession.setAttribute("user", user);

        return "myCenter";



    }

    //3.检查用户名是否重复
    @RequestMapping("checkName")
    @ResponseBody
    public boolean checkName(String username){
        System.out.println("-----------checkname方法（3）-----------");
        System.out.println("username"+username);

        //根据用户名查询指定用户信息
        employeesService.getUserByName(username);
        return employeesService.getUserByName(username);

    }

    //5.根据id修改指定用户信息
    @RequestMapping("/updateUser")
    public String updateUser(Employees user){
        System.out.println("-----------更新用户信息方法（5）--------------");
        System.out.println("user:"+user);
        //执行修改
        employeesService.updateUser(user);
        return "forward:/user/login";
    }

    //6.查询全部用户
    @RequestMapping("/getAllUser")
    public String getAllUser(HttpServletRequest httpServletRequest){
        System.out.println("-----------查询全部用户（6）--------------");
        List<Employees> list= employeesService.getAllUser();
        //将查询的所有用户信息存放在request中,取名list
        httpServletRequest.setAttribute("list",list);

        return "userList";
    }

    //7.根据id查询指定用户
    @RequestMapping("/getUserById")
    public String getUserById(Integer id,HttpServletRequest request){
        System.out.println("-----------根据指定Id查询用户信息（7）-----------");
        Employees user= employeesService.getUserById(id);
        request.setAttribute("user",user);
        return "myCenter";
    }

    //8.根据id删除指定用户
    @RequestMapping("/deleteById")
    public String deleteById(Integer id){
        System.out.println("----------根据id删除指定用户信息(8)----------");
        employeesService.deleteById(id);
        return "redirect:/user/getAllUser";
    }

    //9.添加用户
    @RequestMapping("/addUser")
    public String addUser(Employees user){
        System.out.println("------------添加用户（9）---------------");
        employeesService.addUser(user);
        return "redirect:/user/getAllUser";
    }

    //10.根据id更新用户信息(for admin)
    @RequestMapping("/updateUserForADM")
    public String updateUserForADM(Employees employees){
        System.out.println("----------------根据id更新用户信息(for admin)（10）-----------------");
        employeesService.updateUserForADM(employees);
        return "redirect:/user/getAllUser";
    }

    //11.根据id查询指定用户(for adm)
    @RequestMapping("/getUserByIdForADM")
    public String getUserByIdForADM (Integer id, HttpServletRequest request){
        System.out.println("-----------根据指定Id查询用户信息for adm（11）-----------");
        Employees user= employeesService.getUserById(id);
        List<Authorizations>auth= authorizationsService.getAllRole();
        request.setAttribute("auth",auth);
        request.setAttribute("userInformationForADM",user);
        return "userCenter";
    }

    //12.获取全部身份为经理的用户
    @RequestMapping("/getAllExecutives")
    public String getAllExecutives(HttpServletRequest request){
        System.out.println("--------------获取全部身份为经理的用户（12）---------------");
        List<Employees>list=employeesService.getAllExecutives();
        System.out.println(list);
        request.setAttribute("executives",list);
        return "executiveList";
    }

    //13.根据部门ID查询用户
    @RequestMapping("/getUserByDepartmentId")
    public String getUserByDepartmentId(Integer id,HttpServletRequest request){
        System.out.println("------------------根据部门ID查询用户(13)-------------------");
        List<Employees>list=employeesService.getUserByDepartmentID(id);
        request.setAttribute("list",list);
        return "userList";
    }
}
