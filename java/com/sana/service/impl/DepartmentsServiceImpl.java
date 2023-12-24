package com.sana.service.impl;

import com.sana.dao.DepartmentsMapper;
import com.sana.pojo.Departments;
import com.sana.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentsServiceImpl implements DepartmentsService {
    @Autowired
    @Qualifier("departmentsMapper")
    private DepartmentsMapper departmentsMapper;



    //1.查询所有部门信息
    public List<Departments> getAllDepartments(){
        List<Departments>list= departmentsMapper.getAllDepartments();
        return list;
    };

    //2.添加部门
    public void addDepartment(Departments departments){
         departmentsMapper.addDepartment(departments);
    };

    //3.修改部门信息
    public void updateDepartment(Departments departments){
        departmentsMapper.updateDepartment(departments);
    };

    //4.根据部门id删除部门
    public void deleteDepartmentById(Integer id){
        departmentsMapper.deleteDepartmentById(id);
    };

    //5.根据部门id查找部门
    public Departments getDepartmentById(Integer id){
        Departments departments= departmentsMapper.getDepartmentById(id);
        return departments;
    };
}
