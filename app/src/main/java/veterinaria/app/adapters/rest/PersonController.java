package veterinaria.app.adapters.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import veterinaria.app.adapters.rest.request.PersonRequest;
import veterinaria.app.domain.model.Login;
import veterinaria.app.domain.model.enums.Role;
import veterinaria.app.domain.service.LoginService;
import veterinaria.app.domain.service.PersonService;
import veterinaria.app.exceptions.BusinessExcception;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonService personService;
    @Autowired
    private LoginService loginService;

    @PostMapping("/person")
    public ResponseEntity<String> createPerson(@RequestBody PersonRequest request) {
        try {
            verifyVeterinarian(request.getUserNameVet(), request.getPasswordVet());
            personService.savePetOwner(request.getDocument(), request.getName(), request.getAge(), request.getRole());
            return new ResponseEntity<>("Person created successfully", HttpStatus.CREATED);

        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating person: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    private void verifyVeterinarian(String userNameVet, String passwordVet)throws BusinessExcception {
        try {
            if (userNameVet != null && passwordVet != null) {
                Login login = loginService.login(userNameVet,passwordVet);
                if(!login.getPersonId().getRole().equals(Role.VETERINARIAN))
                    throw new BusinessExcception("Veterinary not logged in");
            }else {
                throw new BusinessExcception("Veterinary not logged in");
            }
        }catch (Exception e){
            throw new BusinessExcception("Veterinary not logged in");
        }
    }
}

