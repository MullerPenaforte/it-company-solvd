package com.solvd.itcompany.generics;

public abstract class Validator<T> {
    public static <T> boolean isValid(T item) {
        return item != null;
    }
}