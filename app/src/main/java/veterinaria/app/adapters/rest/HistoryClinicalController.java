package veterinaria.app.adapters.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import veterinaria.app.adapters.rest.request.HistoryClinicalRequest;
import veterinaria.app.domain.model.ClinicalHistory;
import veterinaria.app.domain.model.Login;
import veterinaria.app.domain.model.Person;
import veterinaria.app.domain.model.Pet;
import veterinaria.app.domain.model.enums.Role;
import veterinaria.app.domain.service.ClinicalHistoryService;
import veterinaria.app.domain.service.LoginService;
import veterinaria.app.domain.service.PersonService;
import veterinaria.app.domain.service.PetService;
import veterinaria.app.exceptions.BusinessExcception;
import veterinaria.app.exceptions.NotFoundException;

@RestController
@RequestMapping("/hcApi")
public class HistoryClinicalController {
    @Autowired
    private ClinicalHistoryService clinicalHistoryService;
    @Autowired
    private PersonService personService;
    @Autowired
    private PetService petService;
    @Autowired
    private LoginService loginService;

    @GetMapping("/clinicalHistory/{ms}")
    public ResponseEntity<ClinicalHistory> getClinicalHistory(@PathVariable  Long ms){
        try{
        ClinicalHistory clinicalHistory = clinicalHistoryService.searchCH(ms);
        return new ResponseEntity<>(clinicalHistory, HttpStatus.OK);
        }catch(NotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/clinicalHistory")
    public ResponseEntity<String> createClinicalHistory(@RequestBody HistoryClinicalRequest request){
        try {
            verifyVeterinarian(request.getUserNameVet(), request.getPasswordVet());
            Pet pet = petService.searchPet(request.getPetId());

            Person veterinary = personService.existsPerson(request.getVeterinarianDocument(), "veterinary not found");

            ClinicalHistory clinicalHistory = clinicalHistoryService.saveHistory(pet,null, veterinary,request.getReason(),request.getSymptoms(),request.getProcedures(),request.getDiagnosis(),request.getMedications(),request.getDose(), request.getOrderId(), request.getVaccinationHistoryId(), request.getAllergies(), request.getNotes());

            return new ResponseEntity<>("History Created", HttpStatus.CREATED);

        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
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
