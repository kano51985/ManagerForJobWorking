package com.sana.dao;

import com.sana.pojo.Projects;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ProjectsMapper {
    //1.查询本部门下的项目列表
    @Select("SELECT * FROM projects WHERE department_id=#{department_id}")
    public List<Projects> getProjectById(Integer id);

    //2.修改项目内容
    @Update("UPDATE projects SET project_name=#{project_name},project_statement=#{project_statement} " +
            " WHERE project_id=#{project_id}")
    public void updateProjectById(Projects projects);

    //3.根据项目ID获取项目信息
    @Select("SELECT * FROM projects WHERE project_id=#{project_id}")
    public Projects getProjectByPid(Integer id);

    //4.添加项目
    @Insert("INSERT INTO projects(department_id,project_name,project_statement) " +
            " VALUES(#{department_id},#{project_name},#{project_statement})")
    public void addProject(Projects projects);

    //5.删除项目
    @Delete("DELETE FROM projects WHERE project_id=#{project_id}")
    public void deleteProject(Integer id);
}