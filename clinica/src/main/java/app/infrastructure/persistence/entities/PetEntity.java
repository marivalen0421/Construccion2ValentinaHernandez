package app.infrastructure.persistence.entities;

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
@Table(name="pets")
public class PetEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="owner_id", nullable=false)
    private UserEntity owner;

    @Column(nullable=false, length=50)
    private String name;

    @Column(nullable= false)
    private int age;

    @Column(nullable=false)
    private double weight;

    @Column(nullable= false, length=50)
    private String spicies;

    @Column(columnDefinition="TEXT")
    private String description;

    @Column(length=100)
    private String race;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getSpicies() {
        return spicies;
    }

    public void setSpicies(String spicies) {
        this.spicies = spicies;
    }

  

}
