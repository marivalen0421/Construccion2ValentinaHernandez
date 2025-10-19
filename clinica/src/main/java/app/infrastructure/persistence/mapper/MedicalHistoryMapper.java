package app.infrastructure.persistence.mapper;

import app.domain.model.MedicalHistory;
import app.infrastructure.persistence.entities.MedicalHistoryEntity;

public class MedicalHistoryMapper {

    public static  MedicalHistory toDomain(MedicalHistoryEntity entity) {
        if(entity == null) return null;

        MedicalHistory record = new MedicalHistory();
        record.setId(entity.getId());
        record.setPet(PetMapper.toDomain(entity.getPet()));
        record.setVeterinarian(UserMapper.toDomain(entity.getVeterinarian()));
        record.setDate(entity.getDate());
        record.setMotive(entity.getMotive());
        record.setDiagnosis(entity.getDiagnosis());
        record.setMedicine(entity.getMedicine());
        record.setMedicalProcedure(entity.getMedicalProcedure());
        record.setDose(entity.getDose());
        record.setClinicalOrder(ClinicalOrderMapper.toDomain(entity.getClinicalOrder()));
        record.setVaccinationHistory(entity.getVaccinationHistory());
        record.setAllergies(entity.getAllergy());
        record.setProcedure(entity.getProcedureDetail());
        record.setSymptoms(entity.getSymtoms());
        record.setStatus(entity.isStatus());
        return record;
    }
    public static MedicalHistoryEntity toEntity(MedicalHistory domain) {
        if(domain == null) return null;

        MedicalHistoryEntity entity = new MedicalHistoryEntity();
        entity.setId(domain.getId());
        entity.setPet(PetMapper.toEntity(domain.getPet()));
        entity.setVeterinarian(UserMapper.toEntity(domain.getVeterinarian()));
        entity.setDate(domain.getDate());
        entity.setMotive(domain.getMotive());
        entity.setDiagnosis(domain.getDiagnosis());
        entity.setMedicine(domain.getMedicine());
        entity.setMedicalProcedure(domain.getMedicalProcedure());
        entity.setDose(domain.getDose());
        entity.setClinicalOrder(ClinicalOrderMapper.toEntity(domain.getClinicalOrder()));
        entity.setVaccinationHistory(domain.getVaccinationHistory());
        entity.setAllergy(domain.getAllergies());
        entity.setProcedureDetail(domain.getProcedure());
        entity.setSymtoms(domain.getSymptoms());
        entity.setStatus(domain.isStatus());

        return entity;
    }

}
