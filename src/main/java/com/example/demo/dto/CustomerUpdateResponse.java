package com.example.demo.dto;

import com.example.demo.entity.Customer;

import java.time.LocalDate;
import java.util.UUID;

public class CustomerUpdateResponse {
    private UUID id;
    private String name;
    private LocalDate birthday;
    private String address;

    public CustomerUpdateResponse(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.birthday = customer.getBirthday();
        this.address = customer.getAddress();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }
}
