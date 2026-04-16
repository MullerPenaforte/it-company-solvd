package com.solvd.itcompany.interfaces;
import com.solvd.itcompany.model.People.Employee;

@FunctionalInterface
public interface AccessValidator {
    boolean validate(Employee employee, String requiredLeval);
}
