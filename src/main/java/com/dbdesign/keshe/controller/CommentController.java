package com.dbdesign.keshe.controller;

import com.dbdesign.keshe.results.AdminResults;
import com.dbdesign.keshe.results.Results;
import com.dbdesign.keshe.services.CommentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author codemilk
 */

@Controller
@ResponseBody
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentServices commentServices;

    @GetMapping("/getComment")
    public Results getComment() {
        return commentServices.getComment();
    }

    @GetMapping("/getAdminComment")
    public AdminResults getComment(int page, int limit) {
        return commentServices.getAdminComment(page, limit);
    }

    @GetMapping("/getCommentByUn")
    public Results getCommentByUn(String username) {
        return commentServices.getCommentByUn(username);
    }

    @GetMapping("/delCommentById")
    public Results delCommentById(int cid) {
        return commentServices.delCommentById(cid);
    }

    @GetMapping("/addCommentByUn")
    public Results addCommentByUn(String username, String content, int total_likes) {
        return commentServices.addCommentByUn(username, content, total_likes);
    }


}
