package dao;

import model.Vehicle;
import config.ConnectionManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object for Vehicle operations.
 */
public class VehicleDAO {

    // Insert a new vehicle
    public void addVehicle(Vehicle vehicle) {
        String query = "INSERT INTO Vehicles (model, rental_rate) VALUES (?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, vehicle.getModel());
            stmt.setDouble(2, vehicle.getRentalRate());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve a vehicle by ID
    public Vehicle getVehicleById(int vehicleId) {
        String query = "SELECT * FROM Vehicles WHERE vehicle_id = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, vehicleId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Vehicle(
                        rs.getInt("vehicle_id"),
                        rs.getString("model"),
                        rs.getDouble("rental_rate")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Retrieve all vehicles
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        String query = "SELECT * FROM Vehicles";
        try (Connection conn = ConnectionManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                vehicles.add(new Vehicle(
                        rs.getInt("vehicle_id"),
                        rs.getString("model"),
                        rs.getDouble("rental_rate")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    // Update vehicle details
    public void updateVehicle(Vehicle vehicle) {
        String query = "UPDATE Vehicles SET model = ?, rental_rate = ? WHERE vehicle_id = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, vehicle.getModel());
            stmt.setDouble(2, vehicle.getRentalRate());
            stmt.setInt(3, vehicle.getVehicleId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete vehicle
    public void deleteVehicle(int vehicleId) {
        String query = "DELETE FROM Vehicles WHERE vehicle_id = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, vehicleId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
