package veterinaria.app.adapters.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import veterinaria.app.adapters.rest.request.PetRequest;
import veterinaria.app.domain.model.Login;
import veterinaria.app.domain.model.Pet;
import veterinaria.app.domain.model.enums.Role;
import veterinaria.app.domain.service.LoginService;
import veterinaria.app.domain.service.PetService;
import veterinaria.app.exceptions.BusinessExcception;

@RestController
@RequestMapping("/api")
public class PetController {

    @Autowired
    private PetService petService;
    @Autowired
    private LoginService loginService;

    @PostMapping("/pets")
    public ResponseEntity<?> createPet(@RequestBody PetRequest request) {
        try {
            verifyVeterinarian(request.getUserNameVet(), request.getPasswordVet());
            Pet pet = petService.savePet(request.getOwnerDocument(), request.getName(), request.getAge(), request.getSpecies(), request.getBreed(), request.getWeight(), request.getSize());

            return new ResponseEntity<>(pet, HttpStatus.CREATED);

        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            return new ResponseEntity<>("Error creating pet: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    private void verifyVeterinarian(String userNameVet, String passwordVet)throws BusinessExcception{
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
