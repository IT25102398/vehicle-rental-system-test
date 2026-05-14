package com.vehiclerental.service;

import com.vehiclerental.model.Payment;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentService {

    private static final String FILE_PATH = "data/payments.txt";

    // Process Payment
    public boolean processPayment(Payment payment) {

        try {

            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(FILE_PATH, true)
            );

            writer.write(payment.toFileString());
            writer.newLine();

            writer.close();

            return true;

        } catch (IOException e) {

            e.printStackTrace();
            return false;
        }
    }

    // Get All Payments
    public List<Payment> getAllPayments() {

        List<Payment> payments = new ArrayList<>();

        try {

            BufferedReader reader = new BufferedReader(
                    new FileReader(FILE_PATH)
            );

            String line;

            while ((line = reader.readLine()) != null) {

                Payment payment = Payment.fromFileString(line);

                if (payment != null) {
                    payments.add(payment);
                }
            }

            reader.close();

        } catch (IOException e) {

            e.printStackTrace();
        }

        return payments;
    }
}
