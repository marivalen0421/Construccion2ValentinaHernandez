package veterinaria.app.adapters.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import veterinaria.app.adapters.rest.request.UserRequest;
import veterinaria.app.domain.model.Login;
import veterinaria.app.domain.model.enums.Role;
import veterinaria.app.domain.service.AdministrationService;
import veterinaria.app.domain.service.LoginService;
import veterinaria.app.exceptions.BusinessExcception;

@RestController
@RequestMapping("/api")
public class AdminController {
    @Autowired
    private AdministrationService administrationService;
    @Autowired
    private LoginService loginService;

    @PostMapping("/createPerson")
    public ResponseEntity<String> createPerson(@RequestBody UserRequest request){
        try {
            Login login  = loginService.login(request.getUserNameAdmin(), request.getPasswordAdmin());
            if(login.getPersonId().getRole().equals(Role.ADMIN)){
                administrationService.createPerson(request.getDocument(),request.getName(), request.getAge(), request.getUserName(), request.getPassword(), Role.valueOf(request.getRole().toUpperCase()));
                return new ResponseEntity<>("Person created",HttpStatus.OK);

            }
            return new ResponseEntity<>("you are not authorized to create a person",HttpStatus.UNAUTHORIZED);
        }catch (BusinessExcception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
