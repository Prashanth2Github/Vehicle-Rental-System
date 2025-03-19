package controllers;

import model.Vehicle;
import service.VehicleService;
import java.util.List;

/**
 * Controller for managing vehicle-related operations.
 */
public class VehicleController {
    private VehicleService vehicleService;

    public VehicleController() {
        this.vehicleService = new VehicleService();
    }

    public void addVehicle(String model, double rentalRate) {
        Vehicle vehicle = new Vehicle(0, model, rentalRate); // ID auto-generated
        vehicleService.addVehicle(vehicle);
    }

    public Vehicle getVehicleById(int vehicleId) {
        return vehicleService.getVehicleById(vehicleId);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    public void updateVehicle(int vehicleId, String model, double rentalRate) {
        Vehicle vehicle = new Vehicle(vehicleId, model, rentalRate);
        vehicleService.updateVehicle(vehicle);
    }

    public void deleteVehicle(int vehicleId) {
        vehicleService.deleteVehicle(vehicleId);
    }
}
