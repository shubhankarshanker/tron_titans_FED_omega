package com.ackodrive.model;

public class Car {
    private Long id;
    private String name;
    private String price;
    private String mileage;
    private String fuelType;

    public Car(Long id, String name, String price, String mileage, String fuelType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.mileage = mileage;
        this.fuelType = fuelType;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getPrice() { return price; }
    public String getMileage() { return mileage; }
    public String getFuelType() { return fuelType; }
}