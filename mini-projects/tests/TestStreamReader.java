import java.util.Scanner;

public class TestStreamReader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] nums = new double[5];

        int i = 0;
        while (sc.hasNextDouble()) {
            if (i == nums.length)
                break;

            System.out.println("Enter number: ");
            nums[i] = sc.nextDouble();
            i++;
        }

        i = 0;
        for (double num : nums) {
            System.out.printf("Number at index %d: %.2f\n", i, num);
            i++;
        }

        sc.close();

        double dec = 250500000002.33733333;
        System.out.printf("The amount is %,.2f\n", dec);
    }
}
