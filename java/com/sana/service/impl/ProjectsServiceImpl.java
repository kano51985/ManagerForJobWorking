package com.sana.service.impl;

import com.sana.dao.ProjectsMapper;
import com.sana.pojo.Projects;
import com.sana.service.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectsServiceImpl implements ProjectsService {
    @Autowired
    @Qualifier("projectsMapper")
    private ProjectsMapper projectsMapper;


    //1.查询本部门下的项目列表
    public List<Projects> getProjectById(Integer id){
        List<Projects>list= projectsMapper.getProjectById(id);
        return list;
    };

    //2.修改项目内容
    public void updateProjectById(Projects projects){
        projectsMapper.updateProjectById(projects);
    };

    //3.根据项目ID获取项目信息
    public Projects getProjectByPid(Integer id){
       Projects projects= projectsMapper.getProjectByPid(id);
       return projects;
    };

    //4.添加项目
    public void addProject(Projects projects){
        projectsMapper.addProject(projects);
    };

    //5.删除项目
    public void deleteProject(Integer id){
        projectsMapper.deleteProject(id);
    };
}
