package app.application.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.ClinicalOrder;
import app.domain.model.MedicalHistory;
import app.domain.model.Pet;
import app.domain.model.User;
import app.domain.model.emuns.Role;
import app.domain.services.CreateClinicalOrder;
import app.domain.services.CreateMedicalHistory;
import app.domain.services.CreatePet;
import app.domain.services.CreateUser;
import app.domain.services.SearchClinicalOrderByPet;

@Service
public class VeterinarianUseCase {
    @Autowired
    private CreateUser createUser;
    @Autowired
    private CreatePet createPet;
    @Autowired
    private CreateClinicalOrder createClinicalOrder;
    private SearchClinicalOrderByPet searchClinicalOrderByPet;
    private CreateMedicalHistory createMedicalHistory;

    public void CreateOwner(User user) throws Exception{
        user.setRole(Role.OWNER);
        createUser.create(user);
    }
    public void CreatePet(Pet pet) throws Exception{
       createPet.create(pet); 
    }
    public void createOrder(ClinicalOrder order) throws Exception{
        createClinicalOrder.create(order);
    }
    public List<ClinicalOrder> searchOrders(Pet pet)throws Exception{
        return searchClinicalOrderByPet.search(pet);
    }
    public void createMedicalHistory(MedicalHistory medicalHistory) throws Exception{
        createMedicalHistory.create(medicalHistory);
    } 
}
