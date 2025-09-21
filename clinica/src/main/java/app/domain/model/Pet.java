package app.domain.model;

import app.domain.model.emuns.Species;

public class Pet {
    private long  id;
    private String petName;
    private User owner;
    private int age;
    private Species spices;
    private String race;
    private String description;
    private double weight;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getPetName() {
        return petName;
    }
    public void setPetName(String petName) {
        this.petName = petName;
    }
    public User getOwner() {
        return owner;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Species getSpices() {
        return spices;
    }
    public void setSpices(Species spices) {
        this.spices = spices;
    }
    public String getRace() {
        return race;
    }
    public void setRace(String race) {
        this.race = race;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

   
}