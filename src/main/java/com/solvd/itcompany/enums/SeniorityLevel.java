package com.solvd.itcompany.enums;

public enum SeniorityLevel {
    INTERN("Internship"),
    JUNIOR("Junior Developer"),
    MID("Mid-level Developer"),
    SENIOR("Senior Specialist");

    private final String description;

    // Construtor do Enum
    SeniorityLevel(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}