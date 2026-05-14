package com.vehiclerental.util;

public class ValidationUtil {

    // Check Empty Field
    public static boolean isEmpty(String value) {

        return value == null || value.trim().isEmpty();
    }

    // Email Validation
    public static boolean isValidEmail(String email) {

        return email.contains("@") && email.contains(".");
    }

    // Password Validation
    public static boolean isValidPassword(String password) {

        return password.length() >= 4;
    }
}
