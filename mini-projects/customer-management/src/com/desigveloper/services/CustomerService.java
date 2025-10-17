package com.desigveloper.services;

import com.desigveloper.dao.CustomerDao;
import com.desigveloper.model.Customer;

/**
 * CustomerService handles business logic related to Customer operations.
 * It acts as an intermediary between the CustomerResource and CustomerDao,
 * processing data and applying business rules as needed.
*/

public class CustomerService {
    private CustomerDao customerDao;

    // Dependency injection through constructor
    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public Customer findById(int customerId) {
        // Business logic: only search if customerId is valid
        if (customerId > 0) {
            return customerDao.findById(customerId);
        } else {
            // Return empty customer
            return  Customer.builder(0, null, null).build();
        }
    }
}
