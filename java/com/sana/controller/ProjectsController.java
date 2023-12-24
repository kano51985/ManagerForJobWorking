package com.sana.controller;

import com.sana.pojo.Projects;
import com.sana.service.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectsController {
    @Autowired
    private ProjectsService projectsService;


    @RequestMapping("/getProjectById")
    //1.根据部门id获取部门下项目
    public String getProjectById(Integer id, HttpServletRequest request){
        System.out.println("------------------1.根据部门id获取部门下项目------------------");
        List<Projects>list= projectsService.getProjectById(id);
        request.setAttribute("showmetheprojects",list);
        return "projectList";
    }

    @RequestMapping("/updateProjectById")
    //2.根据部门id修改项目名和项目说明
    public String updateProjectById(Projects projects){
        System.out.println("------------2.根据项目id修改项目名和项目说明--------------");
        projectsService.updateProjectById(projects);
        return "redirect:/project/getProjectById?id="+projects.getDepartment_id();
    }

    @RequestMapping("/getProjectByPid")
    //3.根据项目id获取项目信息
    public String getProjectByPid(Integer id,HttpServletRequest request){
        System.out.println("------------------3.根据项目id获取项目信息-------------------");
        Projects projects= projectsService.getProjectByPid(id);
        request.setAttribute("showmetheproject",projects);
        return "projectCenter";
    }

    //4.添加项目
    @RequestMapping("/addProject")
    public String addProject(Projects projects){
        System.out.println("--------------4.添加项目-----------------");
        projectsService.addProject(projects);
        return "redirect:/project/getProjectById?id="+projects.getDepartment_id();
    }

    //5.根据项目id删除项目
    @RequestMapping("/deleteProject")
    public String deleteProject(Integer id,Integer departmentid){
        System.out.println("---------------5.根据项目id删除项目---------------");
        projectsService.deleteProject(id);
        return "redirect:/project/getProjectById?id="+departmentid;
    }
}
