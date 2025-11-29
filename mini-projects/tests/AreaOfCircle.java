import java.util.Scanner;

public class AreaOfCircle {
    private static final double PI = 3.14159;
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter radius of the circle: ");
        double radius = Double.parseDouble(sc.next());
        
        double area = PI * (radius * radius);
        System.out.println("Area of circle: " + area);
    }
}
