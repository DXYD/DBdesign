package com.dbdesign.keshe.controller;

import com.dbdesign.keshe.model.Note;
import com.dbdesign.keshe.model.User;
import com.dbdesign.keshe.model.enWords;
import com.dbdesign.keshe.results.Results;
import com.dbdesign.keshe.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author codemilk
 */
@Controller
@ResponseBody
@RequestMapping("/admin")
public class indexController {

    @Autowired
    UserServices userService;

    @GetMapping("/querylistuser")
    public List<User> querylistuser() {
        return userService.querylistuser();
    }

    @GetMapping("/queryWordInfo")
    public List<enWords> queryWordInfo(String word) {
        return userService.queryWordInfo(word);
    }

    @GetMapping("/queryWordInfoById")
    public List<enWords> queryWordInfoById(int wordid) {
        return userService.queryWordInfoById(wordid);
    }

    @GetMapping("/getnotes")
    public Results<Note> getnotes() {
        return userService.getnotes();
    }

    @GetMapping("/addnote")
    public Results queryWordInfo(int wordid) {
        return userService.addnote(wordid);
    }

    @GetMapping("/delnote")
    public Results delnote(int wordid) {
        return userService.delnote(wordid);
    }
}
