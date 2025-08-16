package com.ackodrive.model;

import java.time.LocalDate;

public class TestDriveBooking {
    private Long id;
    private String customerName;
    private String phoneNumber;
    private Car car;
    private LocalDate date;

    public TestDriveBooking(Long id, String customerName, String phoneNumber, Car car, LocalDate date) {
        this.id = id;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.car = car;
        this.date = date;
    }

    // Getters
    public Long getId() { return id; }
    public String getCustomerName() { return customerName; }
    public String getPhoneNumber() { return phoneNumber; }
    public Car getCar() { return car; }
    public LocalDate getDate() { return date; }
}