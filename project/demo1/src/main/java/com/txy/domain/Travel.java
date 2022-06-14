package com.txy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Travel {
    @Id
    private String _id;
    private String title;
    private String description;
    private String author;
    private String img;
    private String category;
}
