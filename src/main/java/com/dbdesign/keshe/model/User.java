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
public class User {
    private int uid;
    private String username;
    private String password;
    private String token;
}
