import java.util.Scanner;

public class AreaOfRectangle {
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        double base, height, area;

        System.out.print("Enter length of base: ");
        base = Double.parseDouble(scanner.next());

        System.out.print("Enter height of rectangle: ");
        height = Double.parseDouble(scanner.next());

        area = base * height;
        System.out.println("Area = " + area);

    }
}
