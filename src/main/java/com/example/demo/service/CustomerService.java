package com.example.demo.service;

import com.example.demo.dto.CustomerCreateRequest;
import com.example.demo.dto.CustomerUpdateRequest;
import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer createCustomer(CustomerCreateRequest customerCreateRequest) {
        Customer customer = new Customer(customerCreateRequest);

        return customerRepository.save(customer);
    }

    public Optional<Customer> getCustomerById(UUID id) {
        return customerRepository.findById(id);
    }

    public Customer updateCustomer(Customer customer, CustomerUpdateRequest customerUpdateRequest) {
        customer.setName(customerUpdateRequest.getName());
        customer.setAddress(customerUpdateRequest.getAddress());
        customer.setBirthday(customerUpdateRequest.getBirthday());

        return customerRepository.save(customer);
    }

    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }
}
