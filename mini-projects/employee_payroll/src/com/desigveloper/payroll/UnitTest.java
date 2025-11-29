package com.desigveloper.payroll;

public class UnitTest {
    int n = 5;
    public static void main(String[] args) {
        Employee x = new Employee("Ben", 20.5, 2020, 5, 21);
        Employee y = new Employee("Jane", 5.5, 2019, 03, 10);

        swapByReference(x, y);
        System.out.println("x = " + x.getName());
        System.out.println("y = " + y.getName());

        int a = 5;
        int b = 7;
        swapByValue(a, b);
        
        System.out.println("A = " + a);
        System.out.println("B = " + b);
        
        System.out.println("Before triple salary = " + x.getSalary());
        System.out.println("Before triple salary = " + y.getSalary());
        tripleN(x);
        tripleN(y);

        System.out.println("After triple out method - salary = " + x.getSalary());
        System.out.println("After triple out method - salary = " + y.getSalary());
    }

    static void swapByReference(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;

        System.out.println("x  = " + x.getName());
        System.out.println("y = " + y.getName());
        
    }

    static void swapByValue(int a, int b) {
        int temp = a;
        a = b;
        b = temp;

        System.out.println("A = " + a);
        System.out.println("B = " + b);
    }

    static void tripleN(Employee x) {
        x.raiseSalary(200);
        System.out.println("After triple in method - salary = " + x.getSalary());
    }
}
