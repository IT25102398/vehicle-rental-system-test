package com.vehiclerental.servlet;

import com.vehiclerental.model.Review;
import com.vehiclerental.service.ReviewService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/submitReview")

public class ReviewServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String reviewId = request.getParameter("reviewId");
        String userId = request.getParameter("userId");
        String vehicleId = request.getParameter("vehicleId");

        int rating = Integer.parseInt(
                request.getParameter("rating")
        );

        String comment = request.getParameter("comment");

        Review review = new Review(
                reviewId,
                userId,
                vehicleId,
                rating,
                comment,
                LocalDate.now().toString()
        );

        ReviewService reviewService = new ReviewService();

        boolean success = reviewService.addReview(review);

        if (success) {

            response.sendRedirect("reviews.jsp");

        } else {

            response.sendRedirect("submitReview.jsp?error=failed");
        }
    }
}
