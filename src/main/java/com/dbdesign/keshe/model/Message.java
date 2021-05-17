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
public class Message {
    private int mid;
    private int userid;
    private String creatdate;
}
