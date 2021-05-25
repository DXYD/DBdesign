package com.dbdesign.keshe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author codemilk
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private int cid;
    private String username;
    private int creatTime;
    private String content;

}
