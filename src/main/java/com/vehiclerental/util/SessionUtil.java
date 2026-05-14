package com.vehiclerental.util;

import jakarta.servlet.http.HttpSession;

public class SessionUtil {

    // Check Login
    public static boolean isLoggedIn(HttpSession session) {

        return session != null &&
               session.getAttribute("user") != null;
    }

    // Check Admin Access
    public static boolean isAdmin(HttpSession session) {

        if (!isLoggedIn(session)) {
            return false;
        }

        Object role = session.getAttribute("role");

        return role != null &&
               role.toString().equalsIgnoreCase("admin");
    }
}
