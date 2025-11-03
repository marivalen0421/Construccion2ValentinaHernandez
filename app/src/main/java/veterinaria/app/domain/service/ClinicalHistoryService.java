package veterinaria.app.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veterinaria.app.adapters.historyClinical.HistoryClinicalAdapter;
import veterinaria.app.domain.model.ClinicalHistory;
import veterinaria.app.domain.model.Person;
import veterinaria.app.domain.model.Pet;
import veterinaria.app.exceptions.NotFoundException;

import java.time.LocalDate;

@Service
public class ClinicalHistoryService {
    @Autowired
    private HistoryClinicalAdapter historyClinicalAdapter;

    public ClinicalHistory saveHistory(ClinicalHistory clinicalHistory, String ms) {
        historyClinicalAdapter.save(clinicalHistory);
        return clinicalHistory;
    }
    public ClinicalHistory saveHistory( Pet petId, Long milisecondDate, Person veterinarianDocument, String reason, String symptoms, String procedures, String diagnosis, String medications, String dose, String orderId, String vaccinationHistoryId, String allergies, String proceduresNotes) {
        if (milisecondDate == null){
            milisecondDate = System.currentTimeMillis();
        }

        ClinicalHistory clinicalHistory = new ClinicalHistory(petId,milisecondDate,veterinarianDocument,reason,symptoms, procedures,diagnosis,medications,dose, orderId,vaccinationHistoryId,allergies,proceduresNotes);
        HistoryClinicalAdapter hClinicalAdapter = new HistoryClinicalAdapter();
        historyClinicalAdapter.save(clinicalHistory);

        System.out.println("ClinicalHistory saved" +  clinicalHistory.toString());
        return clinicalHistory;

    }
    public ClinicalHistory searchCH(Long milisecon) throws Exception{
        ClinicalHistory cliHistory = historyClinicalAdapter.findByDate(milisecon);
        if (cliHistory == null)throw new NotFoundException("ClinicalHistory not found");{
            return cliHistory;
        }
    }


}
