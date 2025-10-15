

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class TestPrintToFile {
   public static void main(String[] args) throws IOException {
     PrintWriter wr = new PrintWriter("tests//javaFile.txt", StandardCharsets.UTF_8);
     wr.write("This text was just written");
     wr.close();
   }
}
