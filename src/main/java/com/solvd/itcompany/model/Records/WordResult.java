package com.solvd.itcompany.model.Records;

public record WordResult(String word, int count) {

    public WordResult {
        if (count < 0) {
            throw new IllegalArgumentException("Count cannot be negative for word: " + word);
        }
        word = word.trim().toLowerCase();
    }
}
