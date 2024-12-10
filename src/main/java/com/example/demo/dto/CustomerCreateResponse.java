package com.example.demo.dto;

import com.example.demo.entity.Customer;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class CustomerCreateResponse {
    private UUID id;
    private String name;
    private LocalDate birthday;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }
}
