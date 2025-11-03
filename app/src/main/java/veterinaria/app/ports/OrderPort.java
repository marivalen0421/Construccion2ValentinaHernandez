package veterinaria.app.ports;

import veterinaria.app.domain.model.ClinicalOrder;

public interface OrderPort {
  public ClinicalOrder save(ClinicalOrder order);
  public ClinicalOrder findByOrderId(Long orderId);
}
