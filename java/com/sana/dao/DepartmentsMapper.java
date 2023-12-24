package com.sana.dao;

import com.sana.pojo.Departments;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DepartmentsMapper {
    //1.查询所有部门信息
    @Select("SELECT * FROM departments")
    public List<Departments> getAllDepartments();

    //2.添加部门
    @Insert(" INSERT  ignore INTO departments (department_id,department_name,manager_id) " +
            " VALUES(#{department_id},#{department_name},#{manager_id})")
    public void addDepartment(Departments departments);

    //3.修改部门信息
    @Update(" UPDATE departments  SET  department_name=#{department_name},manager_id=#{manager_id}" +
            " WHERE department_id=#{department_id}")
    public void updateDepartment(Departments departments);

    //4.根据部门id删除部门
    @Delete("DELETE FROM departments WHERE department_id=#{department_id}")
    public void deleteDepartmentById(Integer id);

    //5.根据部门id查找部门
    @Select("SELECT * FROM departments WHERE department_id=#{department_id}")
    public Departments getDepartmentById(Integer id);

}
