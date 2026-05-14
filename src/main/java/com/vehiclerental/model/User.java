package com.vehiclerental.model;

public class User {

    private String userId;
    private String username;
    private String password;
    private String fullName;
    private String email;
    private String role;

    // Default Constructor
    public User() {
    }

    // Parameterized Constructor
    public User(String userId, String username, String password,
                String fullName, String email, String role) {

        this.userId = userId;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.role = role;
    }

    // Convert Object to File String
    public String toFileString() {

        return userId + "," +
               username + "," +
               password + "," +
               fullName + "," +
               email + "," +
               role;
    }

    // Convert File String to Object
    public static User fromFileString(String line) {

        String[] parts = line.split(",");

        if (parts.length != 6) {
            return null;
        }

        return new User(
                parts[0],
                parts[1],
                parts[2],
                parts[3],
                parts[4],
                parts[5]
        );
    }

    // Getters and Setters

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
