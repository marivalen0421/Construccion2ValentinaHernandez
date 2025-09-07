package app.domain.port;

import java.util.List;
import app.domain.model.MedicalHistory;
import app.domain.model.Pet;
public interface MedicalHistoryPort {
    public void save(MedicalHistory medicalHistory) throws Exception;
    
    public List<MedicalHistory> finByPet(Pet pet) throws Exception;
}
