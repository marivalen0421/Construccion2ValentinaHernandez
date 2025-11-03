package veterinaria.app.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import veterinaria.app.domain.model.enums.PetSpecies;

@Getter
@Setter
@NoArgsConstructor
public class Pet {

    private Long petId;
    private String name;
    private int age;
    private PetSpecies species;
    private String breed;
    private double weight;
    private String size;
    private Person ownerDocument;


}
