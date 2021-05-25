package com.dbdesign.keshe.services.impl;

import com.dbdesign.keshe.dao.CommentMapper;
import com.dbdesign.keshe.model.Comment;
import com.dbdesign.keshe.results.AdminResults;
import com.dbdesign.keshe.results.Results;
import com.dbdesign.keshe.services.CommentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author codemilk
 */
@Service
public class CommentImpl implements CommentServices {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public Results getComment() {
        List<Comment> commentList = commentMapper.getComment();
        return new Results(1, "成功啦", commentList);
    }

    @Override
    public Results getCommentByUn(String username) {
        List<Comment> commentList = commentMapper.getCommentByUn(username);
        return new Results(1, "成功啦", commentList);
    }

    @Override
    public Results delCommentById(int cid) {
        int delData = commentMapper.delCommentById(cid);
        return new Results(1,"成功啦",delData);
    }

    @Override
    public Results addCommentByUn(String username,String content,int total_likes) {
        commentMapper.addCommentByUn(username,1,content,total_likes);
        return new Results(1,"成功啦");
    }

    @Override
    public AdminResults getAdminComment(int page, int limit) {
        List<Comment> commentList = commentMapper.getComment();
        return new AdminResults(0,"",commentList,3000);
    }
}
