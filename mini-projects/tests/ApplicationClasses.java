import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class ApplicationClasses {
    public void testClasses() {
        var builder = new IronManBuilderExecute();
        builder.executeIronMan();
    }
}

/**
 * IronMan - Demonstrates the Builder design pattern as a substitute for an overloaded
 *              constructors and getters and setters
*/

class IronManBuilderExecute {
    public void executeIronMan() {
        IronMan ironMan = new IronMan.Builder("Iron man", 55, "Chivorlette")
            .withSpecialWeapon("Hammer")
            .withMedicineItems(new String[]{"First Aid Kit"})
            .build();

        String ironManInfo = "Name: %s%nAge: %d%nCar: %s%nSpecial weapon: %s%nMedicine item: %s"
            .formatted(ironMan.getName(), ironMan.getAge(), ironMan.getCar(), ironMan.getSpecialWeapon(),
                ironMan.getMedicineItems()[0]);

        System.out.println(ironManInfo);

    }
}

class IronMan {
    private final String name;
    private final int age;
    private final String car;
    private final String specialWeapon;
    private final String[] medicineItems;


    public static class Builder {
        private String name;
        private int age;
        private String car;
        private String specialWeapon;
        private String[] medicineItems;

        public Builder(String name, int age, String car) {
            this.name = name;
            this.age = age;
            this.car = car;
        }

        Builder withSpecialWeapon(String specialWeapon) {
            this.specialWeapon = specialWeapon;
            return this;
        }

        Builder withMedicineItems(String[] medicineItems) {
            this.medicineItems = medicineItems;
            return this;
        }

        public IronMan build() {
            return new IronMan(this);
        }
    }

    private IronMan(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.car = builder.car;
        this.specialWeapon = builder.specialWeapon;
        this.medicineItems = builder.medicineItems;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getCar() {
        return this.car;
    }

    public String getSpecialWeapon() {
        return this.specialWeapon;
    }

    public String[] getMedicineItems() {
        return this.medicineItems;
    }
}

class Student {
    private String name;
    private LocalDate yearEnrolled;

    public Student(String name, LocalDate yearEnrolled) {
        this.name = name;
        this.yearEnrolled = yearEnrolled;
    }

    public Student() {
        this("Unknown", LocalDate.now());
    }

    public String getName() {
        return this.name;
    }

    public LocalDate getEnrolledYear() {
        return this.yearEnrolled;
    }

    public void printStudentInfo() {
        System.out.printf("Name: %s\nEnrolled year: %s\n", getName(), getEnrolledYear().toString());
    }
}

class Calculator {
    static int sum(int num1, int num2) {
        return num1 + num2;
    }
    
    static double sum(int num1, double num2) {
        return num1 + num2;
    }
}

class LinePrinter {
    static void line() {
        char heart = '\u2661';
        for (int i = 0; i < 10; i++) {
            System.out.print(heart);
        }
        System.out.println();
    }
}

class SummingCalculator {
    private Scanner sc;
    private int sum = 0;

    public void sumNumbers() {
        sc = new Scanner(System.in);
        int input;

        System.out.println("Enter numbers");
        do {
            input = sc.nextInt();
            sum += input;
        } while (input != 0);

        System.out.println("Sum: " + sum);
    }
}

class SvgRectangles {
    private int degree = 0;
    private StringBuilder coordinates = new StringBuilder();
    private String shapeElement;
    
    private void builShapes() {
        int qauntity = 60;
        for (int i = 1; i <= qauntity; i++) {
            coordinates.append(String.format("\t\t<rect x=\"%d\" y=\"%d\" height=\"%d\" width=\"%d\"", 50, 50, 100, 100));
            coordinates.append(String.format("stroke=\"%s\" \n\t\t\tfill=\"%s\" transform=\"rotate(%d, 100, 100)\" />\n", 
                "black", "none", degree));

            if (i != qauntity) 
                coordinates.append("\n");
            
            degree += 10;
        }
    }
    public void printShapeToFile() {
        builShapes();
        var htmlTemplate = new StringBuilder();
        String documentHead = 
            "<!DOCTYPE html>\n" + //
            "<html lang=\"en\">\n" + //
                "\t<head>\n" + //
                    "\t  <meta charset=\"UTF-8\">\n" + //
                    "\t  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" + //
                    "\t  <title>Document</title>\n" + //
                "\t</head>\n";

                shapeElement = String.format("\t<svg height=\"%dpx\" width=\"%dpx\">\n\t  %s\t\t</svg>",200, 200, coordinates);
                
                String documentBody = String.format("\t<body>\n\t%s\n\t</body>\n</html>", shapeElement);
        
        try {
            var writer = new PrintWriter("index.html");
            htmlTemplate.append(documentHead);
            htmlTemplate.append(documentBody);
            writer.write(htmlTemplate.toString());
            writer.close();
        } catch (Exception e) {
            System.out.println("Error occured in writing file");
            e.printStackTrace();
        }
    }

    // public void printShapeToConsole() {
    //     builShapes();
    //     shapeElement = String.format("<svg height=\"%dpx\" width=\"%dpx\">\n%s</svg>",200, 200, coordinates);
        
    //     System.out.println(shapeElement);
    // }
}

class GrammarChecker {
    Scanner sc;
    private int numberOfBottles;

    public void checkGrammar() {
        sc = new Scanner(System.in);
        numberOfBottles = sc.nextInt();

        String str = numberOfBottles >= 0 ?  numberOfBottles != 1 ? String.format("%d bottles of rum", numberOfBottles) : 
                String.format("%d bottle of rum", numberOfBottles) : "";

        System.out.println(str);
    }
}
class coinMachine {
    Scanner sc;
    private double amount;

    public void printLirettaCoins() {
        sc = new Scanner(System.in);

        System.out.print("Please enter the amount of money: ");
        amount = sc.nextDouble();

        int liretta = (int) amount;
        
        System.out.printf("%d x 2 Liretta\n", liretta / 2);
        System.out.printf("%d x 1 Liretta\n", liretta % 2);

        int lirettacent = (int) ((amount - liretta) * 100); // Convert cents in whole number
        System.out.printf("%d x 50 Lirettacent\n", lirettacent / 50);
        
        lirettacent = (lirettacent % 50);
        System.out.printf("%d x 20 Lirettacent\n", lirettacent / 20);
        
        lirettacent = (lirettacent % 20);
        System.out.printf("%d x 10 Lirettacent\n", lirettacent / 10);

        lirettacent = (lirettacent % 10);
        System.out.printf("%d x 5 Lirettacent\n", lirettacent / 5);

        lirettacent = (lirettacent % 5);
        System.out.printf("%d x 2 Lirettacent\n", lirettacent / 2);

        System.out.printf("%d x 1 Lirettacent\n", lirettacent % 2);
    }
}


class AnchorDominoes {
    Scanner sc;
    private String str1;
    private String str2;

    public void printHasCommonDigit() {
        sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        String strO = "0" + sc.next();
        str1 = strO.substring(strO.length() - 2);

        System.out.print("Enter second number: ");
        String strT = "0" + sc.next();
        str2 = strT.substring(strT.length() - 2);


        boolean hasCommonDigit = str1.charAt(0) == str2.charAt(0) ||
            str1.charAt(0) == str2.charAt(1) ||
            str1.charAt(1) == str2.charAt(0) ||
            str1.charAt(1) == str2.charAt(1);

        System.out.println(hasCommonDigit);

    }
}

class LootBottles {
    Scanner sc;
    private int bottles;
    private int captainshare;
    private int crewShare;
    private int crewMembers;
    private boolean fairShare;

    public void shareBottles() {
        sc = new Scanner(System.in);
        System.out.print("Number of bottles in total? ");
        this.bottles = sc.nextInt();

        this.captainshare = bottles /2;
        this.crewShare = bottles - captainshare;

        System.out.printf("Bottles for the captain: %d\n", captainshare);
        System.out.printf("Bottles for all crew members: %d\n", crewShare);

        System.out.print("Number of crew members: ");
        this.crewMembers = sc.nextInt();

        fairShare = crewShare % crewMembers == 0;

        System.out.printf("Fair share without remainder? %b\n", fairShare);
    }
}

class SvgCircle1 {
    Scanner sc;
    private int height = 100;
    private int width = 1000;
    private int x;
    private int y;
    private static double r = Math.random() * 20;

    public void printShape() {
        sc = new Scanner(System.in);
        System.out.print("Enter x and y cordinate of the circle separated by space (ie 10 15): ");
        this.x = sc.nextInt();
        this.y = sc.nextInt();
        String cordinateStr = String.format("<svg height=\"%d\" width=\"%d\">\n   <circle cx=\"%d\" cy=\"%d\" r=\"%f\" />\n</svg>",
         height, width, x, y, r);
        System.out.println(cordinateStr);
    }
}

