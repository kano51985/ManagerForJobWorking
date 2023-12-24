package com.sana.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeeklyReports {
    private Integer report_id;
    private Integer employee_id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date report_date;
    private String content;
    private String comments;
    private Employees employees;
    private Authorizations authorizations;
    private Departments departments;
}
