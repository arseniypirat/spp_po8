import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class FileSorter {
    public static void main(String[] args) {
        String fileName = "input.txt"; // имя файла для чтения
        List<String> lines = readLines(fileName);
        sortAndPrintLines(lines);
    }

    private static List<String> readLines(String fileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
        return lines;
    }

    private static void sortAndPrintLines(List<String> lines) {
        Collections.sort(lines, Comparator.comparingInt(String::length));
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
