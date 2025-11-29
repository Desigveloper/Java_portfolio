package grades_average;

import java.util.Scanner;

public class GradeCalculator {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfCourses;
        double[] courseScores;
        double total = 0, average = 0;

        System.out.print("Enter total number of courses: ");
        numberOfCourses = Integer.parseInt(sc.nextLine());

        courseScores = new double[numberOfCourses];

        for(int i = 0; i < numberOfCourses; i++) {
            System.out.print("Enter course score (in %): ");
            courseScores[i] = Double.parseDouble(sc.nextLine());
        }

        for (double score : courseScores) {
            total += score;
        }

        average = total / numberOfCourses;

        System.out.printf("Average Grade: %.2f%%\n", average);
    }
}
