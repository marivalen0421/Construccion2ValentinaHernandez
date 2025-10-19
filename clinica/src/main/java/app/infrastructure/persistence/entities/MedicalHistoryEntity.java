package app.infrastructure.persistence.entities;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Medical_history")
public class MedicalHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="pet_id", nullable=false)
    private PetEntity pet;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="veterinarian_id", nullable=false)
    private UserEntity veterinarian;

    @Column(nullable=false)
    private Date date;

    @Column(length=255, nullable=false)
    private String motive;

    @Column(length=500)
    private String diagnosis;

    @Column(length=500)
    private String medicine;

    @Column(length=500)
    private String medicalProcedure;

    @Column(length=500)
    private String dose;

    @OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="clinical_order_id")
    private ClinicalOrderEntity clinicalOrder;

    @Column(length=500)
    private String vaccinationHistory;
    
    @Column(length=500)
    private String allergy;

    @Column(length=1000)
    private String procedureDetail;

    @Column(length=500)
    private String symtoms;

    @Column(nullable=false)
    private boolean status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PetEntity getPet() {
        return pet;
    }

    public void setPet(PetEntity pet) {
        this.pet = pet;
    }

    public UserEntity getVeterinarian() {
        return veterinarian;
    }

    public void setVeterinarian(UserEntity veterinarian) {
        this.veterinarian = veterinarian;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMotive() {
        return motive;
    }

    public void setMotive(String motive) {
        this.motive = motive;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getMedicalProcedure() {
        return medicalProcedure;
    }

    public void setMedicalProcedure(String medicalProcedure) {
        this.medicalProcedure = medicalProcedure;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public ClinicalOrderEntity getClinicalOrder() {
        return clinicalOrder;
    }

    public void setClinicalOrder(ClinicalOrderEntity clinicalOrder) {
        this.clinicalOrder = clinicalOrder;
    }

    public String getVaccinationHistory() {
        return vaccinationHistory;
    }

    public void setVaccinationHistory(String vaccinationHistory) {
        this.vaccinationHistory = vaccinationHistory;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getProcedureDetail() {
        return procedureDetail;
    }

    public void setProcedureDetail(String procedureDetail) {
        this.procedureDetail = procedureDetail;
    }

    public String getSymtoms() {
        return symtoms;
    }

    public void setSymtoms(String symtoms) {
        this.symtoms = symtoms;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    

}
