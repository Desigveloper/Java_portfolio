package com.desigveloper.studentmanagement.model;

public abstract class Person {
    private String id;
    private String name;
    private String email;

    public Person(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters
    public String getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return this.email;
    }

}


