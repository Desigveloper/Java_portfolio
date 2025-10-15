import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

public class TestReadFromFile {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(Path.of("tests//javaFile.txt"), StandardCharsets.UTF_8);
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
        sc.close();

       
    }
}
