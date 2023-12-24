package com.sana.controller;

import com.sana.pojo.Departments;
import com.sana.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentsController {
    @Autowired
    private DepartmentsService departmentsService;


    //1.获取全部部门信息
    @RequestMapping("/getAllDepartments")
    public String getAllDepartments(HttpServletRequest httpServletRequest){
        System.out.println("--------------获取全部部门信息（1）-----------------");
        List<Departments>list= departmentsService.getAllDepartments();
        httpServletRequest.setAttribute("department",list);
        return "departmentList";
    }

    //2.添加部门
    @RequestMapping("/addDepartment")
    public String addDepartment(Departments departments){
        System.out.println("----------------添加部门（2）---------------------");
        departmentsService.addDepartment(departments);
        System.out.println(departments);
        return "redirect:/department/getAllDepartments";
    }

    //3.修改部门
    @RequestMapping("/updateDepartment")
    public String updateDepartment(Departments departments){
        System.out.println("---------------修改部门（3）-------------------");
        departmentsService.updateDepartment(departments);
        System.out.println(departments);
        return "redirect:/department/getAllDepartments";
    }

    //4.删除部门
    @RequestMapping("/deleteDepartmentById")
    public String deleteDepartmentById(Integer id){
        System.out.println("--------------删除部门（4）------------------");
        departmentsService.deleteDepartmentById(id);
        System.out.println(id);
        return "redirect:/department/getAllDepartments";
    }

    //5.根据id获取部门信息
    @RequestMapping("/getDepartmentById")
    public String getDepartmentById(Integer id,HttpServletRequest request){
        System.out.println("-------------根据id获取部门（5）-------------------");
        Departments departments= departmentsService.getDepartmentById(id);
        request.setAttribute("department",departments);
        System.out.println(id);
        return "departmentDetail";
    }
}
