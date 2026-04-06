package com.solvd.itcompany.model.People;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Employee extends Person {

    private static final Logger logger = LogManager.getLogger(Employee.class);
    private String profession;
    private int id;

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

    @Override
    public void greet() {
        logger.info("Hello I'm {}. Can I help you with something?", getName());
    }

    @Override
    public void performAction(String action) {
        logger.info("Employee is now doing {}", action);
    }
}