package service;

import dao.VehicleDAO;
import model.Vehicle;
import java.util.List;

/**
 * Service layer for handling Vehicle operations.
 */
public class VehicleService {
    private VehicleDAO vehicleDAO;

    public VehicleService() {
        this.vehicleDAO = new VehicleDAO();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleDAO.addVehicle(vehicle);
    }

    public Vehicle getVehicleById(int vehicleId) {
        return vehicleDAO.getVehicleById(vehicleId);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleDAO.getAllVehicles();
    }

    public void updateVehicle(Vehicle vehicle) {
        vehicleDAO.updateVehicle(vehicle);
    }

    public void deleteVehicle(int vehicleId) {
        vehicleDAO.deleteVehicle(vehicleId);
    }
}
