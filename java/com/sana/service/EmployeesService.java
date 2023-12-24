package com.sana.service;

import com.sana.pojo.Employees;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface EmployeesService {
    //1.用户登录
    public Employees login(Employees employees);

    //2.个人中心
    public Employees myCenter(Employees employees);

    //3.检查是否username重名
    public  boolean getUserByName(String name);

    //5.根据id修改账号信息
    public void updateUser(Employees user);

    //6.查询全部用户
    public List<Employees> getAllUser();

    //7.根据id查询指定用户
    public Employees getUserById(Integer id);

    //8.根据id删除指定用户
    public void deleteById(Integer id);

    //9.添加用户
    public void addUser(Employees user);

    //10.根据id修改账号信息(for admin)
    public void updateUserForADM(Employees user);

    //11.查询所有部门经理的信息
    public List<Employees> getAllExecutives();

    //12.根据部门ID查询该部门所有员工
    public List<Employees> getUserByDepartmentID(Integer id);
}
