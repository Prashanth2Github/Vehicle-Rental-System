package model;

public class User {
    private int id;
    private String name;
    private String contactInfo;
    private String paymentMethod;

    public User(int id, String name, String contactInfo, String paymentMethod) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
        this.paymentMethod = paymentMethod;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getContactInfo() { return contactInfo; }
    public String getPaymentMethod() { return paymentMethod; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
}
