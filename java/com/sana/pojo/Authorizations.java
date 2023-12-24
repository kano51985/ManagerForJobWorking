package com.sana.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Authorizations {
    private Integer authorization_id;
    private Integer employee_id;
    private String authorized_role;
}
