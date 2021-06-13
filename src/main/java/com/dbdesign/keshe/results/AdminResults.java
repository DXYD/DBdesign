package com.dbdesign.keshe.results;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author codemilk
 */
@Data
@NoArgsConstructor
public class AdminResults<T> {

    Integer code;
    String msg;
    Integer count;
    List<T> data;

    public AdminResults(Integer code, String msg, List<T> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public AdminResults(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public AdminResults(Integer code, String msg, List<T> data, Integer count) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }
}


