package veterinaria.app.ports;

import veterinaria.app.domain.model.Invoice;

public interface InvoicePort {
  public Invoice save(Invoice invoice);
}
