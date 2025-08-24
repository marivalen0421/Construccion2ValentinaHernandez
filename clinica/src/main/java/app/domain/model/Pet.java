package app.domain.model;

public class Pet {
    private long  id;
    private String petName;
    private Person documentOwner;
    private int age;
    private String species;
    private String race;
    private String description;
    private double weight;

    public Pet(double weight, String description, String race, String species, int age, Person documentOwner, String petName, long id) {
        this.weight = weight;
        this.description = description;
        this.race = race;
        this.species = species;
        this.age = age;
        this.documentOwner = documentOwner;
        this.petName = petName;
        this.id = id;
    }
}