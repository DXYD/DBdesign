package com.dbdesign.keshe.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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

    @Select("select username from user where username = #{username}")
    boolean queryUserByUn(String username);

    @Delete("delete from user where username = #{username}")
    int delUserByUn(String username);

    @Delete("delete from comment where username = #{username}")
    int delCommentByUn(String username);

    @Insert("insert into user(username,password) values(#{username},#{password})")
    int addUser(String username,String password);
}
