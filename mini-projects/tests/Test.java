import java.text.NumberFormat;
import java.util.Random;
import java.util.random.RandomGenerator;

public class Test {

    public static void main(String[] args) {
      TestConstructor cons = new TestConstructor();
      String name = cons.getName();
      int age = cons.getAge();
      boolean height = cons.getIsTall();

      String info = String.format("Name: %s\nAge: %d\nIs tall: %b",
          name, age, height);
      System.out.println(info);
      
      for (int i = 0; i < 10; i++) {
        System.out.println("Random number: " + NumberFormat.getNumberInstance()
          .format(cons.generateRandom()));
      }

      var p = new Points(3, 4);
      System.out.println(p.x());
      System.out.println(p.sumArgs());

      var in = new Points.InnerRecord(12, 7);
      System.out.println(in.multiplyArg());

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