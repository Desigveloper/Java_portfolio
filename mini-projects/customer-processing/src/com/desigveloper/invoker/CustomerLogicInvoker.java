package com.desigveloper.invoker;

import com.desigveloper.dao.CustomerDao;
import com.desigveloper.dto.CustomerDTO;
import com.desigveloper.resources.CustomerResource;
import com.desigveloper.services.CustomerService;

public class CustomerLogicInvoker {
    public static void main(String[] args) throws Exception {
        // Chain instantiation as specied
        CustomerDao customerDao = new CustomerDao();
        CustomerService customerService = new CustomerService(customerDao);
        CustomerResource customerResource = new CustomerResource(customerService);

        // Test with negative ID (Should return empty DTO)
        System.out.println("Test with negative ID:");
        CustomerDTO emptyCustomer = customerResource.findById(-1);
        System.out.println("Result: " + emptyCustomer);
        System.out.println();

        // Test with valid customer
        System.out.println("Test with valid ID (1):");
        CustomerDTO validCustomer = customerResource.findById(1);
        System.out.println("Result: " + validCustomer);

        // Print indiviual fields to verify
        System.out.println("\nDetailed Information:");
        System.out.println("Name: " + validCustomer.getName());
        System.out.println("Birth Date: " + validCustomer.getBirthDate());
        System.out.println("Email: " + validCustomer.getEmail());
        System.out.println("Salary: " + validCustomer.getSalary());
        System.out.println("Address: " + validCustomer.getAddress());
    }
}
