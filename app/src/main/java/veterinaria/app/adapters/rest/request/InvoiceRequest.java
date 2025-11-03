package veterinaria.app.adapters.rest.request;



public class InvoiceRequest {
    private Long id;
    private Long petId;
    private Long ownerDocument;
    private Long orderId;
    private String product;
    private double value;
    private int quantity;
    private Long date;
    private String userNameSeller;
    private String passwordSeller;

    public String getUserNameSeller() {
        return userNameSeller;
    }

    public void setUserNameSeller(String userNameSeller) {
        this.userNameSeller = userNameSeller;
    }

    public String getPasswordSeller() {
        return passwordSeller;
    }

    public void setPasswordSeller(String passwordSeller) {
        this.passwordSeller = passwordSeller;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public Long getOwnerDocument() {
        return ownerDocument;
    }

    public void setOwnerDocument(Long ownerDocument) {
        this.ownerDocument = ownerDocument;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "InvoiceRequest{" +
                "id=" + id +
                ", petId=" + petId +
                ", ownerDocument=" + ownerDocument +
                ", orderId=" + orderId +
                ", product='" + product + '\'' +
                ", value=" + value +
                ", quantity=" + quantity +
                ", date=" + date +
                ", userNameSeller='" + userNameSeller + '\'' +
                ", passwordSeller='" + passwordSeller + '\'' +
                '}';
    }
}
