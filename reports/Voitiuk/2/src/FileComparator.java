import java.io.*;
import java.nio.file.*;

public class FileComparator {
    public static void main(String[] args) {
        Path filePath1 = Paths.get("file1.txt");
        Path filePath2 = Paths.get("file2.txt");

        try (BufferedReader reader1 = Files.newBufferedReader(filePath1);
             BufferedReader reader2 = Files.newBufferedReader(filePath2)) {

            String line1 = reader1.readLine();
            String line2 = reader2.readLine();
            int lineNum = 1;
            boolean areFilesEquivalent = true;

            while (line1 != null || line2 != null) {
                if (!line1.equals(line2)) {
                    for (int i = 0; i < Math.min(line1.length(), line2.length()); i++) {
                        if (line1.charAt(i) != line2.charAt(i)) {
                            System.out.println("Files differ at line " + lineNum + ", position " + (i+1));
                            System.out.println("Character in file1: " + line1.charAt(i) + ", Character in file2: " + line2.charAt(i));
                            areFilesEquivalent = false;
                        }
                    }
                    if (line1.length() != line2.length()) {
                        System.out.println("Files differ at line " + lineNum);
                        areFilesEquivalent = false;
                    }
                }
                line1 = reader1.readLine();
                line2 = reader2.readLine();
                lineNum++;
            }
            if (areFilesEquivalent) {
                System.out.println("The contents of the files are equivalent.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
