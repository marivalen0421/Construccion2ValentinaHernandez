package veterinaria.app.domain.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veterinaria.app.adapters.invoice.InvoiceAdapter;
import veterinaria.app.domain.model.ClinicalOrder;
import veterinaria.app.domain.model.Invoice;
import veterinaria.app.domain.model.Pet;

@Service
@Getter
@Setter
@NoArgsConstructor
public class InvoiceService {
    @Autowired
    private InvoiceAdapter invoiceAdapter;
    
    public void saveInvoice(ClinicalOrder order, Long milisecondsDate, int quantity, double value){
        Invoice invoice = new Invoice();
        invoice.setQuantity(quantity);
        invoice.setValue(value);
        invoice.setDate(milisecondsDate);
        invoice.setOrderId(order);
        invoice.setPetId(order.getPetId());
        invoice.setProduct(order.getMedicine().getMedications());

        Invoice savedInvoice = invoiceAdapter.save(invoice, order);
    }

    public void saveInvoice(Long milisecondsDate, int quantity, double value, String product, Pet pet){
        Invoice invoice = new Invoice();
        invoice.setQuantity(quantity);
        invoice.setValue(value);
        invoice.setDate(milisecondsDate);
        invoice.setProduct(product);
        invoice.setPetId(pet);
        invoice.setOrderId(null);
        invoice.setOwnerDocument(pet.getOwnerDocument());

        Invoice savedInvoice = invoiceAdapter.save(invoice);
    }
}
