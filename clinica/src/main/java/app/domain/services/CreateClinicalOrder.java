package app.domain.services;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.ClinicalOrder;
import app.domain.model.Pet;
import app.domain.model.User;
import app.domain.model.emuns.Role;
import app.domain.port.ClinicalOrderPort;
import app.domain.port.PetPort;
import app.domain.port.UserPort;


@Service
public class CreateClinicalOrder {
    @Autowired
    private UserPort userPort;
    @Autowired
    private PetPort petPort;
    @Autowired
    private ClinicalOrderPort clinicalOrderPort;

    public void create(ClinicalOrder clinicalOrder) throws Exception{
        User veterinarian = userPort.findByDocument(clinicalOrder.getVeterinarian());
        if(veterinarian==null || !veterinarian.getRole().equals(Role.VETERINARIAN)){
            throw new Exception("Las ordenes solo las puede crear un veterinario");
        }
        Pet pet = petPort.finById(clinicalOrder.getPet());
        if(pet==null){
            throw new Exception("Las ordenes se deben aplicar a mascotas registradas");
        }
        clinicalOrder.setDate(new Date(System.currentTimeMillis()));
        clinicalOrder.setPet(pet);
        clinicalOrder.setOwner(pet.getOwner());
        clinicalOrder.setVeterinarian(veterinarian);

        clinicalOrderPort.save(clinicalOrder);
    }
}
