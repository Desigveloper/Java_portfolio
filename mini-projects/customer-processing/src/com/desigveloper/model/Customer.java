package com.desigveloper.model;

import java.time.LocalDate;

/**
 * Customer class represents a customer with various attributes.
 * Contains the information when a is made a search in the database.
 * Uses the Builder pattern for flexible object creation.
*/

public class Customer {
    private final int id;
    private final String name;
    private final LocalDate birthDate;
    private final String address;
    private final String email;
    private final double salary;
    private final String login;
    private final String passwordToken;

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

    // Getters only - encapsulation (no direct field modification)
    public int getId() { return this.id; }

    public String getName() { return this.name; }

    public LocalDate getBirthDate() { return this.birthDate; }

    public String getAddress() { return this.address; }

    public String getEmail() { return this.email; }

    public double getSalary() { return this.salary; }
    
    public String getLogin() { return this.login; }

    public String getPasswordToken() { return this.passwordToken; }

    // Static builder method
    public static Builder builder(int id, String name, LocalDate birthDate) {
        return new Builder(id, name, birthDate);
    }

    
    // Builder class
    public static class Builder {
        private int id;
        private String name;
        private LocalDate birthDate;
        private String address;
        private String email;
        private double salary;
        private String login;
        private String passwordToken;

        public Builder(int id, String name, LocalDate birthDate) {
            this.id = id;
            this.name = name;
            this.birthDate = birthDate;
        }
        
        public Builder withAddress(String address) {
            this.address = address;
            return this;
        }
        
        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }
        
        public Builder withSalary(double salary) {
            this.salary = salary;
            return this;
        }
        
        public Builder withLogin(String login) {
            this.login = login;
            return this;
        }
        
        public Builder withPasswordToken(String passwordToken) {
            this.passwordToken = passwordToken;
            return this;
        }
        
        public Customer build() {
            return new Customer(this);
        }
    }
}
