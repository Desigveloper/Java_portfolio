package quadratic_equation;

import java.util.Scanner;

public class Quadratic {
    private static Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        double x, x1, x2, a, b, c, discriminator;

        System.out.print("Enter values for coefficients a, b and c separated by space: ");
        a = Double.parseDouble(cin.next());
        b = Double.parseDouble(cin.next());
        c = Double.parseDouble(cin.next());

        if (a != 0) {
            discriminator = (Math.pow(b, 2) - 4) * a * c;

            if (discriminator >= 0) {
                if (discriminator > 0) {
                    x1 = (-b + Math.sqrt(discriminator)) / (2 * a); 
                    x2 = (-b - Math.sqrt(discriminator)) / (2 * a);
                    System.out.printf("Roots: X1 = %d, X2 = %d\n", (int)x1, (int)x2);
                } else {
                    x = -b / (2 * a);
                    System.out.printf("Root: X = %d\n", (int)x);
                }
            } else {
                System.out.println("Complex roots");
            }
        } else {
            if (b != 0) {
                x = -c / b;
                System.out.printf("Root; X = %d\n", (int)x);
            } else {
                if (c != 0) {
                    System.out.println("Undefined");
                } else {
                    System.out.println("Indeterminate");
                }
            }
        }
    }
}
