package com.example.demo.controller;

import com.example.demo.dto.CustomerCreateRequest;
import com.example.demo.dto.CustomerCreateResponse;
import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomer() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @PostMapping
    public ResponseEntity<CustomerCreateResponse> createCustomer(@RequestBody CustomerCreateRequest customer) {
        Customer customerEntity = customerService.createCustomer(customer);

        CustomerCreateResponse customerCreateResponse = new CustomerCreateResponse(customerEntity);

        return ResponseEntity.ok(customerCreateResponse);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Customer> getCustomer(@PathVariable UUID id) {
//        return customerRepository.findById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
//        return employeeRepository.findById(id)
//                .map(employee -> ResponseEntity.ok(employee)) // HTTP 200
//                .orElse(ResponseEntity.notFound().build());   // HTTP 404
//    }

}
