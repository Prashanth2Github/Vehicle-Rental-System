package service;

import dao.LocationDAO;
import model.Location;
import java.util.List;

/**
 * Service layer for handling Location operations.
 */
public class LocationService {
    private LocationDAO locationDAO;

    public LocationService() {
        this.locationDAO = new LocationDAO();
    }

    public void addLocation(Location location) {
        locationDAO.addLocation(location);
    }

    public List<Location> getAllLocations() {
        return locationDAO.getAllLocations();
    }
}
