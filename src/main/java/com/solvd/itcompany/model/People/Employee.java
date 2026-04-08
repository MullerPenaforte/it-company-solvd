package com.solvd.itcompany.model.People;

import com.solvd.itcompany.enums.Department;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.itcompany.enums.SeniorityLevel;

public class Employee extends Person {

    private static final Logger logger = LogManager.getLogger(Employee.class);
    private String profession;
    private int id;
    private SeniorityLevel seniority;
    private Department department;

    public Employee(String name, SeniorityLevel seniority) {
        this.name = name;
        this.seniority = seniority;
    }

    public Employee(String name, SeniorityLevel seniority, Department department) {
        this.name = name;
        this.seniority = seniority;
        this.department = department;
    }

    public Employee(String name, int age, String gender, String profession, int id) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.profession = profession;
        this.id = id;
    }

    public Employee(String name, String profession, int id) {
        this.name = name;
        this.profession = profession;
        this.id = id;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SeniorityLevel getSeniority() {
        return seniority;
    }

    public void setSeniority(SeniorityLevel seniority) {
        this.seniority = seniority;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public void greet() {
        logger.info("Hello I'm {}. Can I help you with something?", getName());
    }

    @Override
    public void performAction(String action) {
        logger.info("Employee is now doing {}", action);
    }
}