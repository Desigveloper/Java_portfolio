import java.util.Scanner;

public class DistanceTraveled {
    // distance = u0 + (0.5 * acceleration * (time * time))
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        double acceleration, timeTraveled;

        System.out.print("Enter acceleration: ");
        acceleration = Double.parseDouble(sc.next());

        System.out.print("Enter time traveled: ");
        timeTraveled = Double.parseDouble(sc.next());

        double distance = (0.5 * acceleration * (timeTraveled * timeTraveled)) / 1000;

        System.out.printf("Distance traveled: %.2fKm/h\n", distance);
        
    }
}
