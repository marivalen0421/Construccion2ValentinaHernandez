package veterinaria.app.adapters.rest.request;

import lombok.Getter;
import lombok.Setter;
import veterinaria.app.domain.model.enums.PetSpecies;

@Getter
@Setter
public class PetRequest {
    private Long petId;
    private String name;
    private int age;
    private PetSpecies species;
    private String breed;
    private double weight;
    private String size;
    private Long ownerDocument;
    private String userNameVet;
    private String passwordVet;

    @Override
    public String toString() {
        return "PetRequest{" +
                "petId=" + petId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", species=" + species +
                ", breed='" + breed + '\'' +
                ", weight=" + weight +
                ", size='" + size + '\'' +
                ", ownerDocument=" + ownerDocument +
                '}';
    }
}

