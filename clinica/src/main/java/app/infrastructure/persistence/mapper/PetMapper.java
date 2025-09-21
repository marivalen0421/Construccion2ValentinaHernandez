package app.infrastructure.persistence.mapper;

import app.domain.model.emuns.Species;
import app.domain.model.Pet;
import app.infrastructure.persistence.entities.PetEntity;

public class PetMapper {

    public static PetEntity toEntity(Pet pet) {
        PetEntity entity = new PetEntity();
        entity.setId(pet.getId());
        entity.setOwner(UserMapper.toEntity(pet.getOwner()));
        entity.setName(pet.getPetName());
        entity.setAge(pet.getAge());
        entity.setWeight(pet.getWeight());
        entity.setSpicies(pet.getSpices() != null ? pet.getSpices().name() : null);
        entity.setDescription(pet.getDescription());
        entity.setRace(pet.getRace());
        return entity;

    }
    public static Pet toDomain(PetEntity entity) {
        Pet pet = new Pet();
        pet.setId(entity.getId());
        pet.setOwner(UserMapper.toDomain(entity.getOwner()));
        pet.setPetName(entity.getName());
        pet.setAge(entity.getAge());
        pet.setWeight(entity.getWeight());
        pet.setSpices(entity.getSpicies() != null ? Species.valueOf(entity.getSpicies()) : null);
        pet.setDescription(entity.getDescription());
        pet.setRace(entity.getRace());
        return pet;
    }

}
