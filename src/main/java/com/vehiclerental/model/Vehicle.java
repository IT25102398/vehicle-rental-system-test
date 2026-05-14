package com.vehiclerental.model;

public class Vehicle {

    private String vehicleId;
    private String name;
    private String type;
    private String brand;
    private double dailyRate;
    private String availability;

    public Vehicle() {
    }

    public Vehicle(String vehicleId, String name, String type,
                   String brand, double dailyRate, String availability) {

        this.vehicleId = vehicleId;
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.dailyRate = dailyRate;
        this.availability = availability;
    }

    public boolean isAvailable() {

        return availability.equalsIgnoreCase("available");
    }

    public String toFileString() {

        return vehicleId + "," +
               name + "," +
               type + "," +
               brand + "," +
               dailyRate + "," +
               availability;
    }

    public static Vehicle fromFileString(String line) {

        String[] parts = line.split(",");

        if (parts.length != 6) {
            return null;
        }

        return new Vehicle(
                parts[0],
                parts[1],
                parts[2],
                parts[3],
                Double.parseDouble(parts[4]),
                parts[5]
        );
    }

    // Getters and Setters

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}
