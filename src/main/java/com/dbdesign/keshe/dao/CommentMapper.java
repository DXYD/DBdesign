package com.dbdesign.keshe.dao;

import com.dbdesign.keshe.model.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author codemilk
 */
@Mapper
@Repository
public interface CommentMapper {

    @Select("select * from Comment")
    List<Comment> getComment();

    @Select("select * from Comment where username = #{username}")
    List<Comment> getCommentByUn(String username);

    @Delete("delete from Comment where cid=#{cid}")
    int delCommentById(int cid);

    @Insert("insert into Comment(username,creatTime,content,total_likes) values(#{username},#{creatTime},#{content},#{total_likes})")
    int addCommentByUn(String username,int creatTime,String content,int total_likes);
}
