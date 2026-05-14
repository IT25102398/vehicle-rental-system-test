package com.vehiclerental.service;

import com.vehiclerental.model.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleService {

    private static final String FILE_PATH = "data/vehicles.txt";

    // Add Vehicle
    public boolean addVehicle(Vehicle vehicle) {

        try {

            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(FILE_PATH, true)
            );

            writer.write(vehicle.toFileString());
            writer.newLine();

            writer.close();

            return true;

        } catch (IOException e) {

            e.printStackTrace();
            return false;
        }
    }

    // Get All Vehicles
    public List<Vehicle> getAllVehicles() {

        List<Vehicle> vehicles = new ArrayList<>();

        try {

            BufferedReader reader = new BufferedReader(
                    new FileReader(FILE_PATH)
            );

            String line;

            while ((line = reader.readLine()) != null) {

                Vehicle vehicle = Vehicle.fromFileString(line);

                if (vehicle != null) {
                    vehicles.add(vehicle);
                }
            }

            reader.close();

        } catch (IOException e) {

            e.printStackTrace();
        }

        return vehicles;
    }

    // Find Vehicle By ID
    public Vehicle getVehicleById(String vehicleId) {

        List<Vehicle> vehicles = getAllVehicles();

        for (Vehicle vehicle : vehicles) {

            if (vehicle.getVehicleId().equals(vehicleId)) {
                return vehicle;
            }
        }

        return null;
    }
}
