package com.vehiclerental.model;

public class Booking {

    private String bookingId;
    private String userId;
    private String vehicleId;
    private String startDate;
    private String endDate;
    private double totalCost;
    private String status;

    public Booking() {
    }

    public Booking(String bookingId, String userId, String vehicleId,
                   String startDate, String endDate,
                   double totalCost, String status) {

        this.bookingId = bookingId;
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalCost = totalCost;
        this.status = status;
    }

    public double calculateCost(int days, double dailyRate) {

        return days * dailyRate;
    }

    public String toFileString() {

        return bookingId + "," +
               userId + "," +
               vehicleId + "," +
               startDate + "," +
               endDate + "," +
               totalCost + "," +
               status;
    }

    public static Booking fromFileString(String line) {

        String[] parts = line.split(",");

        if (parts.length != 7) {
            return null;
        }

        return new Booking(
                parts[0],
                parts[1],
                parts[2],
                parts[3],
                parts[4],
                Double.parseDouble(parts[5]),
                parts[6]
        );
    }

    // Getters and Setters

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
