package com.solvd.itcompany.enums;

public enum ProjectPriority {
    LOW(5),
    MEDIUM(3),
    HIGH(1),
    URGENT(0);

    private final int daysToResolve;

    ProjectPriority(int daysToResolve) {
        this.daysToResolve = daysToResolve;
    }

    public int getDaysToResolve() {
        return daysToResolve;
    }


}