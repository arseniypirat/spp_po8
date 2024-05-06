import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

class CreateDictionaryFile {
    public static void main(String[] args) {
        List<String> lines = Arrays.asList(
                "hello,привет,10",
                "world,мир,20",
                "java,ява,30");

        try {
            Files.write(Paths.get("dictionary.txt"), lines, StandardCharsets.UTF_8);
            System.out.println("File created successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}

class WordEntry {
    String russianWord;
    int count;

    WordEntry(String russianWord, int count) {
        this.russianWord = russianWord;
        this.count = count;
    }
}

class DictionaryApp {
    private static TreeMap<String, WordEntry> dictionaryByWord = new TreeMap<>();
    private static TreeMap<WordEntry, String> dictionaryByCount = new TreeMap<>((a, b) -> b.count - a.count);

    public static void main(String[] args) {
        loadDictionary("dictionary.txt");
        printDictionaryByWord();
        printDictionaryByCount();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter command (add, remove, search, exit):");
            String command = scanner.nextLine();
            switch (command) {
                case "add":
                    addWord(scanner);
                    break;
                case "remove":
                    removeWord(scanner);
                    break;
                case "search":
                    searchWord(scanner);
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Invalid command");
            }
        }
    }

    private static void loadDictionary(String filename) {
        try {
            Path path = Paths.get(filename);
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            for (String line : lines) {
                String[] parts = line.split(",");
                String englishWord = parts[0];
                String russianWord = parts[1];
                int count = Integer.parseInt(parts[2]);
                dictionaryByWord.put(englishWord, new WordEntry(russianWord, count));
                dictionaryByCount.put(new WordEntry(russianWord, count), englishWord);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static void printDictionaryByWord() {
        System.out.println("Dictionary by word:");
        for (Map.Entry<String, WordEntry> entry : dictionaryByWord.entrySet()) {
            System.out.println(
                    entry.getKey() + " - " + entry.getValue().russianWord + " (" + entry.getValue().count + ")");
        }
    }

    private static void printDictionaryByCount() {
        System.out.println("Dictionary by count:");
        for (Map.Entry<WordEntry, String> entry : dictionaryByCount.entrySet()) {
            System.out
                    .println(entry.getValue() + " - " + entry.getKey().russianWord + " (" + entry.getKey().count + ")");
        }
    }

    private static void addWord(Scanner scanner) {
        System.out.print("Enter English word: ");
        String englishWord = scanner.nextLine();
        System.out.print("Enter Russian word: ");
        String russianWord = scanner.nextLine();
        System.out.print("Enter count: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // consume newline character

        WordEntry wordEntry = new WordEntry(russianWord, count);

        dictionaryByWord.put(englishWord, wordEntry);
        dictionaryByCount.put(wordEntry, englishWord);
    }

    private static void removeWord(Scanner scanner) {
        System.out.print("Enter English word to remove: ");
        String englishWord = scanner.nextLine();

        if (dictionaryByWord.containsKey(englishWord)) {
            WordEntry wordEntry = dictionaryByWord.get(englishWord);
            dictionaryByWord.remove(englishWord);
            dictionaryByCount.remove(wordEntry);
        } else {
            System.out.println("Word not found");
        }
    }

    private static void searchWord(Scanner scanner) {
        System.out.println("Enter English word:");
        String englishWord = scanner.nextLine();
        if (dictionaryByWord.containsKey(englishWord)) {
            WordEntry entry = dictionaryByWord.get(englishWord);
            System.out.println("Russian word: " + new String(entry.russianWord.getBytes(), StandardCharsets.UTF_8));
            System.out.println("Count: " + entry.count);
        } else {
            System.out.println("Word not found");
        }
    }

}
