package temperature_convertor;

import java.util.Scanner;

public class Convertor {
    private static final Scanner sc = new Scanner(System.in);
    
    public void showMenu() {
        while (true) {   
            System.out.println("\n=== Kelvin Degree - Fahrenheit Convertor ====");
            System.out.println("1. Convert Kelvin to Fahrenheit");
            System.out.println("2. Convert Fahrenheit to Kelvin degree");
            System.out.println("3. Convert Degree Celsius to Fahrenheit");
            System.out.println("4. Convert Fahrenheit to Degree degree");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> {
                    convertKelvinToFahrenheit();
                    return;
                }
                case 2 -> { 
                    convertFahrenheitToKelvin();
                    return;
                }
                case 3 -> { 
                    convertCelsiusToFahrenheit();
                    return;
                }case 4 -> { 
                    convertFahrenheitToCelsius();
                    return;
                }
                case 0 -> System.exit(0);
                default -> System.out.println("Invalid option");
            }
        }
    }

    private void convertKelvinToFahrenheit() {
        // Fahrenheit = 1.8 * kelvin - 459.67
        
        double kelvin, fahrenheit;

        System.out.print("Enter temperature in Kelvin: ");
        kelvin = Double.parseDouble(sc.nextLine());

        fahrenheit = 1.8 * kelvin - 459.67;

        System.out.printf("%.2f Kelvin Degree = %.2f Fahrenheit\n", kelvin, fahrenheit);

    }

    private void convertFahrenheitToKelvin() {
        //  Kelvin = (Fahrenheit + 459.67) / 1.8
        double kelvin, fahrenheit;

        System.out.print("Enter temperature in Fahrenheit: ");
        fahrenheit = Double.parseDouble(sc.nextLine());

        kelvin = (fahrenheit + 459.67) / 1.8;

        System.out.printf("%.2f Fahrenheit = %.2f Kelvin Degree\n", fahrenheit, kelvin);
        
    }
    
    private void convertCelsiusToFahrenheit() {
        //  fahrenheit = (Celsius * 1.8) + 32
        double celsius, fahrenheit;

        System.out.print("Enter temperature in Fahrenheit: ");
        celsius = Double.parseDouble(sc.nextLine());

        fahrenheit = (celsius * 1.8) + 32;

        System.out.printf("%.2f Degree Celsius = %.2f Fahrenheit\n", celsius, fahrenheit);
        
    }
    
    private void convertFahrenheitToCelsius() {
        //  Kelvin = (Fahrenheit - 32) / 1.8
        double celsius, fahrenheit;

        System.out.print("Enter temperature in Fahrenheit: ");
        fahrenheit = Double.parseDouble(sc.nextLine());

        celsius = (fahrenheit - 32) / 1.8;

        System.out.printf("%.2f Fahrenheit = %.2f Degree Celsius\n", fahrenheit, celsius);
        
    }
}
