package task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class task01 {

    public static void main(String[] args) throws IOException {

        StringBuilder text = new StringBuilder();
        FileReader reader = new FileReader("src/task01/example.txt");
        BufferedReader br = new BufferedReader(reader);
        String line;

        int lineNumber = 1;
        while ((line = br.readLine()) != null) {
            text.append(line).append("\n");
            lineNumber++;
        }
        br.close();

        Vector<String> vec = new Vector<>();
        StringBuilder wordBuilder = new StringBuilder();
        lineNumber = 1;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                wordBuilder.append(c);
            } else {
                if (wordBuilder.length() > 0) {
                    vec.add(wordBuilder.toString().toLowerCase() + ":" + lineNumber);
                    wordBuilder.setLength(0);
                }
                if (c == '\n') {
                    lineNumber++;
                }
            }
        }
        if (wordBuilder.length() > 0) {
            vec.add(wordBuilder.toString().toLowerCase() + ":" + lineNumber);
        }

        Map<String, Vector<Integer>> wordMap = new HashMap<>();
        for (int i = 0; i < vec.size(); i++) {
            String[] parts = vec.get(i).split(":");
            String word = parts[0];
            int lineNum = Integer.parseInt(parts[1]);
            if (!wordMap.containsKey(word)) {
                wordMap.put(word, new Vector<>());
            }
            wordMap.get(word).add(lineNum);
        }

        for (Map.Entry<String, Vector<Integer>> entry : wordMap.entrySet()) {
            System.out.print(entry.getKey() + " contains in ");
            Vector<Integer> lineNumbers = entry.getValue();
            for (int i = 0; i < lineNumbers.size(); i++) {
                System.out.print(lineNumbers.get(i));
                if (i < lineNumbers.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
