import java.util.Scanner;


// Switch statement example non-overflow
public class TestSwitch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer");
        
        int input = sc.nextInt();

        String result = switch(input % 2) {
            case 0 -> "Even";
            case 1-> "Odd";
            default -> "Unknown";
        };

        System.out.println(result);
        sc.close();
    }
}