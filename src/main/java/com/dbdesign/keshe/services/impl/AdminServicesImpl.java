package com.dbdesign.keshe.services.impl;

import com.dbdesign.keshe.dao.AdminMapper;
import com.dbdesign.keshe.dao.UserMapper;
import com.dbdesign.keshe.model.User;
import com.dbdesign.keshe.results.AdminResults;
import com.dbdesign.keshe.results.Results;
import com.dbdesign.keshe.services.AdminServices;
import com.dbdesign.keshe.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author codemilk
 */

@Service
public class AdminServicesImpl implements AdminServices {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private UserMapper userMapper;

    // 管理员登录
    @Override
    public Results adminLogin(String username, String password) {
        String adminPassword = adminMapper.getAdminPassword(username);
        if (MD5.crypt(password).equals(adminPassword)) {
            return new Results(1, "登录成功");
        } else {
            return new Results(0, "账号或密码错误");
        }
    }

    @Override
    public AdminResults getUserList(int page, int limit) {
        List<User> userList = userMapper.querylistuser();
        return new AdminResults(0, "", userList, 3000);
    }

    @Override
    public AdminResults getUserByUid(int uid) {
        return new AdminResults();
    }

    @Override
    public AdminResults addUser(String username, String password) {
        if (userMapper.existUserByUn(username) == null) {
            if (password != null) {
                adminMapper.addUser(username, MD5.crypt(password));
            } else {
                adminMapper.addUser(username, password);
            }
            return new AdminResults(1, "添加成功");
        } else {
            return new AdminResults(0, "存在该用户");
        }
    }

    /**
     * 通过username删除用户并删除该用户的所以评论
     */
    @Override
    public AdminResults delUserByUn(String username) {
        adminMapper.delUserByUn(username);
        int result = adminMapper.delCommentByUn(username);
        return new AdminResults(result, "已删除该用户所有评论");
    }
}

