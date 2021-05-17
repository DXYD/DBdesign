package com.codemilk.keshe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Administrator
 */
@Controller
public class IndexController {
    @RequestMapping("/hi")
    public String HelloIndex() {
        return "hello,world";
    }

}
