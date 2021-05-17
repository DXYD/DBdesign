package com.dbdesign.keshe.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/test")
public class HelloController {


    // url请求，支持GET和POST，返回值固定
    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring Boot!";
    }


    /**
     * GET请求 http://127.0.0.1:8080/test?param1=222
     * @param param1
     * @param param2
     * @return get in handle1 param1 is 222, param2 is null
     */
    @GetMapping("/test")
    public String test(String param1, String param2) {
        String result = String.format("get in handle1 param1 is %s, param2 is %s", param1, param2);
        return result;
    }


    /**
     * POST请求 http://127.0.0.1:8080/test?param1=222&param2=111
     * @param demo
     * @return post in handle1 param1 is 222, param2 is 111
     */
    @PostMapping("/test")
    public String test(ParamDemo demo){
        String result = String.format("post in handle2 param1 is %s, param2 is %s", demo.param1, demo.param2);
        return result;
    }


    /**
     * 请求入参是一个实体,并且加上了 @RequestBody
     * 一般适用于前端Header中Content-Type 为 application/json的场景
     * 注意入参要是json格式
     * @param demo
     * @return
     */
    @PostMapping("/testPostJson")
    public String testJson(@RequestBody ParamDemo demo){
        String result = String.format("in handle2 param1 is %s, param2 is %s", demo.param1, demo.param2);
        return result;
    }


    /**
     * GET 请求http://127.0.0.1:8080/testGetJson
     * @return {
     * errorMeg: "成功",
     * errorCode: 0
     * }
     */
    @GetMapping("/testGetJson")
    public Map<String,Object> testGetJson(){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("errorCode",0);
        result.put("errorMeg","成功");
        return result;

    }



    /**
     * 请求入参是一个实体,并且加上了 @RequestBody
     * 一般适用于前端Header中Content-Type 为 application/json的场景
     * 注意入参要是json格式
     * @param demo
     * @return json
     */
    @PostMapping("/testReturnJson")
    public String testReturnJson(@RequestBody ParamDemo demo){
        // 将获取的json数据封装一层，然后在给返回
        JSONObject result = new JSONObject();
        result.put("msg", "ok");
        result.put("method", "POST");
        result.put("data", demo);
        return result.toJSONString();
    }


    /**
     * 使用静态内部类,简单定义一个入参实体类
     */
    static class ParamDemo{
        private String param1;
        private String param2;

        public String getParam1() {
            return param1;
        }

        public void setParam1(String param1) {
            this.param1 = param1;
        }

        public String getParam2() {
            return param2;
        }

        public void setParam2(String param2) {
            this.param2 = param2;
        }
    }

}