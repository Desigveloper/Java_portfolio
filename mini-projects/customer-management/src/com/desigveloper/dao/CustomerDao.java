package com.desigveloper.dao;

import java.time.LocalDate;

import com.desigveloper.model.Customer;

/**
 * CustomerDao is responsible for data access operations related to Customer entities.
 * It provides methods to interact with the database, such as creating, reading,
 * updating, and deleting customer records.
*/

public class CustomerDao {
    /**
     * 
     * @param customerId
     * @return customer
    */

    public Customer findById(int customerId) {
        // In a real-world application, this would query a database

        return Customer.builder(customerId, "John Doe", LocalDate.of(1990, 01, 15))
            .withAddress("123 Main St, Cityville")
            .withEmail("john.doe@example.com")
            .withSalary(750000.75)
            .withLogin("johndoe")
            .withPasswordToken("encrypted_token_123")
            .build();
    }
}
