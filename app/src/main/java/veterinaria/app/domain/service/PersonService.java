package veterinaria.app.domain.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veterinaria.app.adapters.person.PersonAdapter;
import veterinaria.app.domain.model.Person;
import veterinaria.app.domain.model.Pet;
import veterinaria.app.domain.model.enums.Role;
import veterinaria.app.exceptions.BusinessExcception;
import veterinaria.app.exceptions.NotFoundException;

@Getter
@Setter
@NoArgsConstructor
@Service
public class PersonService {
    @Autowired
   private PersonAdapter personAdapter;
    public Person existsPerson(Long id, String msg) throws Exception {
        Person person = personAdapter.findByDocument(id);
        if(person == null) throw new NotFoundException(msg);
        return person;
    }
    public  void notExistsPerson(Long id, String msg) throws Exception {
        Person person = personAdapter.findByDocument(id);
        if(person != null) throw new BusinessExcception(msg);
    }
    public void savePetOwner(long id, String name, int age, Role role) throws Exception {
        notExistsPerson(id,"there is already a person with that document");
        Person newPerson = new Person(id, name, age, role);
        personAdapter.save(newPerson);
        System.out.println("\nthe owner has been saved successfully");

    }

}
