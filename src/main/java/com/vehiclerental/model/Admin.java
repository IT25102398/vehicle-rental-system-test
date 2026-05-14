package com.vehiclerental.model;

public class Admin extends User {

    public Admin() {
        super();
    }

    public Admin(String userId, String username, String password,
                 String fullName, String email) {

        super(userId, username, password, fullName, email, "admin");
    }

    public void showAdminAccess() {

        System.out.println("Admin Access Granted");
    }
}
