package com.dbdesign.keshe.services.impl;

import com.dbdesign.keshe.dao.UserMapper;
import com.dbdesign.keshe.model.Note;
import com.dbdesign.keshe.model.User;
import com.dbdesign.keshe.model.enWords;
import com.dbdesign.keshe.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dbdesign.keshe.results.*;

import java.util.List;

/**
 * @author codemilk
 */
@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    UserMapper userMapper;

    @Override
    public Results login(String username, String password) {
        return null;
    }

    @Override
    public List<User> querylistuser() {
        List<User> userList = userMapper.querylistuser();
        return userList;
    }

    @Override
    public List<enWords> queryWordInfo(String word) {
        List<enWords> wordInfo = userMapper.queryWordInfo(word);
        return wordInfo;
    }

    @Override
    public List<Note> queryNoteInfoById(int wordid) {
        List<Note> noteInfo = userMapper.queryNoteInfoById(wordid);
        return noteInfo;
    }

    @Override
    public List<enWords> queryWordInfoById(int wordid) {
        List<enWords> wordInfo = userMapper.queryWordInfoById(wordid);
        return wordInfo;
    }

    @Override
    public Results addnote(int wordid) {
        List<enWords> wordInfo = queryWordInfoById(wordid);
        String word = wordInfo.get(0).getWord();
        String translation = wordInfo.get(0).getTranslation();
//        Map <String,String> map=new HashMap<>();
        userMapper.addnote(wordid,word,translation);
        return new Results(1, "成功啦", wordInfo);
    }

    @Override
    public Results delnote(int wordid) {
        userMapper.delnote(wordid);
        return new Results(1, "成功啦");
    }

    @Override
    public Results<Note> getnotes() {
        List<Note> notes = userMapper.getnotes();
        return new Results<Note>(1, "成功啦", notes);
    }

    @Override
    public Results existUserByUn(String username) {
        if (userMapper.existUserByUn(username)!=null){
            return new Results(1,"存在该用户");

        }
        else {
            return new Results(0,"不存在该用户");
        }
    }

}
