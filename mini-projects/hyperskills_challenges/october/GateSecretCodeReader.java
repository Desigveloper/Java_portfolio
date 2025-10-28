package hyperskills_challenges.october;


import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class GateSecretCodeReader {
    public static void main(String[] args) throws FileNotFoundException{
        // Read the secret code from the file
        Scanner file = new Scanner(new File("hyperskills_challenges//october//dataset_gate.txt"));
        // Strore the secret code
        String data = file.nextLine();

        int[] counts = new int[10]; // Array to hold counts for digits 0-9

        // Count occurrences/frequency of each digit in the code
        for(char ch : data.toCharArray()) {
            if (Character.isDigit(ch)) {
                counts[ch - '0']++;
            }
        }

        
        List<Integer> digits = new ArrayList<>();

        for (int i = 0; i < counts.length; i++) {
            digits.add(i);
        }

        System.out.println(digits);

        Collections.sort(digits, (a, b) -> {
            if (counts[a] != counts[b]) {
                return counts[b] - counts[a];
            } else {
                return b - a;
            }
        });
        
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            code.append(digits.get(i));
        }

        System.out.println(Arrays.toString(counts));
        System.out.println(digits);
        System.out.println(code.toString());

        file.close();
    }
}
