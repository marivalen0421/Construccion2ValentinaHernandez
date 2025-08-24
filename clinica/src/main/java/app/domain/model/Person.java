package app.domain.model;

public class Person {
    private long document;
    private String name;
    private int age;
    private String role;

    public Person(long document, String name, int age, String role) {
        this.document = document;
        this.name = name;
        this.age = age;
        this.role = role;
    }
}