
import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class Test {
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
      double num1, num2;
      String str;

      System.out.print("Enter any given two numbers separated by space: ");
      num1 = Double.parseDouble(sc.next());
      num2 = Double.parseDouble(sc.nextLine());
    

      // System.out.print("Enter any given string: ");
      // str = sc.nextLine();
      


      if (num1 > num2) {
        double temp = num1;
        num1 = num2;
        num2 = temp;
      }
        
        System.out.println(num1 + " " + num2);
      }

}


class TestConstructor {
  private String name;
  private int age;
  private boolean isTall;

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public boolean getIsTall() {
    return isTall;
  }

  public int generateRandom() {
    Random gen = Random.from(RandomGenerator.getDefault());
    return gen.nextInt(0, 1_000_000_000);
  }
}

record Points(double x, double y) {
  public record InnerRecord(int a, int b) {
    public static int age;
    public int multiplyArg() {
      RandomGenerator g = RandomGenerator.getDefault();
      age = g.nextInt(0, 100);
      return a * b + age;
    }
  }
  public double sumArgs() {
    return x + y;
  }
}