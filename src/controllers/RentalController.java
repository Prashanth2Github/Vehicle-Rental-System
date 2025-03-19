package controllers;

import model.Rental;
import service.RentalService;
import java.time.LocalDate;
import java.util.List;

/**
 * Controller for managing rental-related operations.
 */
public class RentalController {
    private RentalService rentalService;

    public RentalController() {
        this.rentalService = new RentalService();
    }

    public void addRental(int userId, int vehicleId, LocalDate startDate, LocalDate endDate, int distanceTraveled) {
        Rental rental = new Rental(0, userId, vehicleId, startDate, endDate, distanceTraveled); // ID auto-generated
        rentalService.addRental(rental);
    }

    public Rental getRentalById(int rentalId) {
        return rentalService.getRentalById(rentalId);
    }

    public List<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }

    public void updateRental(int rentalId, int userId, int vehicleId, LocalDate startDate, LocalDate endDate, int distanceTraveled) {
        Rental rental = new Rental(rentalId, userId, vehicleId, startDate, endDate, distanceTraveled);
        rentalService.updateRental(rental);
    }

    public void deleteRental(int rentalId) {
        rentalService.deleteRental(rentalId);
    }

    public double calculateRentalCharges(int rentalId, double rentalRatePerDay, double ratePerKm) {
        Rental rental = rentalService.getRentalById(rentalId);
        if (rental != null) {
            return rentalService.calculateRentalCharges(rental, rentalRatePerDay, ratePerKm);
        }
        return 0.0;
    }
}
