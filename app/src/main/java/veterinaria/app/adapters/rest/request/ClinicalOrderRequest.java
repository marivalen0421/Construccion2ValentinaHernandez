package veterinaria.app.adapters.rest.request;



public class ClinicalOrderRequest {

    private Long orderId;
    private Long petId;
    private Long ownerDocument;
    private Long veterinarianDocument;
    private Long medicine;
    private Long dateCreate;

    private String userNameVet;
    private String passwordVet;

    public void setUserNameVet(String userNameVet) {
        this.userNameVet = userNameVet;
    }

    public void setPasswordVet(String passwordVet) {
        this.passwordVet = passwordVet;
    }

    public String getUserNameVet() {
        return userNameVet;
    }

    public String getPasswordVet() {
        return passwordVet;
    }


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    public Long getVeterinarianDocument() {
        return veterinarianDocument;
    }

    public void setVeterinarianDocument(Long veterinarianDocument) {
        this.veterinarianDocument = veterinarianDocument;
    }

    public Long getMedicine() {
        return medicine;
    }

    public void setMedicine(Long medicine) {
        this.medicine = medicine;
    }

    public Long getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Long dateCreate) {
        this.dateCreate = dateCreate;
    }

    @Override
    public String toString() {
        return "ClinicalOrderRequest{" +
                "id=" + orderId +
                ", petId=" + petId +
                ", ownerDocument=" + ownerDocument +
                ", veterinarianDocument=" + veterinarianDocument +
                ", medicine=" + medicine +
                ", dateCreate=" + dateCreate +
                '}';
    }
}
