package com.txy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "goods")
public class Goods {
    private int gid;
    private String name;
    private double price;
    private String description;
    private String goods_img;
    private int category;
}
