package com.txy.config;

import com.txy.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPage {
    private User user;
    private int currentPage;
    private int pageSize;
}
