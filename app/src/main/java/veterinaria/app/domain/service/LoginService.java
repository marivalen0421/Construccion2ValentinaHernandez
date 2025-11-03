package veterinaria.app.domain.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veterinaria.app.adapters.login.LoginAdapter;
import veterinaria.app.domain.model.Login;

@Setter
@Getter
@NoArgsConstructor
@Service
public class LoginService {
    @Autowired
    private LoginAdapter loginAdapter;

    public Login login(String userName, String password) throws Exception {
        Login login = loginAdapter.findByUsername(userName);
        verifyUser(password, login);

        return login;
    }
    private void verifyUser(String password, Login login) throws Exception {
        if (login == null){
            throw new Exception("Invalid username or password\\nThe user does not exist, try again");
        }
        if(!password.equals(login.getPassword())){
            throw new Exception("Invalid password");
        }
    }
    public void verifyVeterinary(String userName, String password) throws Exception {
        Login login = loginAdapter.findByUsername(userName);
        if (login == null){
            throw new Exception("Invalid username or password");
        }
    }

}
