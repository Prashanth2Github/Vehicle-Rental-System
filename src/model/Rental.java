package model;

import java.util.Date;

public class Rental {
    private int id;
    private int userId;
    private int vehicleId;
    private Date startDate;
    private Date endDate;
    private double distanceTraveled;

    public Rental(int id, int userId, int vehicleId, Date startDate, Date endDate, double distanceTraveled) {
        this.id = id;
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.distanceTraveled = distanceTraveled;
    }

    public int getId() { return id; }
    public int getUserId() { return userId; }
    public int getVehicleId() { return vehicleId; }
    public Date getStartDate() { return startDate; }
    public Date getEndDate() { return endDate; }
    public double getDistanceTraveled() { return distanceTraveled; }

    public void setId(int id) { this.id = id; }
    public void setUserId(int userId) { this.userId = userId; }
    public void setVehicleId(int vehicleId) { this.vehicleId = vehicleId; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }
    public void setDistanceTraveled(double distanceTraveled) { this.distanceTraveled = distanceTraveled; }
}
