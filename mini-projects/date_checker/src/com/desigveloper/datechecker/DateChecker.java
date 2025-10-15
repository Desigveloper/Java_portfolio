package com.desigveloper.datechecker;

import java.time.LocalDate;
import java.util.Scanner;

public class DateChecker {
    private int month;
    private int year;
    private int days;
    private boolean isLeapYear;

    private void setMonth(Scanner sc) {
        System.out.print("Enter month: ");
        month = sc.nextInt();
    }

    private void setYear(Scanner sc) {
        System.out.print("Enter year: ");
        year = sc.nextInt();
    }

    private void setDays(int month, int year) {
        this.isLeapYear = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;

        this.days = switch (month) {
            case 2 -> this.isLeapYear ? 29 : 28;
            case 4, 6, 9, 11 -> 30;
            default -> 31;
        };
    }

    private int getMonth() {
        return this.month;
    }

    private int getYear() {
        return this.year;
    }

    private int getDays() {
        return this.days;
    }

    public void checkDate() {
        setMonth(new Scanner(System.in));
        setYear(new Scanner(System.in));
        setDays(getMonth(), getYear());

        var date = LocalDate.of(getYear(), getMonth(), getDays());
        String monthStr = date.getMonth().toString();

        if (isLeapYear && monthStr.equalsIgnoreCase("february")) {
            System.out.printf("%d is a leap year, and number days for %s is %d.\n",
                getYear(), monthStr, getDays());
                System.exit(0);   
        }

        System.out.printf("Year is %d, and number of days for %s is %d.\n",
                getYear(), monthStr, getDays()); 
    }

}
