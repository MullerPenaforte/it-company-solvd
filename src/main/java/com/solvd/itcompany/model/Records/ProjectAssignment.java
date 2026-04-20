package com.solvd.itcompany.model.Records;

import com.solvd.itcompany.interfaces.SensitiveData;

import java.time.LocalDate;

public record ProjectAssignment(@SensitiveData String employeeName, String projectName, LocalDate assignmentDate) {
    public ProjectAssignment {
        if (employeeName == null || projectName == null) {
            throw new IllegalArgumentException("Employee and Project names cannot be null");
        }
    }
}
