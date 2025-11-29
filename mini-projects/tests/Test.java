
import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class Test {
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
      String str, strReversed = "";

      System.out.print("Enter any given string: ");
      str = sc.nextLine();

      for(int i = str.length() - 1; i >= 0; i--) {
        strReversed += str.charAt(i);
      }

      System.out.println("Reversed String: " + strReversed);
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