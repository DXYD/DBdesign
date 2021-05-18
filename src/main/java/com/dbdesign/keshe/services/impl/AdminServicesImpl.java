package com.dbdesign.keshe.services.impl;

import com.dbdesign.keshe.dao.AdminMapper;
import com.dbdesign.keshe.results.Results;
import com.dbdesign.keshe.services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author codemilk
 */

@Service
public class AdminServicesImpl implements AdminServices {

    @Autowired
    private AdminMapper adminMapper;

    // 管理员登录
    @Override
    public Results adminLogin(String username, String password) {
        String adminPassword = adminMapper.getAdminPassword(username);
        if(password.equals(adminPassword)){
            return new Results(1, "登录成功");
        }else {
            return new Results(0, "账号或密码错误");
        }
    }

}
