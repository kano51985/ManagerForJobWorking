package com.sana.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Departments {
    private Integer department_id;
    private String department_name;
    private Integer manager_id;

    private Employees employees;
}
