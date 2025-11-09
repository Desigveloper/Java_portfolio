package com.desigveloper.model;

import java.time.LocalDate;

public class Customer {
    private final String customerId;
    private final String name;
    private final String contactInfo;
    private final LocalDate dateOfBirth;
    private final String email;
    private final String[] orderHistory;

    // private final Address Address;
    // private final PaymentAgreement;

    private Customer(Builder builder) {
        this.customerId = builder.customerId;
        this.name = builder.name;
        this.dateOfBirth = builder.dateOfBirth;
        this.email = builder.email;
        this.contactInfo = builder.contactInfo;
        this.orderHistory = builder.orderHistory;
    }

    // Getters
    public String getCustomerId() {
        return this.customerId;
    }

    public String getName() {
        return this.name;
    }

    public LocalDate getDateOfBirth()  {
        return this.dateOfBirth;
    }

    public String getEmail() {
        return this.email;
    }

    public String getContactInfo(String contactInfo) {
        return this.contactInfo;
    }

    public String[] getOrderHistory() {
        return this.orderHistory;
    }


    // Static builder class
    public static class Builder {
        private String customerId;
        private String name;
        private String contactInfo;
        private LocalDate dateOfBirth;
        private String email;
        private String[] orderHistory;

        public Builder(String customerId, String name, LocalDate dateOfBirth) {
            this.customerId = customerId;
            this.name = name;
            this.dateOfBirth = dateOfBirth;
        }

        public Builder withContactInfo(String contactInfo) {
            this.contactInfo = contactInfo;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withOrderHistory(String[] orderHistory) {
            this.orderHistory = orderHistory;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }

    public void createOrder(Order order) {

    }

    public void viewOrderHistory(Order[] order) {

    }

    public void updateProfile(Customer customer) {
        
    }

}
