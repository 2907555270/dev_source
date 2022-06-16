package com.txy.domain;

import com.txy.domain.resume.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * 简历 实体类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resume {
    @Id
    private String _id;
    private User user;
    private BasicInfo basicInfo;
    private EducationInfo educationInfo;
    private List<PersonalAbility> personalAbility;
    private List<ProjectExperience> projectExperience;
    private List<WinnerHonor> winnerHonor;
    private List<PersonalProfile> personalProfile;
}
