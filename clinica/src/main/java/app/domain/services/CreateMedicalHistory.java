package app.domain.services;

import app.domain.model.ClinicalOrder;
import app.domain.model.MedicalHistory;
import app.domain.model.Pet;
import app.domain.model.User;
import app.domain.model.emuns.Role;
import app.domain.port.ClinicalOrderPort;
import app.domain.port.MedicalHistoryPort;
import app.domain.port.PetPort;
import app.domain.port.UserPort;

public class CreateMedicalHistory {
    private UserPort userPort;
    private PetPort petPort;
    private ClinicalOrderPort clinicalOrderPort;
    private MedicalHistoryPort medicalHistoryPort;

    public void create(MedicalHistory medicalHistory) throws Exception{
        Pet pet = petPort.finById(medicalHistory.getPet());
        if(pet == null){
            throw new Exception("La historia clinica debe tener una mascota ya creada");
        }
        User veterinarian = userPort.findByDocument(medicalHistory.getVeterinarian());
        if(veterinarian==null || !veterinarian.getRole().equals(Role.VETERINARIAN)){
            throw new Exception("La historia clinica debe ser registrada por un veterinario");
        }
        ClinicalOrder clinicalOrder = clinicalOrderPort.findByID(medicalHistory.getClinicalOrder());
        if(clinicalOrder==null){
            throw new Exception("La historia clinica debe tener una orden valida asociada");
        }
        medicalHistory.setPet(pet);
        medicalHistory.setVeterinarian(veterinarian);
        medicalHistory.setClinicalOrder(clinicalOrder);
        medicalHistoryPort.save(medicalHistory);
    }
}
