package com.desigveloper.resources;

import com.desigveloper.services.CustomerService;

/**
 * CustomerResource acts as a RESTful resource for handling customer-related HTTP requests.
 * It serves as an entry point for client interactions with customer data.
 * It interacts with the CustomerService to process business logic and data operations.
*/

public class CustomerResource {
    private CustomerService customerService;

    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }
}
