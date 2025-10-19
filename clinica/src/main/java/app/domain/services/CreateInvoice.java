package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.ClinicalOrder;
import app.domain.model.Invoice;
import app.domain.model.Pet;
import app.domain.port.ClinicalOrderPort;
import app.domain.port.InvoicePort;
import app.domain.port.PetPort;

@Service
public class CreateInvoice {
    @Autowired
    private PetPort petPort;
    @Autowired
    private ClinicalOrderPort clinicalOrderPort;
    @Autowired
    private InvoicePort invoicePort;
    

    public void create(Invoice invoice) throws Exception{
        Pet pet = petPort.finById(invoice.getPet());
        if(pet==null){
            throw new Exception("La factura debe tener una mascota asociada");
        }
        if(invoice.isMedicine()){
            ClinicalOrder clinicalOrder = clinicalOrderPort.findByID(invoice.getOrder());
            if(clinicalOrder == null || pet.getId()!=clinicalOrder.getPet().getId()){
                throw new Exception("La venta del medicamento debe tener una orden asociada");
            }
            invoice.setOrder(clinicalOrder);
        }
        invoice.setPet(pet);
        invoice.setOwner(pet.getOwner());
        invoicePort.save(invoice);
    }

    
}
