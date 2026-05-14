package com.vehiclerental.servlet;

import com.vehiclerental.model.User;
import com.vehiclerental.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/register")

public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String userId = request.getParameter("userId");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");

        User user = new User(
                userId,
                username,
                password,
                fullName,
                email,
                "user"
        );

        UserService userService = new UserService();

        boolean success = userService.registerUser(user);

        if (success) {

            response.sendRedirect("login.jsp?success=registered");

        } else {

            response.sendRedirect("register.jsp?error=failed");
        }
    }
}
