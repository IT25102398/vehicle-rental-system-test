package com.vehiclerental.service;

import com.vehiclerental.model.Booking;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookingService {

    private static final String FILE_PATH = "data/bookings.txt";

    // Create Booking
    public boolean createBooking(Booking booking) {

        try {

            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(FILE_PATH, true)
            );

            writer.write(booking.toFileString());
            writer.newLine();

            writer.close();

            return true;

        } catch (IOException e) {

            e.printStackTrace();
            return false;
        }
    }

    // Get All Bookings
    public List<Booking> getAllBookings() {

        List<Booking> bookings = new ArrayList<>();

        try {

            BufferedReader reader = new BufferedReader(
                    new FileReader(FILE_PATH)
            );

            String line;

            while ((line = reader.readLine()) != null) {

                Booking booking = Booking.fromFileString(line);

                if (booking != null) {
                    bookings.add(booking);
                }
            }

            reader.close();

        } catch (IOException e) {

            e.printStackTrace();
        }

        return bookings;
    }
}
