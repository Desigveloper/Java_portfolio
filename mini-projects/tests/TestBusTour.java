import java.util.Scanner;

public class TestBusTour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int n = sc.nextInt();

        String str = "";

       for (int j = 1; j <= n; j++) {
           int a = sc.nextInt();
           if (a >= h) {
               str = "Will crash on bridge " + j;
               break;
           }

           str = "Will not crash";
       }
       System.out.println(str);
    }
}
