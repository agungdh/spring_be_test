package com.example.demo.dto;

import com.example.demo.entity.Customer;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.UUID;

public class CustomerCreateResponse {
    private UUID id;
    private String name;
    private Date birthday;
    private String address;

    public CustomerCreateResponse(Customer customer) {
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

    public Date getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }
}
