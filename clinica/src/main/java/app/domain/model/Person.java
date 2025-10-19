package app.domain.model;

import app.domain.model.emuns.Role;

public class Person {
    private long id;
    private long document;
    public long getDocument() {
        return document;
    }

    public void setDocument(long document) {
        this.document = document;
    }

    private String name;
    private int age;
    private Role role;

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }
    
    public Role getRole(){
        return role;
    }

    public void setRole(Role role){
        this.role =role;
    }
}
