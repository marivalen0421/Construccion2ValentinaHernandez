package veterinaria.app.adapters.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import veterinaria.app.adapters.rest.request.LoginRequest;
import veterinaria.app.domain.model.Login;
import veterinaria.app.domain.service.AdministrationService;
import veterinaria.app.domain.service.LoginService;
import veterinaria.app.exceptions.BusinessExcception;
import veterinaria.app.exceptions.NotFoundException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private AdministrationService administrationService;
    @Autowired
    private LoginService loginService;

    @GetMapping("/users")
    public ResponseEntity<List<Login>> getAll(){
        try {
            List<Login> users = administrationService.getUsers();
            return new ResponseEntity<>(users, HttpStatus.OK);
        }catch (NotFoundException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }catch (BusinessExcception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request){
        try {
            loginService.login(request.getUserName(), request.getPassword());
            return new ResponseEntity<>("Login Successful", HttpStatus.OK);
        }catch (NotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }catch (BusinessExcception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
