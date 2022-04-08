package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private Integer age;
    private String sex;//0:男 1:女
    private String name;
    private String departmentname;//用户所属部门
    private String phonenumber;
    private String role;
}
