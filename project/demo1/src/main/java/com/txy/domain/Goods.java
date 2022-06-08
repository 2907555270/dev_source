package com.txy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    private String _id;
    private int gid;
    private String name;
    private double price;
    private String description;
    private String goods_img;
    private int category;
}
