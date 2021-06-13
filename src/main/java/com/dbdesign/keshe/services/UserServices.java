package com.dbdesign.keshe.services;

import com.dbdesign.keshe.model.Note;
import com.dbdesign.keshe.model.User;
import com.dbdesign.keshe.model.enWords;
import com.dbdesign.keshe.results.Results;

import java.util.List;

/**
 * @author codemilk
 */
public interface UserServices {

    List<User> querylistuser();

    List<enWords> queryWordInfo(String word);

    List<Note> queryNoteInfoById(int wordid);

    Results login(String username,String password);

    Results addnote(int wordid);

    List<enWords> queryWordInfoById(int wordid);

    Results delnote(int wordid);

    Results<Note> getnotes();

    Results existUserByUn(String username);
}
