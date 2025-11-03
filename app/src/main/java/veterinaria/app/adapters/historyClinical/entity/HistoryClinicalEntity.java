package veterinaria.app.adapters.historyClinical.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import veterinaria.app.adapters.person.entity.PersonEntity;
import veterinaria.app.adapters.pet.entity.PetEntity;

@Entity
@Table(name = "clinical_history")
@Getter
@Setter
public class HistoryClinicalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private Long date;

    @ManyToOne
    @JoinColumn(name = "veterinarian_document", referencedColumnName = "id", nullable = false)
    private PersonEntity veterinarianDocument;

    @Column(name = "reason")
    private String reason;

    @ManyToOne
    @JoinColumn(name = "pet_id", referencedColumnName = "id", nullable = false)
    private PetEntity petId;

    @Column(name = "symptoms")
    private String symptoms;

    @Column(name = "procedures")
    private String procedures;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "medications")
    private String medications;

    @Column(name = "dose")
    private String dose;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "vaccination_history_id")
    private String vaccinationHistoryId;

    @Column(name = "allergies")
    private String allergies;

    @Column(name = "notes")
    private String procedureNotes;
}

