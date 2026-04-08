package com.solvd.itcompany.enums;

public enum Department {
    IT("Information Technology"),
    FINANCE("Financial Department"),
    SALES("Sales and Marketing");

    private final String fullName;

    Department(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}