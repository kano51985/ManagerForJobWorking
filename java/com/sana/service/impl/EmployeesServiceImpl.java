package com.sana.service.impl;

import com.sana.dao.EmployeesMapper;
import com.sana.pojo.Employees;
import com.sana.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesServiceImpl implements EmployeesService {

    @Autowired
    @Qualifier("employeesMapper")
    private EmployeesMapper employeesMapper;



    //1.用户登录
    public Employees login(Employees employees){
        return employeesMapper.login(employees);
    };

    //2.个人中心
    public Employees myCenter(Employees employees){
        return employeesMapper.myCenter(employees);
    };

    //3.检查是否username重名
    public boolean getUserByName(String name){
        Employees user=employeesMapper.getUserByName(name);
        if (user!=null){
            return true;
        }else {
            return false;
        }
    };

    //5.根据id修改账号信息
    public void updateUser(Employees user){
        employeesMapper.updateUser(user);
    };

    //6.查询全部用户
    public List<Employees> getAllUser(){
       List<Employees> list= employeesMapper.getAllUser();
       return list;
    };

    //7.根据id查询指定用户
    public Employees getUserById(Integer id){
        Employees employees= employeesMapper.getUserById(id);
        return employees;
    };

    //8.根据id删除指定用户
    public void deleteById(Integer id){
        employeesMapper.deleteById(id);
    };

    //9.添加用户
    public void addUser(Employees user){
        employeesMapper.addUser(user);
    };

    //10.根据id修改账号信息(for admin)
    public void updateUserForADM(Employees user){
        employeesMapper.updateUserForADM(user);
    };

    //11.查询所有部门经理的信息
    public List<Employees> getAllExecutives(){
        List<Employees>list= employeesMapper.getAllExecutives();
        return list;
    };

    //12.根据部门ID查询该部门所有员工
    public List<Employees> getUserByDepartmentID(Integer id){
        List<Employees>list= employeesMapper.getUserByDepartmentID(id);
        return list;
    };
}
