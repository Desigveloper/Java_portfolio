package hyperskills_challenges.october;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;


public class AntennaTurn {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner fileReader = new Scanner(new File("hyperskills_challenges//october//dataset_antenna.txt"));
        fileReader.useDelimiter(",|\\s+");
        List<Integer> numbers = new ArrayList<>();

        
        while (fileReader.hasNext()) {
           if (fileReader.hasNextInt()) {
               numbers.add(fileReader.nextInt());
           } else {
               fileReader.next();
           }
        }
        fileReader.close();
        
        int sum = 0;
        for (int el : numbers) {
            sum += el;
        }


        // Calculate the final position of the antenna
        int finalPosition = sum % 360;
        if (finalPosition < 0) {
            finalPosition += 360;
        }

        int correction;
        if (finalPosition == 0) {
            correction = 0;
        } else if (finalPosition <= 180) {
            correction = -finalPosition;
        }else {
            correction = 360 - finalPosition;
        }

        System.out.println("Sum: " + sum);
        System.out.println("Final position:" + finalPosition);
        System.out.println("Correction: " + correction);

    }
}
