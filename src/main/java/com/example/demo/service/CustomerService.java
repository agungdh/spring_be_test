package com.example.demo.service;

import com.example.demo.dto.CustomerCreateRequest;
import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer createCustomer(CustomerCreateRequest customerCreateRequest) {
        Customer customer = new Customer();
        customer.setName(customerCreateRequest.getName());
        customer.setAddress(customerCreateRequest.getAddress());

        return customerRepository.save(customer);
    }
}
