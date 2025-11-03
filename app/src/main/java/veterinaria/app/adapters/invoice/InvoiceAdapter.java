package veterinaria.app.adapters.invoice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veterinaria.app.adapters.clinicalOrder.entity.ClinicalOrderEntity;
import veterinaria.app.adapters.clinicalOrder.repository.ClinicalOrderRepository;
import veterinaria.app.adapters.historyClinical.entity.HistoryClinicalEntity;
import veterinaria.app.adapters.historyClinical.repository.ClinicalHistoryRepository;
import veterinaria.app.adapters.invoice.entity.InvoiceEntity;
import veterinaria.app.adapters.invoice.repository.InvoiceRepository;
import veterinaria.app.adapters.person.entity.PersonEntity;
import veterinaria.app.adapters.pet.entity.PetEntity;
import veterinaria.app.domain.model.*;


@Setter
@NoArgsConstructor
@Getter
@Service
public class InvoiceAdapter {
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private ClinicalOrderRepository clinicalOrderRepository;
    @Autowired
    private ClinicalHistoryRepository clinicalHistoryRepository;

    public Invoice save(Invoice invoice){
        PersonEntity ownerEntity = new PersonEntity();
        ownerEntity.setAge(invoice.getOwnerDocument().getAge());
        ownerEntity.setDocument(invoice.getOwnerDocument().getDocument());
        ownerEntity.setName(invoice.getOwnerDocument().getName());
        ownerEntity.setRole(invoice.getOwnerDocument().getRole());

        PetEntity petEntity = new PetEntity();
        petEntity.setAge(invoice.getPetId().getAge());
        petEntity.setName(invoice.getPetId().getName());
        petEntity.setSize(invoice.getPetId().getSize());
        petEntity.setBreed(invoice.getPetId().getBreed());
        petEntity.setPetId(invoice.getPetId().getPetId());
        petEntity.setSpecies(invoice.getPetId().getSpecies());
        petEntity.setWeight(invoice.getPetId().getWeight());
        petEntity.setDocumentOwner(ownerEntity);

        PersonEntity vetEntity = new PersonEntity();
        HistoryClinicalEntity historyEntity = new HistoryClinicalEntity();
        ClinicalOrderEntity orderEntity = new ClinicalOrderEntity();

        if(invoice.getOrderId() != null){
            vetEntity.setAge(invoice.getOrderId().getVeterinarianDocument().getAge());
            vetEntity.setName(invoice.getOrderId().getVeterinarianDocument().getName());
            vetEntity.setDocument(invoice.getOrderId().getVeterinarianDocument().getDocument());
            vetEntity.setRole(invoice.getOrderId().getVeterinarianDocument().getRole());

            historyEntity.setVaccinationHistoryId(invoice.getOrderId().getMedicine().getVaccinationHistoryId());
            historyEntity.setDose(invoice.getOrderId().getMedicine().getDose());
            historyEntity.setProcedures(invoice.getOrderId().getMedicine().getProcedures());
            historyEntity.setMedications(invoice.getOrderId().getMedicine().getMedications());
            historyEntity.setDiagnosis(invoice.getOrderId().getMedicine().getDiagnosis());
            historyEntity.setSymptoms(invoice.getOrderId().getMedicine().getSymptoms());
            historyEntity.setReason(invoice.getOrderId().getMedicine().getReason());
            historyEntity.setProcedureNotes(invoice.getOrderId().getMedicine().getProceduresNotes());
            historyEntity.setAllergies(invoice.getOrderId().getMedicine().getAllergies());
            historyEntity.setPetId(petEntity);
            historyEntity.setDate(invoice.getOrderId().getMedicine().getDate());

            orderEntity.setDateCreate(invoice.getOrderId().getDateCreate());
            orderEntity.setOwnerDocument(ownerEntity);
            orderEntity.setVeterinarianDocument(vetEntity);
            orderEntity.setMedicine(historyEntity);
            orderEntity.setOrderId(invoice.getOrderId().getOrderId());
            orderEntity.setPetId(petEntity);
        }
        InvoiceEntity invoiceEntity = new InvoiceEntity();
        invoiceEntity.setQuantity(invoice.getQuantity());
        invoiceEntity.setDate(invoice.getDate());
        invoiceEntity.setClinicalOrder((invoice.getOrderId())!=null ? orderEntity:null);
        invoiceEntity.setId(invoice.getId());
        invoiceEntity.setProduct(invoice.getProduct());
        invoiceEntity.setValue(invoice.getValue());
        invoiceEntity.setOwnerDocument(ownerEntity);
        invoiceEntity.setPetId(petEntity);

        return  invoiceAdapter(invoiceRepository.save(invoiceEntity));
    }
    public Invoice save(Invoice invoice, ClinicalOrder order){
        PersonEntity ownerEntity = new PersonEntity();
        ownerEntity.setAge(invoice.getOwnerDocument().getAge());
        ownerEntity.setDocument(invoice.getOwnerDocument().getDocument());
        ownerEntity.setName(invoice.getOwnerDocument().getName());
        ownerEntity.setRole(invoice.getOwnerDocument().getRole());

        PersonEntity vetEntity = new PersonEntity();
        vetEntity.setRole(invoice.getOrderId().getVeterinarianDocument().getRole());
        vetEntity.setName(invoice.getOrderId().getVeterinarianDocument().getName());
        vetEntity.setAge(invoice.getOrderId().getVeterinarianDocument().getAge());
        vetEntity.setDocument(invoice.getOrderId().getVeterinarianDocument().getDocument());

        PetEntity petEntity = new PetEntity();
        petEntity.setAge(invoice.getPetId().getAge());
        petEntity.setName(invoice.getPetId().getName());
        petEntity.setSize(invoice.getPetId().getSize());
        petEntity.setBreed(invoice.getPetId().getBreed());
        petEntity.setPetId(invoice.getPetId().getPetId());
        petEntity.setSpecies(invoice.getPetId().getSpecies());
        petEntity.setWeight(invoice.getPetId().getWeight());
        petEntity.setDocumentOwner(ownerEntity);

        HistoryClinicalEntity historyEntity = new HistoryClinicalEntity();
        historyEntity.setVaccinationHistoryId(invoice.getOrderId().getMedicine().getVaccinationHistoryId());
        historyEntity.setDose(invoice.getOrderId().getMedicine().getDose());
        historyEntity.setProcedures(invoice.getOrderId().getMedicine().getProcedures());
        historyEntity.setMedications(invoice.getOrderId().getMedicine().getMedications());
        historyEntity.setDiagnosis(invoice.getOrderId().getMedicine().getDiagnosis());
        historyEntity.setSymptoms(invoice.getOrderId().getMedicine().getSymptoms());
        historyEntity.setReason(invoice.getOrderId().getMedicine().getReason());
        historyEntity.setProcedureNotes(invoice.getOrderId().getMedicine().getProceduresNotes());
        historyEntity.setAllergies(invoice.getOrderId().getMedicine().getAllergies());
        historyEntity.setPetId(petEntity);
        historyEntity.setDate(invoice.getOrderId().getMedicine().getDate());

        ClinicalOrderEntity orderEntity = new ClinicalOrderEntity();
        orderEntity.setDateCreate(invoice.getOrderId().getDateCreate());
        orderEntity.setOwnerDocument(ownerEntity);
        orderEntity.setVeterinarianDocument(vetEntity);
        orderEntity.setMedicine(historyEntity);
        orderEntity.setOrderId(invoice.getOrderId().getOrderId());
        orderEntity.setPetId(petEntity);

        InvoiceEntity invoiceEntity = new InvoiceEntity();
        invoiceEntity.setQuantity(invoice.getQuantity());
        invoiceEntity.setDate(invoice.getDate());
        invoiceEntity.setClinicalOrder((invoice.getOrderId())!=null ? orderEntity:null);
        invoiceEntity.setId(invoice.getId());
        invoiceEntity.setProduct(invoice.getProduct());
        invoiceEntity.setValue(invoice.getValue());
        invoiceEntity.setOwnerDocument(ownerEntity);
        invoiceEntity.setPetId(petEntity);

        return invoiceAdapter(invoiceRepository.save(invoiceEntity));

    }

    public  Invoice invoiceAdapter(InvoiceEntity invoiceEntity){
        Person owner = new Person();
        owner.setAge(invoiceEntity.getOwnerDocument().getAge());
        owner.setDocument(invoiceEntity.getOwnerDocument().getDocument());
        owner.setName(invoiceEntity.getOwnerDocument().getName());
        owner.setRole(invoiceEntity.getOwnerDocument().getRole());

        Pet pet = new Pet();
        pet.setAge(invoiceEntity.getPetId().getAge());
        pet.setName(invoiceEntity.getPetId().getName());
        pet.setSize(invoiceEntity.getPetId().getSize());
        pet.setBreed(invoiceEntity.getPetId().getBreed());
        pet.setPetId(invoiceEntity.getPetId().getPetId());
        pet.setSpecies(invoiceEntity.getPetId().getSpecies());
        pet.setWeight(invoiceEntity.getPetId().getWeight());
        pet.setOwnerDocument(owner);

        ClinicalHistory clinicalHistory = new ClinicalHistory();
        Person vet =  new Person();
        ClinicalOrder order = new ClinicalOrder();

        if(invoiceEntity.getClinicalOrder() !=null){
            clinicalHistory.setVaccinationHistoryId(invoiceEntity.getClinicalOrder().getMedicine().getVaccinationHistoryId());
            clinicalHistory.setDose(invoiceEntity.getClinicalOrder().getMedicine().getDose());
            clinicalHistory.setProcedures(invoiceEntity.getClinicalOrder().getMedicine().getProcedures());
            clinicalHistory.setMedications(invoiceEntity.getClinicalOrder().getMedicine().getMedications());
            clinicalHistory.setDiagnosis(invoiceEntity.getClinicalOrder().getMedicine().getDiagnosis());
            clinicalHistory.setSymptoms(invoiceEntity.getClinicalOrder().getMedicine().getSymptoms());
            clinicalHistory.setReason(invoiceEntity.getClinicalOrder().getMedicine().getReason());
            clinicalHistory.setProceduresNotes(invoiceEntity.getClinicalOrder().getMedicine().getProcedureNotes());
            clinicalHistory.setAllergies(invoiceEntity.getClinicalOrder().getMedicine().getAllergies());
            clinicalHistory.setPetId(pet);
            clinicalHistory.setDate(invoiceEntity.getClinicalOrder().getMedicine().getDate());

            order.setDateCreate(invoiceEntity.getClinicalOrder().getDateCreate());
            order.setOwnerDocument(owner);
            order.setVeterinarianDocument(vet);
            order.setMedicine(clinicalHistory);
            order.setOrderId(invoiceEntity.getClinicalOrder().getOrderId());
            order.setPetId(pet);

            vet.setAge(invoiceEntity.getClinicalOrder().getVeterinarianDocument().getAge());
            vet.setName(invoiceEntity.getClinicalOrder().getVeterinarianDocument().getName());
            vet.setDocument(invoiceEntity.getClinicalOrder().getVeterinarianDocument().getDocument());
            vet.setRole(invoiceEntity.getClinicalOrder().getVeterinarianDocument().getRole());
        }
        Invoice invoice = new Invoice();
        invoice.setQuantity(invoiceEntity.getQuantity());
        invoice.setDate(invoiceEntity.getDate());
        invoice.setId(invoiceEntity.getId());
        invoice.setProduct(invoiceEntity.getProduct());
        invoice.setValue(invoiceEntity.getValue());
        invoice.setOwnerDocument(owner);
        invoice.setPetId(pet);
        invoice.setOrderId((invoiceEntity.getClinicalOrder())!=null ? order:null);

        return invoice;
    }
}
