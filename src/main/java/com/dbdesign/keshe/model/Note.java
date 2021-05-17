package com.dbdesign.keshe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @author codemilk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    private int wordid;
    private Timestamp date;
    private String word;
    private String notepad;
    private String translation;

    @Override
    public String toString() {
        return wordid + " " + word + " " + date.toString() + "" + notepad;
    }

}
