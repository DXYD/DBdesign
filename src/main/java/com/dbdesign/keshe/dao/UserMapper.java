package com.dbdesign.keshe.dao;

import com.dbdesign.keshe.model.Note;
import com.dbdesign.keshe.model.User;
import com.dbdesign.keshe.model.enWords;
import com.dbdesign.keshe.results.Results;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper {
    List<User> querylistuser();

    List<enWords> queryWordInfo(String word);

    List<Note> queryNoteInfoById(int wordid);

    List<enWords>queryWordInfoById(int wordid);

    int addnote(int wordid,String word,String translation);

    int delnote(int worid);

    List<Note> getnotes();

    @Select("select username from user where username = #{username}")
    String existUserByUn(String username);

    @Select("select token from user where uid = #{uid}")
    String getTokenByUserUid(int uid);

    @Update("update user set token = #{token} where username = #{username}")
    void insertToken(String username);
}