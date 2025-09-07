package app.domain.port;

import app.domain.model.Pet;

public interface PetPort {

    public void save(Pet pet)throws Exception;

    public Pet finById(Pet pet) throws Exception;
}