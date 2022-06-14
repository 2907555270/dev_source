package com.txy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    private Integer aid;
    private String username;
    private String password;
    private String name;
    private Integer age;
    private String address;
    private String phone;
    private String email;
    private String head_img;
}
