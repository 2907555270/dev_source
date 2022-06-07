package com.txy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer uid;
    private String username;
    private String password;
    private String name;
    private Integer age;
    private String address;
    private String phone;
    private String email;
    private String head_img;
    private Integer type;
}
