import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ReadText {
    public static void main(String[] args) throws IOException {
        parseText();
    }
    public static void parseText() throws FileNotFoundException, IOException {
        // String fullDatabaseNameString = "";
        ArrayList<String> listOfWords = new ArrayList<>();
        String line;
        Random rand = new Random();

        try (
                InputStream fis = new FileInputStream("C:\\Users\\Inclusiv Academy16\\Desktop\\NewData.txt");
                InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
                BufferedReader br = new BufferedReader(isr);
        ) {
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                for (int i = 0; i < words.length; i++) {
                    if (!words[i].matches("\\ny") || !words[i].matches("\\fa")) {
                        //i++;
                        listOfWords.add(words[i]);
                        System.out.print(words[i]);
                        i++;
                    }
                }
            }
            int item = rand.nextInt(listOfWords.size());
            System.out.println("Eto ilay valiny andrasana >>>>>>>>>>>>>");
            System.out.println(listOfWords.get(item)+ "  Tafa");
        }
        System.out.println("-----------------Vita------------------");
    }
}
