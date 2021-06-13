package com.dbdesign.keshe.services;

import com.dbdesign.keshe.results.AdminResults;
import com.dbdesign.keshe.results.Results;

/**
 * @author codemilk
 */
public interface CommentServices {

    Results getComment();

    Results getCommentByUn(String username);

    Results delCommentById(int cid);

    Results addCommentByUn(String username,String content,int total_likes);

    AdminResults getAdminComment(int page, int limit);

}
