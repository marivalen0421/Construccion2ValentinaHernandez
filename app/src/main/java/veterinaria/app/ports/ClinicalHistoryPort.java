package veterinaria.app.ports;

import veterinaria.app.domain.model.ClinicalHistory;

public interface ClinicalHistoryPort {
  // Crear la historia clinica
  public ClinicalHistory save(ClinicalHistory clinicalHistory);

  // Consultar historia clinica
  public ClinicalHistory findByDate(Long date);
}
