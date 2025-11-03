package veterinaria.app.adapters.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import veterinaria.app.adapters.rest.request.ClinicalOrderRequest;
import veterinaria.app.domain.model.*;
import veterinaria.app.domain.model.enums.Role;
import veterinaria.app.domain.service.*;
import veterinaria.app.exceptions.BusinessExcception;
import veterinaria.app.exceptions.NotFoundException;

@RestController
@RequestMapping("/api")
public class ClinicalOrderController {
    @Autowired
    private ClinicalOrderService clinicalOrderService;
    @Autowired
    private PetService petService;
    @Autowired
    private PersonService personService;
    @Autowired
    private ClinicalHistoryService clinicalHistoryService;
    @Autowired
    private LoginService loginService;

    @GetMapping("/order/{orderId}")
    public ResponseEntity<ClinicalOrder> getClinicalOrder(@PathVariable Long orderId) {
        try {
            ClinicalOrder order = clinicalOrderService.searchOrder(orderId);
            return new ResponseEntity<>(order, HttpStatus.OK);
        }catch(NotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/order")
    public ResponseEntity<String> createClinicalOrder(@RequestBody ClinicalOrderRequest request ) {
        try {
            verifyVeterinarian(request.getUserNameVet(),request.getPasswordVet());
            Pet pet = petService.searchPet(request.getPetId());
            Person owner = personService.existsPerson(request.getOwnerDocument(), "Owner not found");
            Person vet = personService.existsPerson(request.getVeterinarianDocument(), "veterinary not found");
            ClinicalHistory cliHis = clinicalHistoryService.searchCH(request.getMedicine());

            clinicalOrderService.saveOrder(request.getOrderId(), pet,owner,vet,cliHis,null);
            return new ResponseEntity<>("order create successfully",HttpStatus.OK);

        } catch (BusinessExcception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);

        }catch (NotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
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
