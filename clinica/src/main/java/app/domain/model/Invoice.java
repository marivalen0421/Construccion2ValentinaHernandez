package app.domain.model;

import java.sql.Date;

public class Invoice {
    private long id;
    private Pet pet;
    private User Owner;
    private ClinicalOrder order;
    private String product;
    private double quantity;
    private boolean medicine;
    private Date date;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Pet getPet() {
        return pet;
    }
    public void setPet(Pet pet) {
        this.pet = pet;
    }
    public User getOwner() {
        return Owner;
    }
    public void setOwner(User owner) {
        Owner = owner;
    }
    public ClinicalOrder getOrder() {
        return order;
    }
    public void setOrder(ClinicalOrder order) {
        this.order = order;
    }
    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
    }
    public double getQuantity() {
        return quantity;
    }
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    public boolean isMedicine() {
        return medicine;
    }
    public void setMedicine(boolean medicine) {
        this.medicine = medicine;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

}