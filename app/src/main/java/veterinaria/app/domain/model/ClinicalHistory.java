package veterinaria.app.domain.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor

public class ClinicalHistory {
    private Long id;
    private Pet petId;
    private Long date;
    private Person veterinarianDocument;
    private String reason;
    private String symptoms;
    private String procedures;
    private String diagnosis;
    private String medications;
    private String dose;
    private String orderId;
    private String vaccinationHistoryId;
    private String allergies;
    private String proceduresNotes;

    public ClinicalHistory(Pet petId, Long date, Person veterinarianDocument, String reason, String symptoms, String procedures, String diagnosis, String medications, String dose, String orderId, String vaccinationHistoryId, String allergies, String proceduresNotes) {
        this.petId = petId;
        this.date = date;
        this.veterinarianDocument = veterinarianDocument;
        this.reason = reason;
        this.symptoms = symptoms;
        this.procedures = procedures;
        this.diagnosis = diagnosis;
        this.medications = medications;
        this.dose = dose;
        this.orderId = orderId;
        this.vaccinationHistoryId = vaccinationHistoryId;
        this.allergies = allergies;
        this.proceduresNotes = proceduresNotes;
    }
    @Override
    public String toString() {
        return "ClinicalHistory{" +
                "id=" + id +
                ", petId=" + (petId != null ? petId.getPetId() : null) +
                ", date=" + date +
                ", veterinarianDocument=" + (veterinarianDocument != null ? veterinarianDocument.getDocument() : null) +
                ", reason='" + reason + '\'' +
                ", symptoms='" + symptoms + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", medications='" + medications + '\'' +
                ", dose='" + dose + '\'' +
                ", allergies='" + allergies + '\'' +
                ", proceduresNotes='" + proceduresNotes + '\'' +
                '}';
    }

}
