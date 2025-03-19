package controllers;

import model.Location;
import service.LocationService;
import java.util.List;

/**
 * Controller for managing location-related operations.
 */
public class LocationController {
    private LocationService locationService;

    public LocationController() {
        this.locationService = new LocationService();
    }

    public void addLocation(String name, String address) {
        Location location = new Location(0, name, address); // ID auto-generated
        locationService.addLocation(location);
    }

    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }
}
