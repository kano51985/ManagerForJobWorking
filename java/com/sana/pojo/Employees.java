package com.sana.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employees {
    private Integer employee_id;
    private Integer department_id;
    private Integer authorization_id;
    private String username;
    private String password;
    private String name;

    private Authorizations authorizations;
    private Departments departments;
}
