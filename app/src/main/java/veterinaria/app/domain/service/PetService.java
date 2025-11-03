package veterinaria.app.domain.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veterinaria.app.adapters.pet.PetAdapter;
import veterinaria.app.domain.model.Person;
import veterinaria.app.domain.model.Pet;
import veterinaria.app.domain.model.enums.PetSpecies;
import veterinaria.app.exceptions.NotFoundException;

@Getter
@Setter
@NoArgsConstructor
@Service
public class PetService {
    @Autowired
    private PetAdapter petAdapter;
    @Autowired
    private PersonService personService;
    public Pet searchPet(long petId) throws Exception {
        Pet pet = petAdapter.findByPetId(petId);
        if(pet == null) throw new NotFoundException("There is no pet registered with that id");
        return pet;
    }
    public Pet savePet(Long documentOwner, String name, int age, PetSpecies species, String breed, double weight, String size) throws Exception {

       Person owner = personService.existsPerson(documentOwner, "There is no owner registered with that id");

        Pet newPet = new Pet();
        newPet.setName(name);
        newPet.setAge(age);
        newPet.setSpecies(species);
        newPet.setBreed(breed);
        newPet.setWeight(weight);
        newPet.setSize(size);
        newPet.setOwnerDocument(owner);

        petAdapter.save(newPet);
        System.out.println("\nThe pet has been saved successfully");
        return newPet;

    }


}
