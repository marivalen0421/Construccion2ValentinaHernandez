package veterinaria.app.adapters.historyClinical;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veterinaria.app.adapters.historyClinical.entity.HistoryClinicalEntity;
import veterinaria.app.adapters.historyClinical.repository.ClinicalHistoryRepository;
import veterinaria.app.adapters.person.entity.PersonEntity;
import veterinaria.app.adapters.person.repository.PersonRepository;
import veterinaria.app.adapters.pet.entity.PetEntity;
import veterinaria.app.adapters.pet.repository.PetRepository;
import veterinaria.app.domain.model.ClinicalHistory;
import veterinaria.app.domain.model.Person;
import veterinaria.app.domain.model.Pet;
@Getter
@Setter
@NoArgsConstructor
@Service

public class HistoryClinicalAdapter {
    @Autowired
    ClinicalHistoryRepository cHRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    PetRepository petRepository;

    public ClinicalHistory findByDate(Long miliseconds) {
        HistoryClinicalEntity historyClinicalEntity = cHRepository.findByDate(miliseconds);
        if(historyClinicalEntity == null) return null;
        return clinicalHistoryAdapter(historyClinicalEntity);

    }

    public ClinicalHistory save(ClinicalHistory clinicalHistory) {


        PersonEntity vetPerson = personRepository.findByDocument(clinicalHistory.getVeterinarianDocument().getDocument());
        if (vetPerson == null) {
            throw new RuntimeException("Veterinarian document not found");
        }
        PersonEntity ownerEntity = personRepository.findByDocument(clinicalHistory.getPetId().getOwnerDocument().getDocument());
        if (ownerEntity == null) {
            throw new RuntimeException("Pet owner not found");
        }


        PetEntity petEntity = petRepository.findByPetId(clinicalHistory.getPetId().getPetId());
        if (petEntity == null) {
            throw new RuntimeException("Pet not found");
        }

        HistoryClinicalEntity historyEntity = new HistoryClinicalEntity();
        historyEntity.setDate(clinicalHistory.getDate());
        historyEntity.setAllergies(clinicalHistory.getAllergies());
        historyEntity.setDose(clinicalHistory.getDose());
        historyEntity.setDiagnosis(clinicalHistory.getDiagnosis());
        historyEntity.setMedications(clinicalHistory.getMedications());
        historyEntity.setProcedures(clinicalHistory.getProcedures());
        historyEntity.setSymptoms(clinicalHistory.getSymptoms());
        historyEntity.setVaccinationHistoryId(clinicalHistory.getVaccinationHistoryId());
        historyEntity.setVeterinarianDocument(vetPerson);
        historyEntity.setPetId(petEntity);
        historyEntity.setReason(clinicalHistory.getReason());
        historyEntity.setOrderId(clinicalHistory.getOrderId());
        historyEntity.setProcedureNotes(clinicalHistory.getProceduresNotes());

        return clinicalHistoryAdapter(cHRepository.save(historyEntity));
    }


    public ClinicalHistory clinicalHistoryAdapter(HistoryClinicalEntity hCEntity) {

        Person person = new Person();
        person.setAge(hCEntity.getPetId().getDocumentOwner().getAge());
        person.setDocument(hCEntity.getPetId().getDocumentOwner().getDocument());
        person.setName(hCEntity.getPetId().getDocumentOwner().getName());
        person.setRole(hCEntity.getPetId().getDocumentOwner().getRole());

        Person vetPerson = new Person();
        vetPerson.setAge(hCEntity.getVeterinarianDocument().getAge());
        vetPerson.setDocument(hCEntity.getVeterinarianDocument().getDocument());
        vetPerson.setName(hCEntity.getVeterinarianDocument().getName());
        vetPerson.setRole(hCEntity.getVeterinarianDocument().getRole());

        Pet pet = new Pet();
        pet.setAge(hCEntity.getPetId().getAge());
        pet.setName(hCEntity.getPetId().getName());
        pet.setSize(hCEntity.getPetId().getSize());
        pet.setWeight(hCEntity.getPetId().getWeight());
        pet.setSpecies(hCEntity.getPetId().getSpecies());
        pet.setBreed(hCEntity.getPetId().getBreed());
        pet.setPetId(hCEntity.getPetId().getPetId());
        pet.setOwnerDocument(person);

        // Historia clínica
        ClinicalHistory cliHistory = new ClinicalHistory();
        cliHistory.setId(hCEntity.getId());
        cliHistory.setDate(hCEntity.getDate());
        cliHistory.setAllergies(hCEntity.getAllergies());
        cliHistory.setDose(hCEntity.getDose());
        cliHistory.setDiagnosis(hCEntity.getDiagnosis());
        cliHistory.setMedications(hCEntity.getMedications());
        cliHistory.setProcedures(hCEntity.getProcedures());
        cliHistory.setSymptoms(hCEntity.getSymptoms());
        cliHistory.setVaccinationHistoryId(hCEntity.getVaccinationHistoryId());
        cliHistory.setVeterinarianDocument(vetPerson);
        cliHistory.setPetId(pet);
        cliHistory.setReason(hCEntity.getReason()); // <-- te faltaba
        cliHistory.setOrderId(hCEntity.getOrderId()); // <-- también
        cliHistory.setProceduresNotes(hCEntity.getProcedureNotes()); // <-- y este

        return cliHistory;
    }

}
