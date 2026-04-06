package com.solvd.itcompany.generics;

public class SystemMessage<T> {
    private T entity;

    public SystemMessage(T entity) {
        this.entity = entity;
    }

    public void printAlert(String action) {
        System.out.println("[ALERT] Action: " + action + " for entity: " + entity.toString());
    }
}