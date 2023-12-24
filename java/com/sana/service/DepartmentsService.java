package com.sana.service;

import com.sana.pojo.Departments;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DepartmentsService {
    //1.查询所有部门信息
    public List<Departments> getAllDepartments();

    //2.添加部门
    public void addDepartment(Departments departments);

    //3.修改部门信息
    public void updateDepartment(Departments departments);

    //4.根据部门id删除部门
    public void deleteDepartmentById(Integer id);

    //5.根据部门id查找部门
    public Departments getDepartmentById(Integer id);
}
