package com.dbdesign.keshe.controller;

import com.dbdesign.keshe.results.Results;
import com.dbdesign.keshe.services.AdminServices;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author codemilk
 */
@Controller
@ResponseBody
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminServices adminServices;

    @PostMapping("/login")
    public Results login(String username,String password){return adminServices.adminLogin(username, password);}

}
