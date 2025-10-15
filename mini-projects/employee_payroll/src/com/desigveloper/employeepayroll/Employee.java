package com.desigveloper.employeepayroll;


import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

public class Employee {
    // Instant fields
    private static int nextId;
    private int id;

    private final String name;
    private double salary;
    private LocalDate employedDate;

    private static Random idGenerator = new Random();

    // initializing nextId with random number less 1000;
    static {
        nextId = idGenerator.nextInt(1000);
    }

    // Constructors
    public Employee(double eSalary) {
        this("", 0.0, 
        LocalDate.now().getYear(),
         LocalDate.now().getMonthValue(),
         LocalDate.now().getDayOfMonth());
    }
    public Employee(String eName, double eSalary, int year, int month, int day) {
        // if (name == null) this.name = "Unknown"; else this.name = name;
        this.name = Objects.requireNonNull(eName, "This name can't be null or empty");
        this.salary = eSalary;
        this.employedDate = LocalDate.of(year, month, month);
        
    }

    // Assigning unique id to each new employee
    private void setId() {
        this.id = nextId;
        nextId++;
    }
    
    public int getId() {
        setId();
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }

    public double getSalary() {
        return this.salary;
    }

    public LocalDate getEmployedDate() {
        return this.employedDate;
    }


    // Raise salary by specified %
    public void raiseSalary(double percentage) {
        double raise = this.salary * (percentage / 100);
        this.salary += raise;
    }

}
