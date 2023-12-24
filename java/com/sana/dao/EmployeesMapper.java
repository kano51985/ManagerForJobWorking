package com.sana.dao;

import com.sana.pojo.Employees;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface EmployeesMapper {
    //1.用户登录
    //@Select("SELECT * FROM employees WHERE username=#{username} AND PASSWORD=#{password} and authorization_id=#{authorization_id}")
    public Employees login(Employees employees);

    //2.个人中心
    //@Select("select * from employees where username=#{username}")
    public Employees myCenter(Employees employees);

    //3.checkName
    @Select("SELECT username FROM employees WHERE username=#{username}")
    public Employees checkName(Employees employees);


    //4.获取指定用户名信息
    @Select("select * from employees where username=#{username}")
    public Employees getUserByName(String name);

    //5.根据id修改账号信息(for normal User)
    @Update("update employees set password=#{password}" +
            " where employee_id=#{employee_id}")
    public void updateUser(Employees user);

    //6.查询全部用户
    //@Select("select * from employees")
    public List<Employees> getAllUser();

    //7.根据id查询指定用户
    //@Select("select * from employees where employee_id=#{employee_id}")
    public Employees getUserById(Integer id);

    //8.根据id删除指定用户
    @Delete("DELETE FROM employees WHERE employee_id=#{id}")
    public void deleteById(Integer id);

    //9.添加用户
    @Update(" INSERT INTO employees(employee_id,department_id,authorization_id,username,password,name) " +
            " VALUES(#{employee_id},#{department_id},#{authorization_id},#{username},#{password},#{name});")
    public void addUser(Employees user);

    //10.根据id修改账号信息(for admin)
    @Update("update employees set department_id=#{department_id},authorization_id=#{authorization_id},username=#{username},password=#{password},name=#{name} " +
            " where employee_id=#{employee_id}")
    public void updateUserForADM(Employees user);

    //11.查询所有部门经理的信息
    @Select("SELECT * FROM employees WHERE authorization_id=2")
    public List<Employees> getAllExecutives();

    //12.根据部门ID查询该部门所有员工
    @Select("SELECT * FROM employees WHERE department_id=#{department_id};")
    public List<Employees> getUserByDepartmentID(Integer id);
}
