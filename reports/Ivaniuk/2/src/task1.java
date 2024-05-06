package Lab2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;

public class task1 {
    public static void main(String[] args) {
        final String PATH = "C:/Users/proro/OneDrive/Рабочий стол/testFile.txt";

        File file = new File(PATH);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder text = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.replaceAll("[,.!?:;]", "").split(" ");
                for (int i = 0; i < words.length; i++) {
                    words[i] = shuffleWord(words[i]);
                }
                text.append(String.join(" ", words)).append("\n");
            }
            System.out.println("Измененный текст:");
            System.out.println(text);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }

    public static String shuffleWord(String word) {
        char[] chars = word.toCharArray();
        Random rnd = new Random();
        for (int i = chars.length - 1; i >= 1; i--) {
            int newIndex = rnd.nextInt(i + 1);
            char tmp = chars[newIndex];
            chars[newIndex] = chars[i];
            chars[i] = tmp;
        }
        return new String(chars);
    }
}








