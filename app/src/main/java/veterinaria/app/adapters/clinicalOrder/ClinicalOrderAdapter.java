package veterinaria.app.adapters.clinicalOrder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veterinaria.app.adapters.clinicalOrder.entity.ClinicalOrderEntity;
import veterinaria.app.adapters.clinicalOrder.repository.ClinicalOrderRepository;
import veterinaria.app.adapters.historyClinical.entity.HistoryClinicalEntity;
import veterinaria.app.adapters.historyClinical.repository.ClinicalHistoryRepository;
import veterinaria.app.adapters.person.entity.PersonEntity;
import veterinaria.app.adapters.person.repository.PersonRepository;
import veterinaria.app.adapters.pet.entity.PetEntity;
import veterinaria.app.adapters.pet.repository.PetRepository;
import veterinaria.app.domain.model.ClinicalHistory;
import veterinaria.app.domain.model.ClinicalOrder;
import veterinaria.app.domain.model.Person;
import veterinaria.app.domain.model.Pet;
import veterinaria.app.ports.OrderPort;



@Getter
@Setter
@NoArgsConstructor
@Service
public class ClinicalOrderAdapter implements OrderPort {
    @Autowired
    private ClinicalOrderRepository orderRepository;
    @Autowired
    ClinicalHistoryRepository cHRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    PetRepository petRepository;


    @Override
    public ClinicalOrder save(ClinicalOrder CliOrder){
        PersonEntity ownerEntity = personRepository.findByDocument(CliOrder.getOwnerDocument().getDocument());
        if(ownerEntity == null){
            throw new RuntimeException("Owner document not found");
        }
        /*PersonEntity ownerEntity = new PersonEntity();
        ownerEntity.setAge(CliOrder.getOwnerDocument().getAge());
        ownerEntity.setName(CliOrder.getOwnerDocument().getName());
        ownerEntity.setRole(CliOrder.getOwnerDocument().getRole());
        ownerEntity.setDocument(CliOrder.getOwnerDocument().getDocument());
*/
        /*PersonEntity vetEntity = new PersonEntity();
        vetEntity.setAge(CliOrder.getVeterinarianDocument().getAge());
        vetEntity.setName(CliOrder.getVeterinarianDocument().getName());
        vetEntity.setRole(CliOrder.getVeterinarianDocument().getRole());
        vetEntity.setDocument(CliOrder.getVeterinarianDocument().getDocument());
*/
        PersonEntity vetEntity = personRepository.findByDocument(CliOrder.getVeterinarianDocument().getDocument());
        if(vetEntity == null){
            throw new RuntimeException("Veterinarian document not found");
        }

        /*PetEntity petEntity = new PetEntity();
        petEntity.setAge(CliOrder.getPetId().getAge());
        petEntity.setName(CliOrder.getPetId().getName());
        petEntity.setDocumentOwner(ownerEntity);
        petEntity.setPetId(CliOrder.getPetId().getPetId());
        petEntity.setBreed(CliOrder.getPetId().getBreed());
        petEntity.setSize(CliOrder.getPetId().getSize());
        petEntity.setWeight(CliOrder.getPetId().getWeight());
        petEntity.setSpecies(CliOrder.getPetId().getSpecies());
*/
        PetEntity petEntity = petRepository.findByPetId(CliOrder.getPetId().getPetId());
        if(petEntity == null){
            throw new RuntimeException("Pet document not found");
        }

        /*HistoryClinicalEntity  historyClinicalEntity = new HistoryClinicalEntity();
        historyClinicalEntity.setDate(CliOrder.getMedicine().getDate());
        historyClinicalEntity.setVeterinarianDocument(vetEntity);
        historyClinicalEntity.setPetId(petEntity);
        historyClinicalEntity.setVaccinationHistoryId(CliOrder.getMedicine().getVaccinationHistoryId());
        historyClinicalEntity.setReason(CliOrder.getMedicine().getReason());
        historyClinicalEntity.setSymptoms(CliOrder.getMedicine().getSymptoms());
        historyClinicalEntity.setDose(CliOrder.getMedicine().getDose());
        historyClinicalEntity.setProcedureNotes(CliOrder.getMedicine().getProceduresNotes());
        historyClinicalEntity.setProcedures(CliOrder.getMedicine().getProcedures());
        historyClinicalEntity.setMedications(CliOrder.getMedicine().getMedications());
        historyClinicalEntity.setDiagnosis(CliOrder.getMedicine().getDiagnosis());
        historyClinicalEntity.setAllergies(CliOrder.getMedicine().getAllergies());
*/
        HistoryClinicalEntity historyClinicalEntity = cHRepository.findByDate(CliOrder.getMedicine().getDate());
        if(historyClinicalEntity == null){
            throw new RuntimeException("Date create document not found");
        }

        ClinicalOrderEntity orderEntity = new ClinicalOrderEntity();
        orderEntity.setDateCreate(CliOrder.getDateCreate());
        orderEntity.setVeterinarianDocument(vetEntity);
        orderEntity.setPetId(petEntity);
        orderEntity.setOwnerDocument(ownerEntity);
        orderEntity.setMedicine(historyClinicalEntity);

        return clinicalOrderAdapter(orderRepository.save(orderEntity));
    }

    public ClinicalOrder clinicalOrderAdapter (ClinicalOrderEntity order){
        Person ownerPerson = new Person();
        ownerPerson.setAge(order.getOwnerDocument().getAge());
        ownerPerson.setName(order.getOwnerDocument().getName());
        ownerPerson.setRole(order.getOwnerDocument().getRole());
        ownerPerson.setDocument(order.getOwnerDocument().getDocument());

        Person vetPerson = new Person();
        vetPerson.setAge(order.getVeterinarianDocument().getAge());
        vetPerson.setName(order.getVeterinarianDocument().getName());
        vetPerson.setRole(order.getVeterinarianDocument().getRole());
        vetPerson.setDocument(order.getVeterinarianDocument().getDocument());

        Pet pet = new Pet();
        pet.setAge(order.getPetId().getAge());
        pet.setName(order.getPetId().getName());
        pet.setOwnerDocument(ownerPerson);
        pet.setBreed(order.getPetId().getBreed());
        pet.setPetId(order.getPetId().getPetId());
        pet.setSize(order.getPetId().getSize());
        pet.setWeight(order.getPetId().getWeight());
        pet.setSpecies(order.getPetId().getSpecies());

        ClinicalHistory clinicalHistory= new ClinicalHistory();
        clinicalHistory.setDate(order.getMedicine().getDate());
        clinicalHistory.setVeterinarianDocument(vetPerson);
        clinicalHistory.setPetId(pet);
        clinicalHistory.setVaccinationHistoryId(order.getMedicine().getVaccinationHistoryId());
        clinicalHistory.setReason(order.getMedicine().getReason());
        clinicalHistory.setSymptoms(order.getMedicine().getSymptoms());
        clinicalHistory.setDose(order.getMedicine().getDose());
        clinicalHistory.setProceduresNotes(order.getMedicine().getProcedureNotes());
        clinicalHistory.setProcedures(order.getMedicine().getProcedures());
        clinicalHistory.setMedications(order.getMedicine().getMedications());
        clinicalHistory.setDiagnosis(order.getMedicine().getDiagnosis());
        clinicalHistory.setAllergies(order.getMedicine().getAllergies());
        clinicalHistory.setOrderId(order.getMedicine().getOrderId());

        ClinicalOrder clinicalOrder = new ClinicalOrder();
        clinicalOrder.setDateCreate(order.getDateCreate());
        clinicalOrder.setVeterinarianDocument(vetPerson);
        clinicalOrder.setPetId(pet);
        clinicalOrder.setOwnerDocument(ownerPerson);
        clinicalOrder.setMedicine(clinicalHistory);
        clinicalOrder.setOrderId(order.getOrderId());
        return clinicalOrder;
    }
    @Override
    public ClinicalOrder findByOrderId(Long orderId){
        ClinicalOrderEntity orderEntity = orderRepository.findByOrderId(orderId);
        if(orderEntity == null)return null;
        return clinicalOrderAdapter(orderEntity);

    }

}
