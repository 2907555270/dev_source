package com.txy.config;

import com.txy.domain.Resume;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumePage {
    private Resume resume;
    private int currentPage;
    private int pageSize;
}
