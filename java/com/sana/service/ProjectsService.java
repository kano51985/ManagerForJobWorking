package com.sana.service;

import com.sana.dao.ProjectsMapper;
import com.sana.pojo.Projects;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ProjectsService {
    //1.查询本部门下的项目列表
    public List<Projects> getProjectById(Integer id);

    //2.修改项目内容
    public void updateProjectById(Projects projects);

    //3.根据项目ID获取项目信息
    public Projects getProjectByPid(Integer id);

    //4.添加项目
    public void addProject(Projects projects);

    //5.删除项目
    public void deleteProject(Integer id);
}
