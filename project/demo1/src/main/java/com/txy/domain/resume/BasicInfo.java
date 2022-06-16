package com.txy.domain.resume;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  简历 基本信息
 *                     name: "姓名",
 *                     job_profile: "求职意向说明",
 *                     phone: "17290201020",
 *                     email: "29072222@qq.com",
 *                     address: "南充市顺庆区...",
 *                     national: "民族",
 *                     gender: "性别",
 *                     native_place: "籍贯",
 *                     age: "18",
 *                     img: "/img/login_bg.jpg"
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasicInfo {
    private String name;
    private String job_profile;
    private String phone;
    private String email;
    private String address;
    private String national;
    private String gender;
    private String native_place;
    private String age;
    private String img;
}
