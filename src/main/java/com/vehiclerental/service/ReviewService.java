package com.vehiclerental.service;

import com.vehiclerental.model.Review;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewService {

    private static final String FILE_PATH = "data/reviews.txt";

    // Add Review
    public boolean addReview(Review review) {

        try {

            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(FILE_PATH, true)
            );

            writer.write(review.toFileString());
            writer.newLine();

            writer.close();

            return true;

        } catch (IOException e) {

            e.printStackTrace();
            return false;
        }
    }

    // Get All Reviews
    public List<Review> getAllReviews() {

        List<Review> reviews = new ArrayList<>();

        try {

            BufferedReader reader = new BufferedReader(
                    new FileReader(FILE_PATH)
            );

            String line;

            while ((line = reader.readLine()) != null) {

                Review review = Review.fromFileString(line);

                if (review != null) {
                    reviews.add(review);
                }
            }

            reader.close();

        } catch (IOException e) {

            e.printStackTrace();
        }

        return reviews;
    }
}
