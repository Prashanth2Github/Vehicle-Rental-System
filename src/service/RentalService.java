package service;

import dao.RentalDAO;
import model.Rental;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * Service layer for handling Rental operations.
 */
public class RentalService {
    private RentalDAO rentalDAO;

    public RentalService() {
        this.rentalDAO = new RentalDAO();
    }

    public void addRental(Rental rental) {
        rentalDAO.addRental(rental);
    }

    public Rental getRentalById(int rentalId) {
        return rentalDAO.getRentalById(rentalId);
    }

    public List<Rental> getAllRentals() {
        return rentalDAO.getAllRentals();
    }

    public void updateRental(Rental rental) {
        rentalDAO.updateRental(rental);
    }

    public void deleteRental(int rentalId) {
        rentalDAO.deleteRental(rentalId);
    }

    // Calculate rental charges based on duration and distance traveled
    public double calculateRentalCharges(Rental rental, double rentalRatePerDay, double ratePerKm) {
        long days = ChronoUnit.DAYS.between(rental.getStartDate(), rental.getEndDate());
        return (days * rentalRatePerDay) + (rental.getDistanceTraveled() * ratePerKm);
    }
}
