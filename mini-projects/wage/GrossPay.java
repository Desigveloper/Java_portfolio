package wage;

import java.util.Scanner;

public class GrossPay {
    private static final Scanner sc = new Scanner(System.in);
    private static final int STANDARD_WORK_HOURS = 40;

    public static void main(String[] args) {
        double hourlyRate, grossPay;
        int hoursWorked;
        
        System.out.print("Enter the hourly wage: ");
        hourlyRate = Double.parseDouble(sc.nextLine());

        System.out.print("Enter hours worked: ");
        hoursWorked = Integer.parseInt(sc.nextLine());

        if (hourlyRate > 40) {
            grossPay = STANDARD_WORK_HOURS * hourlyRate + 1.5 * hourlyRate * (hoursWorked - STANDARD_WORK_HOURS);
        } else {
            grossPay = hourlyRate * hoursWorked;
        }

        System.out.printf("Your pay is: $%.2f\n", grossPay);
    }
}
