package veterinaria.app.adapters.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import veterinaria.app.adapters.login.entity.LoginEntity;

public interface LoginRepository  extends JpaRepository<LoginEntity, Long> {
  public  LoginEntity findByUsername(String username);

}
