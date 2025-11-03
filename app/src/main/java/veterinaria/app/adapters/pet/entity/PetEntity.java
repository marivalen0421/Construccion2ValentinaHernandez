package veterinaria.app.adapters.pet.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import veterinaria.app.adapters.person.entity.PersonEntity;
import veterinaria.app.domain.model.enums.PetSpecies;


@Entity
@Table(name = "pet")
@Getter
@Setter
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long petId;

    @JoinColumn(name="owner_document", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private PersonEntity documentOwner;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Enumerated(EnumType.STRING)
    @Column(name = "species")
    private PetSpecies species;

    @Column(name = "breed")
    private String breed;

    @Column(name = "weight")
    private double weight;

    @Column(name = "size")
    private String size;

}
