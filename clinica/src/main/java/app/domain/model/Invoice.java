package app.domain.model;

public class Invoice {
    private long invoceId;
    private Pet petId;
    private Person ownerId;
    private String productName;
    private  int quantity;
    private Order orderId;

    public Invoice(long invoceId, Pet petId, Person ownerId, String productName, int quantity, Order orderId) {
        this.invoceId = invoceId;
        this.petId = petId;
        this.ownerId = ownerId;
        this.productName = productName;
        this.quantity = quantity;
        this.orderId = orderId;
    }
}