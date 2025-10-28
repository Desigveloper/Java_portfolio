package hyperskills_challenges.october;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UniqueLettersFinder {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileReader = new Scanner(new File("hyperskills_challenges//october//dataset_unique_letters.txt"));
        String data = fileReader.nextLine();
        fileReader.close();

        StringBuilder uniqueLetters = new StringBuilder();
        for (char ch : data.toCharArray()) {
            data.trim();
            
        }

        System.out.println(uniqueLetters.toString());
    }
}
