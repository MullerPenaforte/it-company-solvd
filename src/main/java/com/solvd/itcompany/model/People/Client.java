package com.solvd.itcompany.model.People;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Client extends Person {
    private static final Logger logger = LogManager.getLogger(Client.class);
    private String personalCode;

    public Client(String gender, int age, String name, String personalCode) {
        super(gender, age, name);
        this.personalCode = personalCode;
    }

    public Client(String personalCode) {
        this.personalCode = personalCode;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }

    @Override
    public void greet() {
        logger.info("Hello I'm {}. Can I get some help over here?", getName());
    }

    @Override
    public void performAction(String action) {
        logger.info("Client is now doing {}", action);
    }

    public static class Employee extends Person {
        private static final Logger empLogger = LogManager.getLogger(Employee.class);
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
            empLogger.info("Hello I'm {}. Can I help you with something?", getName());
        }

        @Override
        public void performAction(String action) {
            empLogger.info("Employee is now doing {}", action);
        }
    }
}