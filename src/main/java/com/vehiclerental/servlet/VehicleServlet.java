package com.vehiclerental.servlet;

import com.vehiclerental.model.Vehicle;
import com.vehiclerental.service.VehicleService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/addVehicle")

public class VehicleServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String vehicleId = request.getParameter("vehicleId");
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String brand = request.getParameter("brand");

        double dailyRate = Double.parseDouble(
                request.getParameter("dailyRate")
        );

        String availability = request.getParameter("availability");

        Vehicle vehicle = new Vehicle(
                vehicleId,
                name,
                type,
                brand,
                dailyRate,
                availability
        );

        VehicleService vehicleService = new VehicleService();

        boolean success = vehicleService.addVehicle(vehicle);

        if (success) {

            response.sendRedirect("manageVehicles.jsp");

        } else {

            response.sendRedirect("addVehicle.jsp?error=failed");
        }
    }
}
