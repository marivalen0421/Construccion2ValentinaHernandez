package veterinaria.app.adapters.pet.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import veterinaria.app.adapters.pet.entity.PetEntity;
import veterinaria.app.domain.model.Pet;


public interface PetRepository extends JpaRepository<PetEntity, Long> {
    //public void save(Pet pet);
    public PetEntity findByPetId(Long petId);
}
