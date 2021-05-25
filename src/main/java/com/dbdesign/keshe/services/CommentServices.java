package com.dbdesign.keshe.services;

import com.dbdesign.keshe.results.AdminResults;
import com.dbdesign.keshe.results.Results;

/**
 * @author codemilk
 */
public interface CommentServices {

    public Results getComment();

    public Results getCommentByUn(String username);

    public Results delCommentById(int cid);

    public Results addCommentByUn(String username,String content,int total_likes);

    public AdminResults getAdminComment(int page, int limit);

}
