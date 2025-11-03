package veterinaria.app.adapters.person;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veterinaria.app.adapters.person.entity.PersonEntity;
import veterinaria.app.adapters.person.repository.PersonRepository;
import veterinaria.app.domain.model.Person;

@Getter
@Setter
@NoArgsConstructor
@Service
public class PersonAdapter {
    @Autowired
    private PersonRepository personRepository;
    public boolean existPerson(Long id) {
        return personRepository.existsById(id);
    }
    public Person personAdapter(PersonEntity personEntity) {
        Person person = new Person();
        person.setDocument(personEntity.getDocument());
        person.setName(personEntity.getName());
        person.setAge(personEntity.getAge());
        person.setRole(personEntity.getRole());
        return person;
    }
    public Person findByDocument(Long id) {
        PersonEntity personEntity = personRepository.findByDocument(id);
        if(personEntity == null) return null;
        return personAdapter(personEntity);

    }
    public Person save(Person person) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setDocument(person.getDocument());
        personEntity.setName(person.getName());
        personEntity.setAge(person.getAge());
        personEntity.setRole(person.getRole());
        personRepository.save(personEntity);
        person.setDocument(personEntity.getDocument());
        return person;
    }
}
