package hyperskills_challenges.october;

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class KeypadDecoder {
    public static void main(String[] args) {
            String filePath = "hyperskills_challenges//october//dataset_keypad.txt";

            String[] lines = readFileLines(filePath);

            // List<String> lines = Files.readAllLines(Paths.get("hyperskills_challenges//october//dataset_keypad.txt"));
            

            String result = decomposeSequence(lines);
            System.out.println(result);

    }

    public static String[] readFileLines(String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            StringBuilder content = new StringBuilder();

            int lineNumber = 1;

            while (scanner.hasNextLine()) {
                content.append(lineNumber + ": ").append(scanner.nextLine()).append("\n\n");
                lineNumber++;
            }

            scanner.close();
            PrintWriter writer = new PrintWriter("dataset.txt");
            writer.write(content.toString());
            writer.close();

            return content.toString().split("\n");
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
            return new String[0]; // Return empty string
        }
    }

    public static String decomposeSequence(String[] inputLines) {
        StringBuilder result = new StringBuilder();

        for (String line : inputLines) {
            if (line.isEmpty())
                continue;

            int row = 0, col = 0;

            String[] moves = line.trim().split(",");

            for (String move : moves) {
                switch (move.trim().toUpperCase()) {
                    case "UP" -> row = Math.max(row - 1, 0);
                    case "DOWN" -> row = Math.min(row + 1, 3);
                    case "LEFT" -> col = Math.max(col - 1, 0);
                    case "RIGHT" -> col = Math.min(col + 1, 3);
                }

            }
            char currentChar = (char) ('A' + (row * 4) + col);
            result.append(currentChar);
        }
        return result.toString().replace("", "").trim();
    }
}
