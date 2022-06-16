package com.txy.domain.resume;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  简历 教育信息
 *                     school: "学校",
 *                     profession: "专业",
 *                     learning_record: "学历",
 *                     learning_time: "时间",
 *                     profile: "自由书写:换行使用\\n",
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationInfo {
    private String school;
    private String profession;
    private String learning_record;
    private String learning_time;
    private String profile;
}
