package app.domain.services;

import java.util.List;

import app.domain.model.ClinicalOrder;
import app.domain.model.Pet;
import app.domain.port.ClinicalOrderPort;
import app.domain.port.PetPort;

public class SearchClinicalOrderByPet {

    private PetPort petPort;
    private ClinicalOrderPort clinicalOrderPort;

    public List<ClinicalOrder> search(Pet pet) throws Exception{
        pet = petPort.finById(pet);
        if(pet ==null){
            throw new Exception("Debes consultar ordenes de una mascota ya creada") ;
        }
        return clinicalOrderPort.findByPet(pet);
    }
    
}
