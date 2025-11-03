package veterinaria.app.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ClinicalOrder {

    private Long OrderId;
    private Pet petId;
    private Person ownerDocument;
    private Person veterinarianDocument;
    private ClinicalHistory medicine;
    private Long dateCreate;

    public ClinicalOrder(Long orderId, Pet petId, Person ownerDocument, Person veterinarianDocument, ClinicalHistory medicine, Long dateCreate) {
        this.OrderId = orderId;
        this.petId = petId;
        this.ownerDocument = ownerDocument;
        this.veterinarianDocument = veterinarianDocument;
        this.medicine = medicine;
        this.dateCreate = dateCreate;
    }
}