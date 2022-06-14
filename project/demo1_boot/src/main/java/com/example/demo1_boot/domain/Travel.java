package com.example.demo1_boot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Travel {
    @Id
    private ObjectId _id;
    private String title;
    private String description;
    private String img;
    private String category;
}
