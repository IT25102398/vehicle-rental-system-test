package com.vehiclerental.service;

import com.vehiclerental.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    private static final String FILE_PATH = "data/users.txt";

    // Register User
    public boolean registerUser(User user) {

        try {

            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(FILE_PATH, true)
            );

            writer.write(user.toFileString());
            writer.newLine();

            writer.close();

            return true;

        } catch (IOException e) {

            e.printStackTrace();
            return false;
        }
    }

    // Get All Users
    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();

        try {

            BufferedReader reader = new BufferedReader(
                    new FileReader(FILE_PATH)
            );

            String line;

            while ((line = reader.readLine()) != null) {

                User user = User.fromFileString(line);

                if (user != null) {
                    users.add(user);
                }
            }

            reader.close();

        } catch (IOException e) {

            e.printStackTrace();
        }

        return users;
    }

    // Login Validation
    public User validateLogin(String username, String password) {

        List<User> users = getAllUsers();

        for (User user : users) {

            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {

                return user;
            }
        }

        return null;
    }
}
