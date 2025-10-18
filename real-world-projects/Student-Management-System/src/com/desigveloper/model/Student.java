package com.desigveloper.model;

import java.time.LocalDate;

public class Student {
    private final String index;
    private final String name;
    private final LocalDate birthDate;

    private Student(Builder builder) {
        this.name = builder.name;
        this.birthDate = builder.birthDate;
        this.index = builder.index;
    } 

    //Getters only


    // Builder class
    public static class Builder {
        private String index;
        private  String name;
        private LocalDate birthDate;

        public Builder(String index, String name, String LocalDate) {
            this.name = name;
            this.index = index;
        }

        public Student build() {
            return new Student(this);
        }
        
    }


}
