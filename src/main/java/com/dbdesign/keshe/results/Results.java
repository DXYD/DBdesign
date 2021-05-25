package com.dbdesign.keshe.results;

import lombok.Data;

import java.util.List;

/**
 * @author codemilk
 *  封装结果集 Result
 */
@Data
public class Results<T> {
    Integer code;
    String msg;
    List<T> datas;
    T data;


    public Results(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Results(Integer code, String msg, List<T> datas) {
        this.code = code;
        this.msg = msg;
        this.datas = datas;
    }

    public Results(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
