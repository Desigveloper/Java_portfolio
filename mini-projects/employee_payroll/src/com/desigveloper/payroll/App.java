package com.desigveloper.payroll;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Employee[] staff = new Employee[2];
        
        // staff[0] = new Employee(null, 102.7, 2024, 7, 25);
        int i = 0;
        while (i < staff.length) {

            System.out.print("Enter employee name: ");
            String name = sc.nextLine();

            if (name.length() < 1) name = null;
            
            System.out.print("Enter employee salary: ");
            double salary = sc.nextDouble();
            
            System.out.print("Enter date employed separated by space (ie. 2025 12 27): ");
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();

            
            staff[i] = new Employee(name, salary, year, month, day);
            i++;
        }
        sc.close();

        staff[1].raiseSalary(7);


        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();

        for (var employee : staff) {
            if (LocalDate.now().getYear() - employee.getEmployedDate().getYear() >= 10)
                employee.raiseSalary(12.2);
    
            String info = "Staff ID: %d\nName: %s\nEmployed Date: %s\nSalary: %s".formatted(
                employee.getId(),
                employee.getName(), 
                employee.getEmployedDate().toString(),
                currencyFormatter.format( employee.getSalary()).toString()
            );

            System.out.println(info);
        }
    }
}
