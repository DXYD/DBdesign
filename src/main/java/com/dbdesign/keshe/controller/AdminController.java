package com.dbdesign.keshe.controller;

import com.dbdesign.keshe.results.AdminResults;
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

    @GetMapping("/getUserList")
    public AdminResults getUserList(int page, int limit){return adminServices.getUserList(page,limit);}

    @GetMapping("/getUserByUid")
    public AdminResults getUserByUid(int uid){return adminServices.getUserByUid(uid);}

    @GetMapping("/addUser")
    public AdminResults addUser(String username,String password){return adminServices.addUser(username,password);}

    @GetMapping("/delUserByUn")
    public AdminResults delUserByUid(String username){return adminServices.delUserByUn(username);}

}
