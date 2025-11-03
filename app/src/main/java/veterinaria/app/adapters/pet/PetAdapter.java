package veterinaria.app.adapters.pet;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veterinaria.app.adapters.person.entity.PersonEntity;
import veterinaria.app.adapters.person.repository.PersonRepository;
import veterinaria.app.adapters.pet.entity.PetEntity;
import veterinaria.app.adapters.pet.repository.PetRepository;
import veterinaria.app.domain.model.Person;
import veterinaria.app.domain.model.Pet;

@Getter
@Setter
@NoArgsConstructor
@Service
public class PetAdapter {
    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PersonRepository personRepository;

    public Pet findByPetId(Long petId) {
        PetEntity petEntity = petRepository.findByPetId(petId);
        if(petEntity == null) return null;

        return petAdapter(petEntity);
    }

    public void save(Pet pet){
        PersonEntity personEntity = new PersonEntity();
        personEntity.setDocument(pet.getOwnerDocument().getDocument());
        personEntity.setName(pet.getOwnerDocument().getName());
        personEntity.setAge(pet.getOwnerDocument().getAge());
        personEntity.setRole(pet.getOwnerDocument().getRole());

        PetEntity petEntity = new PetEntity();
        petEntity.setName(pet.getName());
        petEntity.setAge(pet.getAge());
        petEntity.setSize(pet.getSize());
        petEntity.setSpecies(pet.getSpecies());
        petEntity.setBreed(pet.getBreed());
        petEntity.setWeight(pet.getWeight());
        petEntity.setDocumentOwner(personEntity);

        PetEntity petE =petRepository.save(petEntity);
        pet.setPetId(petE.getPetId());


    }


    public Pet petAdapter(PetEntity petEntity) {

        Person person = new Person();
        person.setAge(petEntity.getDocumentOwner().getAge());
        person.setDocument(petEntity.getDocumentOwner().getDocument());
        person.setName(petEntity.getDocumentOwner().getName());
        person.setRole(petEntity.getDocumentOwner().getRole());

        Pet pet = new Pet();
        pet.setAge(petEntity.getAge());
        pet.setName(petEntity.getName());
        pet.setOwnerDocument(person);
        pet.setName(petEntity.getName());
        pet.setBreed(petEntity.getBreed());
        pet.setSpecies(petEntity.getSpecies());
        pet.setWeight(petEntity.getWeight());
        pet.setPetId(petEntity.getPetId());

        return pet;
    }


}
