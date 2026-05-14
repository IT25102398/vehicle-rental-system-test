package com.vehiclerental.servlet;

import com.vehiclerental.model.Payment;
import com.vehiclerental.service.PaymentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/processPayment")

public class PaymentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String paymentId = request.getParameter("paymentId");
        String bookingId = request.getParameter("bookingId");
        String userId = request.getParameter("userId");

        double amount = Double.parseDouble(
                request.getParameter("amount")
        );

        String method = request.getParameter("method");

        Payment payment = new Payment(
                paymentId,
                bookingId,
                userId,
                amount,
                LocalDate.now().toString(),
                method,
                "success"
        );

        PaymentService paymentService = new PaymentService();

        boolean success = paymentService.processPayment(payment);

        if (success) {

            response.sendRedirect("paymentConfirmation.jsp");

        } else {

            response.sendRedirect("payment.jsp?error=failed");
        }
    }
}
