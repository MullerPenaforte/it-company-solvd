package com.solvd.itcompany.model.Support;

import com.solvd.itcompany.model.People.Employee;
import com.solvd.itcompany.enums.Department;
import com.solvd.itcompany.enums.SeniorityLevel;
import java.util.Arrays;
import java.util.List;

public class EmployeeFactory {
    public static List<Employee> createStaff() {
        return Arrays.asList(
                new Employee("James Smith", SeniorityLevel.SENIOR, Department.IT),
                new Employee("Michael Johnson", SeniorityLevel.MID, Department.IT),
                new Employee("Robert Williams", SeniorityLevel.JUNIOR, Department.IT),
                new Employee("Maria Garcia", SeniorityLevel.SENIOR, Department.FINANCE),
                new Employee("David Miller", SeniorityLevel.MID, Department.SALES),
                new Employee("Linda Davis", SeniorityLevel.JUNIOR, Department.FINANCE),
                new Employee("William Rodriguez", SeniorityLevel.SENIOR, Department.SALES),
                new Employee("Elizabeth Martinez", SeniorityLevel.MID, Department.IT)
        );
    }
}
