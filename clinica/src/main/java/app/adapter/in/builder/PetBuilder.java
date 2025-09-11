package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.PetValidator;
import app.adapter.in.validators.UserValidator;
import app.domain.model.Pet;
import app.domain.model.User;

@Component
public class PetBuilder {
    @Autowired
    private PetValidator petValidator;
    @Autowired
    private UserValidator userValidator;

    public Pet builder(String document, String age, String weigth, String spices, String description,String race, String name) throws Exception{
        Pet pet = new Pet();
        User owner = new User();

        owner.setDocument(userValidator.documentValidator(document));
        pet.setOwner(owner);
        pet.setAge(petValidator.ageValidator(age));
        pet.setWeight(petValidator.weigthValidator(weigth));
        pet.setRace(petValidator.raceValidator(race));
        pet.setDescription(petValidator.descriptionValidator(description));
        pet.setPetName(petValidator.nameValidator(name));
        pet.setSpices(petValidator.spicesValidator(spices));
        return pet;
    }
}
