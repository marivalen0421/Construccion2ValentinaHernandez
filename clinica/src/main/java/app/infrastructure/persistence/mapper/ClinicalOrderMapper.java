package app.infrastructure.persistence.mapper;

import app.domain.model.ClinicalOrder;
import app.infrastructure.persistence.entities.ClinicalOrderEntity;

public class ClinicalOrderMapper {

    public static ClinicalOrderEntity toEntity(ClinicalOrder domain) {
        if(domain == null) return null;

        ClinicalOrderEntity entity = new ClinicalOrderEntity();
        entity.setId(domain.getId());

        entity.setPet(PetMapper.toEntity(domain.getPet()));
        entity.setOwner(UserMapper.toEntity(domain.getOwner()));
        entity.setVeterinarian(UserMapper.toEntity(domain.getVeterinarian()));
        entity.setMedicine(domain.getMedicine());
        entity.setDose(domain.getDoce());
        entity.setDate(domain.getDate());

        return entity;
    }
    public static ClinicalOrder toDomain(ClinicalOrderEntity entity) {
        if(entity == null) return null;

        ClinicalOrder domain = new ClinicalOrder();
        domain.setId(entity.getId());

        domain.setPet(PetMapper.toDomain(entity.getPet()));
        domain.setOwner(UserMapper.toDomain(entity.getOwner()));
        domain.setVeterinarian(UserMapper.toDomain(entity.getVeterinarian()));
        domain.setMedicine(entity.getMedicine());
        domain.setDoce(entity.getDose());
        domain.setDate(entity.getDate());

        return domain;
    }
    
}
