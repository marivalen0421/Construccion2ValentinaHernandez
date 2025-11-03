package veterinaria.app.ports;

import veterinaria.app.domain.model.Pet;

public interface PetPort {
  public void save(Pet pet);
  public Pet findByPetId(Long petId);
}
