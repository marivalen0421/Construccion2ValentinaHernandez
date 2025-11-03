package veterinaria.app.adapters.rest.request;

import lombok.Getter;
import lombok.Setter;
import veterinaria.app.domain.model.Person;

import java.time.LocalDate;

@Getter
@Setter
public class HistoryClinicalRequest {
    private Long id;
    private Long petId;
    private LocalDate date;
    private Long veterinarianDocument;
    private String reason;
    private String symptoms;
    private String procedures;
    private String diagnosis;
    private String medications;
    private String dose;
    private String orderId;
    private String vaccinationHistoryId;
    private String allergies;
    private String notes;


    private String userNameVet;
    private String passwordVet;

    @Override
    public String toString() {
        return "HistoryClinicalRequest{ "+
                "\nid=" + id +
                "\npetId=" + petId +
                "\ndate=" + date +
                "\nveterinarianDocument=" + veterinarianDocument +
                "\nreason=" + reason +
                "\nsymptoms=" + symptoms +
                "\nprocedures=" + procedures +
                "\ndiagnosis=" + diagnosis +
                "\nmedications=" + medications +
                "\ndose=" + dose +
                "\norderId=" + orderId +
                "\nvaccinationHistoryId=" + vaccinationHistoryId +
                "\nallergies=" + allergies +
                "\nnotes=" + notes+"}";
    }
}