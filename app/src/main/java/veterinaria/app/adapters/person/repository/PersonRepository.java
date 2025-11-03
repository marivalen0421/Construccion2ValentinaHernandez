package veterinaria.app.adapters.person.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import veterinaria.app.adapters.person.entity.PersonEntity;


public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    public boolean existsById(Long id);
    public PersonEntity findByDocument(Long id);
}
