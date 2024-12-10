package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class CustomerUpdateRequest {
    @NotBlank
    private String name;
    @NotBlank
    private LocalDate birthday;
    @NotBlank
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
