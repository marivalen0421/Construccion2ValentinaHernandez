package veterinaria.app.ports;

import veterinaria.app.domain.model.Login;

import java.util.List;

public interface LoginPort {
    public Login findByUsername(String username);
    public Login save(Login login);
    public List<Login> getAll();
}
