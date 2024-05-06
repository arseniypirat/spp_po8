import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Task1 {
    public static void main(String[] args) {
        String filename = "file.txt";
        Set<String> dict = new HashSet<>();
        StringBuilder result = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("[,.!?\\s]+");
                boolean isSpaceNeeded = false;
                for (String word : words) {
                    if (!dict.contains(word)) {
                        dict.add(word);
                        result.append(word).append(" ");
                        isSpaceNeeded = true;
                    }
                }

                if (isSpaceNeeded) {
                    result.append("\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка" + e);
        }

        System.out.println(result);
    }
}