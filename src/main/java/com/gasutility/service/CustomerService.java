package com.gasutility.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gasutility.model.Customer;
import com.gasutility.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository; 
    }

   
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id); 
    }
}