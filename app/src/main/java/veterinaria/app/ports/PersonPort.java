package veterinaria.app.ports;

import veterinaria.app.domain.model.Person;

public interface PersonPort {
  public boolean existPerson(long document);
  public Person save(Person person);
  public Person findByDocument(Long document);
}