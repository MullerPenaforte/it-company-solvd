package com.solvd.itcompany.model.Service;

import com.solvd.itcompany.interfaces.DepartmentFilter;
import com.solvd.itcompany.model.People.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {
    public static List<Employee> filterByDepartment(List<Employee> staff, String dept, DepartmentFilter filter) {
        return staff.stream()
                .filter(e -> filter.isValid(e, dept))
                .collect(Collectors.toList());
    }
}
