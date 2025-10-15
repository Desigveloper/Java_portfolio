import java.util.Arrays;
import java.util.Scanner;

/**
* This program demonstrates array manipulation.
* @version 1.20 2004-02-10
* @author Cay Horstmann
*/

public class TestArray {
    public static void main(String[] args) {
        LotteryDrawing drawing = new LotteryDrawing();
        drawing.makeDraw();
    }
}


class LotteryDrawing {
    public void makeDraw() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Show many numbers do you need to draw? ");
        int totalNumbers = sc.nextInt();

        System.out.println("What is the highest number you can draw?");
        int highestNumber = sc.nextInt();

        // Fill in the array with numbers 1, 2, 3 ...... n
        int[] numbers = new int[totalNumbers];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        // Draw numbers and put them in secon array
        int[] drawnNumbers = new int[highestNumber];

        for (int i = 0; i < drawnNumbers.length; i++) {
            
            // Make random numbers btween 0 and n - 1
            int rand = (int) (Math.random() * totalNumbers);

            // Picking number or element at random location
            drawnNumbers[i] = numbers[rand];

            // Move last element into random location
            numbers[rand] = numbers[totalNumbers - 1];
            totalNumbers--;
        }

        // Print sorted array
        Arrays.sort(drawnNumbers);
        System.out.print("The drawn combination of number: ");

        for (int i : drawnNumbers) {
            if (i != drawnNumbers[drawnNumbers.length - 1])
                System.out.print(i + " ");
            else System.out.println(i);
        }

        Arrays.sort(numbers);
        int index = Arrays.binarySearch(numbers, 2, numbers.length, (int)(Math.random() * numbers.length));
        System.out.println("Lucky number: " + numbers[index] + " at index " + index);
        System.out.println("length numbers: " + numbers.length);
        System.out.println("Element of numbers : " + Arrays.toString(numbers));

        sc.close();
    }
}
