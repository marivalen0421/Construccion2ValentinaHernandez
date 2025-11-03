package veterinaria.app.adapters.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import veterinaria.app.adapters.rest.request.InvoiceRequest;
import veterinaria.app.domain.model.Login;
import veterinaria.app.domain.model.Pet;
import veterinaria.app.domain.model.enums.Role;
import veterinaria.app.domain.service.InvoiceService;
import veterinaria.app.domain.service.LoginService;
import veterinaria.app.domain.service.PetService;
import veterinaria.app.exceptions.BusinessExcception;

@RestController
@RequestMapping("/api")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private PetService petService;
    @Autowired
    private LoginService loginService;

    @PostMapping("/invoice")
    public ResponseEntity<String> invoice(@RequestBody InvoiceRequest request) {
        try {
            verifySeller(request.getUserNameSeller(), request.getPasswordSeller());
            Pet pet = petService.searchPet(request.getPetId());

            Long milisecondsDate = System.currentTimeMillis();
            invoiceService.saveInvoice(milisecondsDate, request.getQuantity(), request.getValue(), request.getProduct(), pet);
            return  new ResponseEntity<>("invoce success.", HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void verifySeller(String userNameSeller, String passwordSeller) throws BusinessExcception {
        try {
            if (userNameSeller != null && passwordSeller != null) {
                Login login = loginService.login(userNameSeller, passwordSeller);
                if (!login.getPersonId().getRole().equals(Role.SELLER))
                    throw new BusinessExcception("Seller not logged in.");
            }else{
                    throw  new BusinessExcception("Seller not logged in.");
                }
        }catch (Exception e) {
                throw new BusinessExcception("Seller not logged in.");
        }
    }
}
