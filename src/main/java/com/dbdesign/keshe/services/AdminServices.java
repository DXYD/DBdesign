package com.dbdesign.keshe.services;

import com.dbdesign.keshe.results.AdminResults;
import com.dbdesign.keshe.results.Results;

/**
 * @author codemilk
 */
public interface AdminServices {
    Results adminLogin(String username, String password);

    AdminResults getUserList(int page, int limit);

    AdminResults getUserByUid(int uid);

    AdminResults addUser(String username, String password);

    AdminResults delUserByUn(String username);
}
