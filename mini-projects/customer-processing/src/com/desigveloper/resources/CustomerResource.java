package com.desigveloper.resources;

import com.desigveloper.dto.CustomerDTO;
import com.desigveloper.model.Customer;
import com.desigveloper.services.CustomerService;

/**
 * CustomerResource acts as a RESTful resource for handling customer-related HTTP requests.
 * It serves as an entry point for client interactions with customer data.
 * It interacts with the CustomerService to process business logic and data operations.
*/

public class CustomerResource {
    private CustomerService customerService;

    // Dependncy injection through construtor
    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    public CustomerDTO findById(int customerId) {
        Customer customer = customerService.findById(customerId);
            
        return CustomerDTO.toCustomerDTO(customer);
        
    }
}
