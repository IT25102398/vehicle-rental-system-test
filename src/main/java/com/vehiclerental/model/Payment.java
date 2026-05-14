package com.vehiclerental.model;

public class Payment {

    private String paymentId;
    private String bookingId;
    private String userId;
    private double amount;
    private String paymentDate;
    private String method;
    private String status;

    // Default Constructor
    public Payment() {
    }

    // Parameterized Constructor
    public Payment(String paymentId,
                   String bookingId,
                   String userId,
                   double amount,
                   String paymentDate,
                   String method,
                   String status) {

        this.paymentId = paymentId;
        this.bookingId = bookingId;
        this.userId = userId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.method = method;
        this.status = status;
    }

    // Convert Object to Text File Format
    public String toFileString() {

        return paymentId + "," +
               bookingId + "," +
               userId + "," +
               amount + "," +
               paymentDate + "," +
               method + "," +
               status;
    }

    // Convert Text File Line to Payment Object
    public static Payment fromFileString(String line) {

        if (line == null || line.trim().isEmpty()) {
            return null;
        }

        String[] parts = line.split(",");

        // Validate Data Count
        if (parts.length != 7) {
            return null;
        }

        try {

            return new Payment(
                    parts[0].trim(),
                    parts[1].trim(),
                    parts[2].trim(),
                    Double.parseDouble(parts[3].trim()),
                    parts[4].trim(),
                    parts[5].trim(),
                    parts[6].trim()
            );

        } catch (Exception e) {

            System.out.println("Error parsing payment data: " + e.getMessage());
            return null;
        }
    }

    // toString Method
    @Override
    public String toString() {

        return "Payment {" +
                "paymentId='" + paymentId + '\'' +
                ", bookingId='" + bookingId + '\'' +
                ", userId='" + userId + '\'' +
                ", amount=" + amount +
                ", paymentDate='" + paymentDate + '\'' +
                ", method='" + method + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    // Getters

    public String getPaymentId() {
        return paymentId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public String getMethod() {
        return method;
    }

    public String getStatus() {
        return status;
    }

    // Setters

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
