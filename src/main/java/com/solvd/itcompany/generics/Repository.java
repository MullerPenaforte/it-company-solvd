package com.solvd.itcompany.generics;

import java.util.ArrayList;
import java.util.List;

public class Repository<T> {
    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public List<T> getAll() {
        return items;
    }

    public int getCount() {
        return items.size();
    }
}