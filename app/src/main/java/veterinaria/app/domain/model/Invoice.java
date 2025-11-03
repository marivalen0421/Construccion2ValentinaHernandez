package veterinaria.app.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Invoice {

    private Long id;
    private Pet petId;
    private Person ownerDocument;
    private ClinicalOrder orderId;
    private String product;
    private double value;
    private int quantity;
    private Long date;

}
