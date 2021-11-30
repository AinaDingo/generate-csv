import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

public class TestReadText {
    @Test
    public void parseText() throws FileNotFoundException, IOException {
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
                        listOfWords.add(words[i].toLowerCase(Locale.ROOT));
                        System.out.print(words[i] + " ");
                        i++;
                }
            }

            Map<String, Integer> wordCount = new HashMap<String, Integer>();
            for(String Word: listOfWords) {
                Integer count = wordCount.get(Word);
                wordCount.put(Word, (count==null) ? 1 : count+1);
            }

            for(Iterator i=wordCount.keySet().iterator();i.hasNext();){
                Object key=i.next();
                System.out.println(key + "=" + wordCount.get(key));
            }
            int item = rand.nextInt(listOfWords.size());
            System.out.println("Random word in ArrayList:  "+listOfWords.get(item));
        }
        System.out.println("-----------------Vita------------------");
    }
}
