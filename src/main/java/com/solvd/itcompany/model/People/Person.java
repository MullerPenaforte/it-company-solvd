package com.solvd.itcompany.model.People;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Objects;

public abstract class Person implements Interactable {

    private static final Logger logger = LogManager.getLogger(Person.class);
    protected String name;
    protected String gender;
    protected int age;

    public Person(String gender, int age, String name) {
        this.gender = gender;
        this.age = age;
        this.name = name;
    }

    public Person() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + name + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public void greet() {
        logger.info("Hello everyone. Have a good day!");
    }

    @Override
    public void performAction(String action) {
        logger.info("Hi, I'm now doing {}", action);
    }
}