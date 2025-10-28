package com.desigveloper;

import java.io.Serializable;

public class Customer {
    private final String name;
    private final String dateOfBirth;
    private final String email;
    private final String login;

    private final Product product;
    private final Address Address;
    private final PaymentAgreement;

    public static Builder {
        public Builder(String name, String dateOfBirth, String email) {
            this.name = name;
            this.dateOfBirth = dateOfBirth;
            this.email = email;
        }
    }

}
