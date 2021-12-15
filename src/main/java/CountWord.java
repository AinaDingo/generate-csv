import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class CountWord {
    public static void main(String[] args){
        HashMap<String, Integer> hashMap = new HashMap<String,Integer>();
        BufferedReader reader = null;
        Random rand = new Random();
        try{
            reader = new BufferedReader(new FileReader("C:\\Users\\Inclusiv Academy16\\Desktop\\NewData.txt"));
            String currentLine = reader.readLine();
            while (currentLine != null){
                String words[] = currentLine.toLowerCase().split(" ");
                for (String word:words){
                    if (word != "ny" || word != "fa") {
                        if (hashMap.containsKey(word)) {
                            hashMap.put(word, hashMap.get(word) + 1);
                        } else {
                            hashMap.put(word, 1);
                        }
                    }
                }
                currentLine= reader.readLine();
                int item = rand.nextInt(words.length);
                System.out.println(hashMap.containsKey(item));
            }
            String repeated = null;
            int count=0;
            Set<Map.Entry<String, Integer>> entrySet=hashMap.entrySet();
            for (Map.Entry<String, Integer> entry:entrySet){
                if (entry.getKey() != "ny" || entry.getKey() != "fa"){

                    if(entry.getValue()>count){
                        repeated=entry.getKey();
                        count=entry.getValue();
                    }
                }

            }
            System.out.println("The most repeated word is: " + repeated);
            System.out.println("nombre apparition: "+ count);
        }
        catch (IOException e){
            System.out.println("Ato ilay olana>>>>: "+ e.getMessage());
        }
        System.out.println("vita");
    }
}
