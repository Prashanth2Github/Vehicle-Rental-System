package model;

import java.util.Date;

public class Payment {
    private int id;
    private int rentalId;
    private double amount;
    private Date paymentDate;

    public Payment(int id, int rentalId, double amount, Date paymentDate) {
        this.id = id;
        this.rentalId = rentalId;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public int getId() { return id; }
    public int getRentalId() { return rentalId; }
    public double getAmount() { return amount; }
    public Date getPaymentDate() { return paymentDate; }

    public void setId(int id) { this.id = id; }
    public void setRentalId(int rentalId) { this.rentalId = rentalId; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setPaymentDate(Date paymentDate) { this.paymentDate = paymentDate; }
}
