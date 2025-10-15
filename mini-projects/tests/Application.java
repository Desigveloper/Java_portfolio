import java.util.Scanner;

public class Application {
    int mode;
    public static void main(String... args) {


    }

    static void printXor(int condition1, int condition2) {
        System.out.println(condition1 ^ condition2);
    }

    /*
     * calculates Fibonacci numbers and their sum in the infinite cycle
    */
    static void fibonacciSum() {
        int fibonacciPrevious = 1;
        int fibonacciCurrent = 1;
        int fibonacciSum = fibonacciPrevious + fibonacciCurrent;

        while (true) {
            int tmp = fibonacciPrevious + fibonacciCurrent;
            fibonacciPrevious = fibonacciCurrent;
            fibonacciCurrent = tmp;
            fibonacciSum += fibonacciCurrent;
            
            if (fibonacciCurrent > 1000) break;
        }

        System.out.println("Sum: " + fibonacciSum);
    }

    /*
     * find the greatest prime number that is smaller than 459
    */
    static void findGreatestPrime() {
        int greatestPrimeInRange = 2;
        
        for (int number = 2; number <= 1000; number++) {
            if (isPrime(number) && number > greatestPrimeInRange) {
                greatestPrimeInRange = number;
            }
        }
        System.out.println(greatestPrimeInRange);
    }

        static boolean isPrime(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i != 0) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    /*
     * Modify the given string by applying the following operations in the given order:
     * 1. Remove characters from index 2 to index 9 (inclusive).
     * 2. If the string contains a space (" "), append "ABC" to the
    */
     static String modifyString(String initialString) {
        String modString = initialString;

        modString = modString.substring(0, 2) + modString.substring(10); // 1
        if (modString.contains(" ")) { // 2
            modString += "ABC";
        }
        int space = modString.indexOf(" ");
        modString = modString.substring(space + 1) + modString.substring(0, space); // 3
        if (modString.contains("a")) { // 4
            modString += "1248";
        }
        modString = modString.replaceFirst("\\s", "\\$"); // 5
        if (modString.length() < 15) { // 6
            modString = new StringBuilder(modString).reverse().toString();
        }
        modString += "18B20"; // 7
        int one = modString.indexOf("1");
        int five = modString.indexOf("5");
        modString = modString.substring(one + 1) + modString.substring(0, five); // 8
        modString.substring(0, modString.length() - 4); // 9

        return modString;
    }

    static void countMaxPossibleCandies(int[] candyPrices, int availableFunds) {
        int lenghtOfPrices = candyPrices.length;
        
        // Bobble sort array
        for (int i = 0; i < lenghtOfPrices - 1; i++) {
            for (int j = 0; j < lenghtOfPrices - i - 1; j++) {
                if (candyPrices[j] > candyPrices[j + 1]) {
                    int temp = candyPrices[j];
                    candyPrices[j] = candyPrices[j + 1];
                    candyPrices[j + 1] = temp;
                }
            }
        }


        int count = 0;
        int sum = 0;
        for (int price : candyPrices) {
            if (sum + price > availableFunds) {
                break;
            } else {
                sum += price;
            }
            count++;
        }

        System.out.println(sum);
        System.out.println(count);
    }

    static String convertToBinary(Scanner sc) {
        System.out.print("Enter decimal nummber: ");
        int number = sc.nextInt();
        String binaryDigits = "";
        int rem;

        while (number > 0) {
            rem = number % 2;
            binaryDigits = rem + binaryDigits;
            number /= 2;
        }

        return binaryDigits;
    }
    static void getNumberOfDigits(Scanner sc) {
        System.out.print("Enter number: ");
        int number = sc.nextInt();
        int count = 0;

        while (number > 0) {
            number /= 10;
            count++;
        }

        System.out.println(count);
    }
    static void drawChrismasTree(Scanner sc) {
        System.out.print("Enter tree width: ");
        int width = sc.nextInt();

        for (int i = 0; i <= width / 2; i++) {
            for (int j = 0; j <= width - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= 2 * i; j++) {
                int rand = (int) (Math.random() * 10);
                if (j == rand) System.out.print("o");
                else System.out.print("*");
            }
            System.out.println();
        }
    }


    static void determineNumber(Scanner sc) {
        System.out.print("Enter number: ");
        long num = sc.nextLong();

        if (num == 0) {
            System.err.println(0 + ", " + 0);
            return;
        }

        long min = 9;
        long max = 0;

        long rem = 0;

        if (num < 0) num = -num;
        
        while (num != 0) {
            System.out.println(num);
            rem = num % 10;

            if (rem > max) {
                max = rem;
            }

            if (rem < min) min = rem;
            
            num /= 10;
        }

        System.out.println(min + ", " + max);
    }
    

    static void product() {
         double t = Math.random() * 10;

       while (t > 0) {
           System.out.println(t);
           
            if (t < 1)
                t *= 2;
            else t -= 1;

       }
    }
}
