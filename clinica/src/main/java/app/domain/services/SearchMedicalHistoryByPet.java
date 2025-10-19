package app.domain.services;
import java.util.List;

import app.domain.model.MedicalHistory;
import app.domain.model.Pet;
import app.domain.port.MedicalHistoryPort;
import app.domain.port.PetPort;
public class SearchMedicalHistoryByPet {
    private PetPort petPort;
    private MedicalHistoryPort medicalHistoryPort;

    public List<MedicalHistory> search(Pet pet) throws Exception{
        pet = petPort.finById(pet);
        if(pet==null){
            throw new Exception("No existe esa mascota");
        }
        return medicalHistoryPort.finByPet(pet);
    }

}
