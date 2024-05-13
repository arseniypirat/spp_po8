import java.io.*;
import java.nio.file.*;

public class Split {
    private static final int DEFAULT_CHUNK_SIZE = 10;
    private static final String DEFAULT_OUTPUT_PREFIX = "x";
    private static final String DEFAULT_INPUT_FILE = "-";
    private static final boolean DEFAULT_NUMERIC_SUFFIXES = false;

    public static void splitFile(String inputFile, String outputPrefix, int chunkSize, boolean numericSuffixes) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputFile))) {
            char[] buffer = new char[chunkSize];
            int bytesRead;
            int fileCount = 0;

            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPrefix + getSuffix(fileCount, numericSuffixes)));

            while ((bytesRead = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, bytesRead);

                if (bytesRead == chunkSize) {
                    writer.close();
                    fileCount++;
                    writer = new BufferedWriter(new FileWriter(outputPrefix + getSuffix(fileCount, numericSuffixes)));
                }
            }

            writer.close();
        }
    }
    private static String getSuffix(int fileCount, boolean numericSuffixes) {
        return numericSuffixes ? String.format("%02d", fileCount) : String.valueOf((char) ('a' + fileCount));
    }

    public static void main(String[] args) {
        String inputFile = DEFAULT_INPUT_FILE;
        String outputPrefix = DEFAULT_OUTPUT_PREFIX;
        int chunkSize = DEFAULT_CHUNK_SIZE;
        boolean numericSuffixes = DEFAULT_NUMERIC_SUFFIXES;

        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("-l")) {
                chunkSize = Integer.parseInt(args[i].substring(2));
            } else if (args[i].startsWith("-b")) {
                String sizeStr = args[i].substring(2);
                int multiplier = 1;

                if (sizeStr.endsWith("k")) {
                    multiplier = 1024;
                    sizeStr = sizeStr.substring(0, sizeStr.length() - 1);
                } else if (sizeStr.endsWith("m")) {
                    multiplier = 1024 * 1024;
                    sizeStr = sizeStr.substring(0, sizeStr.length() - 1);
                }

                chunkSize = Integer.parseInt(sizeStr) * multiplier;
            } else if (args[i].equals("-d")) {
                numericSuffixes = true;
            } else if (!args[i].startsWith("-")) {
                if (inputFile.equals(DEFAULT_INPUT_FILE)) {
                    inputFile = args[i];
                } else {
                    outputPrefix = args[i];
                }
            }
        }

        try {
            splitFile(inputFile, outputPrefix, chunkSize, numericSuffixes);
        } catch (IOException e) {
            System.err.println("Ошибка при разделении файла: " + e.getMessage());
        }
    }
}
