package com.dbdesign.keshe.util;

/**
 * @author codemilk
 * 验证token
 */

import com.dbdesign.keshe.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Token {
    @Autowired
    UserMapper userMapper;

    public Boolean tokenVerify(int Uid, String token){
        String userToken = userMapper.getTokenByUserUid(Uid);
        if(token.equals(userToken)){
            return true;
        }else {
            return false;
        }
    }

}