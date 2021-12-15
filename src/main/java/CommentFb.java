import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CommentFb {
    public static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public static LocalDate createRandomDate(int startYear, int endYear) {
        int day = createRandomIntBetween(15, 28);
        int month = createRandomIntBetween(11, 11);
        int year = createRandomIntBetween(startYear, endYear);
        return LocalDate.of(year, month, day);
    }

    public static void main(String[]args) throws IOException {
        ReadText readText= new ReadText();
        Random rand = new Random();
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File("C:\\Users\\Inclusiv Academy16\\Desktop\\Asa\\FbComment.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //-----------------Begin add name---------------------//
        BufferedReader bufReader = new BufferedReader(new FileReader("C:\\Users\\Inclusiv Academy16\\Desktop\\Nom.txt"));
        ArrayList<String> listOfLines = new ArrayList<>();
        String line = bufReader.readLine();
        StringBuilder builder = new StringBuilder();
        while (line != null) {
            listOfLines.add(line);
            line = bufReader.readLine();
        }
        bufReader.close();
        //-----------------end add name---------------------//

        //-----------------Begin add text---------------------//
        ArrayList<String> result = new ArrayList<>();
        Scanner s = new Scanner(new FileReader("C:\\Users\\Inclusiv Academy16\\Desktop\\NewData.txt"));
        while (s.hasNext()) {
            result.add(s.nextLine());
        }
        s.close();;
        //-----------------end add text---------------------//
        String columnNamesList = "ACCOUNT,ACCOUNT_ID,COMMENT_TEXT,COMMENT_ID,DATE,LIKE,LOVE,CARE,DISLIKE,REPLYS";
        // No need give the headers Like: id, Name on builder.append;
        int upperbound = 300;
        int id = 9;
        builder.append(columnNamesList +"\n");
        for (int i= 0; i<=1000; i++){
            LocalDate randomDate = createRandomDate(2021, 2021);
            int item = rand.nextInt(result.size());
            int index = rand.nextInt(listOfLines.size());
            builder.append(listOfLines.get(index)+",");
            builder.append(rand.nextInt(id)+""+rand.nextInt(id)+""+rand.nextInt(id)+rand.nextInt(id)+""+rand.nextInt(id)+""+rand.nextInt(id)+""+rand.nextInt(id)+""+rand.nextInt(id)+",");
            builder.append(result.get(item)+",");
            builder.append(rand.nextInt(id)+""+rand.nextInt(id)+""+rand.nextInt(id)+rand.nextInt(id)+""+rand.nextInt(id)+""+rand.nextInt(id)+""+rand.nextInt(id)+""+rand.nextInt(id)+",");
            builder.append(randomDate+",");
            builder.append(rand.nextInt(upperbound)+",");
            builder.append(rand.nextInt(upperbound)+",");
            builder.append(rand.nextInt(upperbound)+",");
            builder.append(rand.nextInt(upperbound)+",");
            builder.append(rand.nextInt(upperbound));

            builder.append('\n');
        }
        pw.write(builder.toString());
        pw.close();
        System.out.println("done!");
    }
}
