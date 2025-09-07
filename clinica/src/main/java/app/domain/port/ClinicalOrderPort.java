package app.domain.port;
import java.util.List;
import app.domain.model.ClinicalOrder;
import app.domain.model.Pet;
public interface ClinicalOrderPort {
    public ClinicalOrder findByID(ClinicalOrder clinicalOrder) throws Exception;
    public List <ClinicalOrder> findByPet (Pet pet) throws Exception;
    public void save(ClinicalOrder clinicalOrder) throws Exception;
}
