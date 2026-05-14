package com.vehiclerental.servlet;

import com.vehiclerental.model.Booking;
import com.vehiclerental.service.BookingService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/createBooking")

public class BookingServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String bookingId = request.getParameter("bookingId");
        String userId = request.getParameter("userId");
        String vehicleId = request.getParameter("vehicleId");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");

        double totalCost = Double.parseDouble(
                request.getParameter("totalCost")
        );

        Booking booking = new Booking(
                bookingId,
                userId,
                vehicleId,
                startDate,
                endDate,
                totalCost,
                "confirmed"
        );

        BookingService bookingService = new BookingService();

        boolean success = bookingService.createBooking(booking);

        if (success) {

            response.sendRedirect("payment.jsp");

        } else {

            response.sendRedirect("booking.jsp?error=failed");
        }
    }
}
