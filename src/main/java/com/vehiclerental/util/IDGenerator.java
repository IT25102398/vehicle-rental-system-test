package com.vehiclerental.util;

import java.util.UUID;

public class IDGenerator {

    // Generate User ID
    public static String generateUserId() {

        return "U" + UUID.randomUUID()
                .toString()
                .substring(0, 4)
                .toUpperCase();
    }

    // Generate Vehicle ID
    public static String generateVehicleId() {

        return "V" + UUID.randomUUID()
                .toString()
                .substring(0, 4)
                .toUpperCase();
    }

    // Generate Booking ID
    public static String generateBookingId() {

        return "B" + UUID.randomUUID()
                .toString()
                .substring(0, 4)
                .toUpperCase();
    }

    // Generate Payment ID
    public static String generatePaymentId() {

        return "P" + UUID.randomUUID()
                .toString()
                .substring(0, 4)
                .toUpperCase();
    }

    // Generate Review ID
    public static String generateReviewId() {

        return "R" + UUID.randomUUID()
                .toString()
                .substring(0, 4)
                .toUpperCase();
    }
}
