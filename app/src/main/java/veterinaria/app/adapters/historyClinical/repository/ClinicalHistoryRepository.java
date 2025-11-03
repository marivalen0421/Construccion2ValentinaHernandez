package veterinaria.app.adapters.historyClinical.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import veterinaria.app.adapters.historyClinical.entity.HistoryClinicalEntity;

import java.time.LocalDate;


public interface ClinicalHistoryRepository extends JpaRepository<HistoryClinicalEntity,Long> {
    public HistoryClinicalEntity findByDate(Long miliseconds);


}
