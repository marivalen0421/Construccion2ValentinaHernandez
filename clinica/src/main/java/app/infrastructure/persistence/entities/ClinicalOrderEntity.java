package app.infrastructure.persistence.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Clinical_orders")
public class ClinicalOrderEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="veterinarian_id", nullable=false)
    private UserEntity veterinarian;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name= "pet_id", nullable=false)
    private PetEntity pet;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="owner_id" ,nullable=false)
    private UserEntity owner;

    @Column(nullable=false, length=150)
    private String medicine;

    @Column(nullable= false, length=50)
    private String dose;

    @Column(nullable=false)
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserEntity getVeterinarian() {
        return veterinarian;
    }

    public void setVeterinarian(UserEntity veterinarian) {
        this.veterinarian = veterinarian;
    }

    public PetEntity getPet() {
        return pet;
    }

    public void setPet(PetEntity pet) {
        this.pet = pet;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }




}
