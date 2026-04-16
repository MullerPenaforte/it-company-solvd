package com.solvd.itcompany.interfaces;

import com.solvd.itcompany.model.People.Employee;

@FunctionalInterface
public interface DepartmentFilter {
    boolean isValid(Employee employee, String departmentName);
}
