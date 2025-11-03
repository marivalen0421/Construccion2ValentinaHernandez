package veterinaria.app.domain.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veterinaria.app.adapters.clinicalOrder.ClinicalOrderAdapter;
import veterinaria.app.domain.model.ClinicalHistory;
import veterinaria.app.domain.model.ClinicalOrder;
import veterinaria.app.domain.model.Person;
import veterinaria.app.domain.model.Pet;
import veterinaria.app.exceptions.NotFoundException;

@Service
@Getter
@Setter
@NoArgsConstructor
public class ClinicalOrderService {
    @Autowired
    private ClinicalOrderAdapter clinicalOrderAdapter;

    public void createOrder(ClinicalHistory cliHis){
        System.out.println("Creating ClinicalOrder");
        saveOrder(null, cliHis.getPetId(),cliHis.getPetId().getOwnerDocument(), cliHis.getVeterinarianDocument(), cliHis, null);

    }
    public ClinicalOrder saveOrder(Long orderId, Pet pet, Person owner, Person vet, ClinicalHistory cliHis, Long ms) {
        if (ms == null) {
            ms = System.currentTimeMillis();
        }
        ClinicalOrder order = new ClinicalOrder(orderId, pet, owner, vet, cliHis,ms);
        order = clinicalOrderAdapter.save(order);
        System.out.println("Saved ClinicalOrder");
        return  order;
    }

    public  ClinicalOrder searchOrder(Long orderId)throws Exception{
        ClinicalOrder order = clinicalOrderAdapter.findByOrderId(orderId);
        if(order == null){
            throw new NotFoundException("Order not found");
        }
        return order;
    }

}
