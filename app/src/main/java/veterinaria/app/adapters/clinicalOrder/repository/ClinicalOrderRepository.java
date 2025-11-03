package veterinaria.app.adapters.clinicalOrder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import veterinaria.app.adapters.clinicalOrder.entity.ClinicalOrderEntity;

public interface ClinicalOrderRepository  extends JpaRepository<ClinicalOrderEntity,Long> {
     public ClinicalOrderEntity findByOrderId(Long orderId);

}
