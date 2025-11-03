package veterinaria.app.domain.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veterinaria.app.adapters.clinicalOrder.ClinicalOrderAdapter;
import veterinaria.app.domain.model.ClinicalOrder;



@Getter
@Setter
@NoArgsConstructor
@Service
public class SellerService {
    @Autowired
    private ClinicalOrderAdapter clinicalOrderAdapter;
    public void existMedicine(ClinicalOrder order)throws Exception{
        if(order.getMedicine().getMedications().length()==0){
            throw new Exception("Medicine not found");
        }
    }
}
