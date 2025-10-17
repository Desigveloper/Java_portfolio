package com.desigveloper.dto;

import java.time.LocalDate;

import com.desigveloper.model.Customer;

/**
 * CustomerDTO is a Data Transfer Object for transferring customer data.
 * It is used to encapsulate customer information when transferring data
 * between different layers of the application, such as between the service
 * layer and the presentation layer.
 * 
 * Contains the information that is exposes to the User Interface.
*/

public class CustomerDTO {
    // Only exposing selected fields - encapsulation
    private  final String name;
    private  final LocalDate birthDate;
    private  final String address;
    private  final String email;
    private  final double salary;

    /**
     * Private constructor for Builder pattern 
     * @param builder
    */

    private CustomerDTO(Builder builder) {
        
        this.name = builder.name;
        this.birthDate = builder.birthDate;
        this.address = builder.address;
        this.email = builder.email;
        this.salary = builder.salary;
    }

    // Getters only
    public String getName() { return this.name; }

    public LocalDate getBirthDate() { return this.birthDate; }

    public String getAddress() { return this.address; }

    public String getEmail() { return this.email; }

    public double getSalary() { return this.salary; }

    // static builder method
    public static Builder builder(String name, LocalDate birthDate, String address) {
        return new Builder(name, birthDate, address);
    }

     /***
     * Conversion method - Converts a Customer object to a CustomerDTO object
     * @param customer
     * @return CustomerDTO
    */

    public static CustomerDTO toCustomerDTO(Customer customer) {
        return CustomerDTO.builder(customer.getName(), customer.getBirthDate(), customer.getAddress())
                .withEmail(customer.getEmail())
                .withSalary(customer.getSalary())
                .build();
            
    }

    // Builder class
    public static class Builder {
        private String name;
        private LocalDate birthDate;
        private String address;
        private String email;
        private double salary;

        public Builder(String name, LocalDate birthDate, String address) {
            this.name = name;
            this.birthDate = birthDate;
            this.address = address;
        }


        Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        Builder withSalary(double salary) {
            this.salary = salary;
            return this;
        }

        public CustomerDTO build() {
            return new CustomerDTO(this);
        }
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "name='" + this.name + '\'' + ", birthDate='" + this.birthDate + '\''
                + ", address='" + this.address + '\'' + ", email='" + this.email + '\''
                + ", salary=" + this.salary + '}';

    }

}
