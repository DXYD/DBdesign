package com.dbdesign.keshe.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author codemilk
 */
@Mapper
@Repository
public interface AdminMapper {

    @Select("select password from admin where username = #{username}")
    String getAdminPassword(String username);

}
