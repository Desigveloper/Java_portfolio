package com.desigveloper.services;

import com.desigveloper.dao.CustomerDao;

/**
 * CustomerService handles business logic related to Customer operations.
 * It acts as an intermediary between the CustomerResource and CustomerDao,
 * processing data and applying business rules as needed.
*/

public class CustomerService {
    private CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
}
