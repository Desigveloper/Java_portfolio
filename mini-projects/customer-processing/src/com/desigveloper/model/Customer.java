package com.desigveloper.model;

import java.time.LocalDate;

/**
 * Customer class represents a customer with various attributes.
 * Contains the information when a is made a search in the database.
 * Uses the Builder pattern for flexible object creation.
*/

public class Customer {
    private final String id;
    private final String name;
    private final LocalDate birthDate;
    private final String address;
    private final String email;
    private final double salary;
    private final String login;
    private final String passwordToken;

    public static class Builder {
        private String id;
        private String name;
        private LocalDate birthDate;
        private String address;
        private String email;
        private double salary;
        private String login;
        private String passwordToken;

        Builder(String id, String name, LocalDate birthDate) {
            this.id = id;
            this.name = name;
            this.birthDate = birthDate;
        }

        Builder withAddress(String address) {
            this.address = address;
            return this;
        }

        Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        Builder withSalary(double salary) {
            this.salary = salary;
            return this;
        }

        Builder withLogin(String login) {
            this.login = login;
            return this;
        }

        Builder withPasswordToken(String passwordToken) {
            this.passwordToken = passwordToken;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }

    private Customer(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.birthDate = builder.birthDate;
        this.address = builder.address;
        this.email = builder.email;
        this.salary = builder.salary;
        this.login = builder.login;
        this.passwordToken = builder.passwordToken;
    }
}
