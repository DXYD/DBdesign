package com.dbdesign.keshe.results;

import lombok.Data;

import java.util.List;

/**
 * @author codemilk
 */
@Data
public class AdminResults<T> {

    Integer code;
    String msg;
    Integer count;
    List<T> data;

    public AdminResults(Integer code, String msg, List<T> data, Integer count) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }
}


