package com.txy.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private boolean flag;
    private String msg;
    private Object data;

    public Result(boolean flag){
        this.flag = flag;
    }

    public Result(boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public Result(boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }
}
