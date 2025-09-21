package app.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.infrastructure.persistence.entities.MedicalHistoryEntity;

@Repository
public interface MedicalHistoryRepository extends JpaRepository<MedicalHistoryEntity, Long> {
    
}
