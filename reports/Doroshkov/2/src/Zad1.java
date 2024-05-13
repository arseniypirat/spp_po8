import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Zad1 {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new FileReader("text.txt"));)
        {
            String buff;
            StringBuilder lineBuilder = new StringBuilder();
            String punctuationMarks = "[!—?:;'/,.]";
            while ((buff = reader.readLine()) != null) {
                System.out.println(buff);
                lineBuilder.append(buff);
            }
            String line = lineBuilder.toString().replaceAll(punctuationMarks, " ");
            System.out.println(line);
            String[] words = line.split("\\s+");
            int countMarks;
            Map<Integer, Integer> map = new HashMap<>();
            for (String word : words){
                countMarks = word.length();
                if (map.containsKey(countMarks)) {
                    map.put(countMarks, map.get(countMarks) + 1);
                } else {
                    map.put(countMarks, 1);
                }
            }
            System.out.println("Длина слова | Количество");
            System.out.println("------------------------");
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                System.out.printf("%-12d| %-10d\n", entry.getKey(), entry.getValue());
            }

        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
