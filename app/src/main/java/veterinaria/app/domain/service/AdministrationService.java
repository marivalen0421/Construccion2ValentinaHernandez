package veterinaria.app.domain.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veterinaria.app.adapters.login.LoginAdapter;
import veterinaria.app.adapters.person.PersonAdapter;
import veterinaria.app.domain.model.Login;
import veterinaria.app.domain.model.Person;
import veterinaria.app.domain.model.enums.Role;
import veterinaria.app.exceptions.BusinessExcception;
import veterinaria.app.ports.LoginPort;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Service
public class AdministrationService {
    @Autowired
    private PersonAdapter personAdapter;
    @Autowired
    private LoginAdapter loginAdapter;
    @Autowired
    private LoginPort loginPort;

    public Login registerPerson(Person newPerson, Login login)throws Exception{
        if(personAdapter.existPerson(newPerson.getDocument())){
            throw new BusinessExcception("Person already exists");

        }
        if(loginAdapter.findByUsername(login.getUserName())!=null){
            throw new BusinessExcception("Username already exists");
        }
        try {
            Person person = personAdapter.save(newPerson);
            login.setPersonId(person);
            return loginAdapter.save(login);
        }catch (Exception e){
            throw  new BusinessExcception("Error while saving person");
        }
    }

    public Login createPerson(Long document, String name, int age,String userName,String password, Role role) throws Exception{
        Person newPerson = new Person();
        newPerson.setDocument(document);
        newPerson.setName(name);
        newPerson.setAge(age);
        newPerson.setRole(role);

        Login newLogin = new Login();
        newLogin.setUserName(userName);
        newLogin.setPassword(password);

        return registerPerson(newPerson,newLogin);
    }

    public List<Login> getUsers() throws Exception{
        List<Login> users = loginPort.getAll();
        if(users.isEmpty()){
            throw new BusinessExcception("Users not found");
        }
        return users;
    }

}
