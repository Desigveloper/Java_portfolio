

// import static java.lang.Math.*;

public class TestTextBuilder {
    public static void main(String[] args) {
       String sentence = "Try string code point".toUpperCase();
       int [] codePoint = sentence.codePoints().toArray();

       String strC;
       StringBuilder builder = new StringBuilder();
    
       int i = 0;
       for (int cp : codePoint) {
            
            if (i > 0) {
                builder.append(" - ");
                builder.append(cp);
            } else {
                builder.append(cp);
            }
            i++;
        }

    strC = builder.toString();

    
    System.out.println(strC);

    String m = "ffffff";
    int cpt = m.compareToIgnoreCase("FFFFF");
    System.out.println(cpt);
    
    int cp = 0X1F37C;
    String str = Character.toString(cp);
    System.out.println(str);
}
}