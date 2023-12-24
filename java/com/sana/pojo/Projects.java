package com.sana.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Projects {
    private Integer project_id;
    private Integer department_id;
    private String project_name;
    private  String project_statement;
}
