package veterinaria.app.adapters.login;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veterinaria.app.adapters.login.entity.LoginEntity;
import veterinaria.app.adapters.login.repository.LoginRepository;
import veterinaria.app.adapters.person.entity.PersonEntity;
import veterinaria.app.adapters.person.repository.PersonRepository;
import veterinaria.app.domain.model.Login;
import veterinaria.app.domain.model.Person;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Service
public class LoginAdapter {
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private PersonRepository personRepository;

    public Login findByUsername(String username) {
        LoginEntity loginEntity = loginRepository.findByUsername(username);
        if(loginEntity == null){
            return null;
        }
        return loginAdapter( loginEntity );
    }

    public Login save(Login login) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setAge(login.getPersonId().getAge());
        personEntity.setName(login.getPersonId().getName());
        personEntity.setDocument(login.getPersonId().getDocument());
        personEntity.setRole(login.getPersonId().getRole());

        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setPerson(personEntity);
        loginEntity.setPassword(login.getPassword());
        loginEntity.setUserName(login.getUserName());
        return loginAdapter(loginRepository.save(loginEntity));

    }

    public Login loginAdapter(LoginEntity loginEntity) {
        Person person = new Person();
        person.setAge(loginEntity.getPerson().getAge());
        person.setName(loginEntity.getPerson().getName());
        person.setDocument(loginEntity.getPerson().getDocument());
        person.setRole(loginEntity.getPerson().getRole());

        Login login = new Login();
        login.setLoginId(loginEntity.getLoginId());
        login.setPersonId(person);
        login.setPassword(loginEntity.getPassword());
        login.setUserName(loginEntity.getUserName());
        return login;
    }
    public List<Login> getAll(){
        List<LoginEntity> loginEntities = loginRepository.findAll();
        List<Login> logins = new ArrayList<Login>();

        for (LoginEntity loginEntity : loginEntities) {
            logins.add(loginAdapter(loginEntity));
        }
        return logins;
    }
}
