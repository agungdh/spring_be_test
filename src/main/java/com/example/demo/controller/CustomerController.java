package com.example.demo.controller;

import com.example.demo.dto.CustomerCreateRequest;
import com.example.demo.dto.CustomerCreateResponse;
import com.example.demo.dto.CustomerUpdateRequest;
import com.example.demo.dto.CustomerUpdateResponse;
import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @PostMapping
    public ResponseEntity<CustomerCreateResponse> createCustomer(@RequestBody CustomerCreateRequest customer) {
        Customer customerEntity = customerService.createCustomer(customer);

        CustomerCreateResponse customerCreateResponse = new CustomerCreateResponse(customerEntity);

        return ResponseEntity.ok(customerCreateResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable UUID id) {
        Optional<Customer> customerEntity = customerService.getCustomerById(id);

        return customerEntity.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerUpdateResponse> updateCustomer(@PathVariable UUID id, @RequestBody CustomerUpdateRequest customer) {
        Optional<Customer> customerEntity = customerService.getCustomerById(id);

        if (customerEntity.isPresent()) {
            Customer updatedCustomerEntity = customerService.updateCustomer(customerEntity.get(), customer);

            CustomerUpdateResponse customerUpdateResponse = new CustomerUpdateResponse(updatedCustomerEntity);

            return ResponseEntity.ok(customerUpdateResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable UUID id) {
        Optional<Customer> customerEntity = customerService.getCustomerById(id);

        if (customerEntity.isPresent()) {
            customerService.deleteCustomer(customerEntity.get());

            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
