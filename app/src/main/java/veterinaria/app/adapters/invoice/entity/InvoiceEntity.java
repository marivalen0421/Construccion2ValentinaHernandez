package veterinaria.app.adapters.invoice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import veterinaria.app.adapters.clinicalOrder.entity.ClinicalOrderEntity;
import veterinaria.app.adapters.person.entity.PersonEntity;
import veterinaria.app.adapters.pet.entity.PetEntity;

@Entity
@Table(name = "invoice")
@Getter
@Setter
public class InvoiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn (name = "pet_id_order")
    @ManyToOne
    private PetEntity petId;

    @JoinColumn(name = "owner_document_order")
    @ManyToOne
    private PersonEntity ownerDocument;

    @JoinColumn(name = "clinical_order_id")
    @OneToOne
    private ClinicalOrderEntity clinicalOrder;

    @Column(name = "product")
    private String product;

    @Column(name = "value")
    private double value;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "date")
    private Long date;

}
