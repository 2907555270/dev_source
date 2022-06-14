package com.txy.config;

import com.txy.domain.Travel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelPage {
    private Travel travel;
    private int currentPage;
    private int pageSize;
}
