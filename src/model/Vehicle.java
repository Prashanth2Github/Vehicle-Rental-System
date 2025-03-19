package model;

public class Vehicle {
    private int id;
    private String model;
    private String type;
    private double rentalPrice;

    public Vehicle(int id, String model, String type, double rentalPrice) {
        this.id = id;
        this.model = model;
        this.type = type;
        this.rentalPrice = rentalPrice;
    }

    public int getId() { return id; }
    public String getModel() { return model; }
    public String getType() { return type; }
    public double getRentalPrice() { return rentalPrice; }

    public void setId(int id) { this.id = id; }
    public void setModel(String model) { this.model = model; }
    public void setType(String type) { this.type = type; }
    public void setRentalPrice(double rentalPrice) { this.rentalPrice = rentalPrice; }
}
