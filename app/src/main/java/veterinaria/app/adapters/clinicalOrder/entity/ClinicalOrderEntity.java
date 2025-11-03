package veterinaria.app.adapters.clinicalOrder.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import veterinaria.app.adapters.historyClinical.entity.HistoryClinicalEntity;
import veterinaria.app.adapters.person.entity.PersonEntity;
import veterinaria.app.adapters.pet.entity.PetEntity;
@Entity
@Table(name = "clinical_order")
@Getter
@Setter
public class ClinicalOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long orderId;

    @Column(name = "date")
    private Long dateCreate;

    @OneToOne
    @JoinColumn(name = "medicine", nullable = false)
    private HistoryClinicalEntity medicine;

    @ManyToOne
    @JoinColumn(name = "owner_document", nullable = false)
    private PersonEntity ownerDocument;

    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private PetEntity petId;

    @ManyToOne
    @JoinColumn(name = "veterinarian_document", nullable = false)
    private PersonEntity veterinarianDocument;
}
