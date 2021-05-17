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
public class enWords {
    private String word;
    private String translation;
    private Integer wordId;

    @Override
    public String toString() {
        return "enWords{" +
                "word='" + word + '\'' +
                ", translation='" + translation + '\'' +
                ", wordId=" + wordId +
                '}';
    }
}
