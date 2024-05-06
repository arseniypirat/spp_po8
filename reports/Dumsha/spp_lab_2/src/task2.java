import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.io.IOException;

public class task2 {
    public static StringBuilder buffer = new StringBuilder();

    public static void main(String[] args) {
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.print("> ");
                String command = consoleReader.readLine();

                String[] params = command.split(" ");

                if (!params[0].equals("cat")) {
                    System.out.println("Неизвестная команда!");
                    return;
                }
                boolean greaterEntered = false;
                try {
                    int i = 1;
                    while (i < params.length) {
                        switch (params[i]) {
                            case "-":
                                readFromStdin(consoleReader);

                                break;
                            case ">":
                                if (buffer.isEmpty()) {
                                    readFromStdin(consoleReader);
                                }
                                greaterEntered = true;
                                ++i;
                                writeToFile(params[i]);

                                break;
                            default:
                                readFromFile(params[i]);

                                break;
                        }
                        ++i;
                    }
                } catch (IOException e) {
                    System.out.println("Ошибка: " + e);
                }

                if (!greaterEntered) {
                    System.out.println(buffer);
                }
                buffer.setLength(0);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении из консоли: " + e);
        }
    }

    private static void readFromStdin(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            buffer.append(line).append("\n");
        }
    }

    private static void readFromFile(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                buffer.append(line).append("\n");
            }
        }
    }

    private static void writeToFile(String fileName) throws IOException {
        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write(buffer.toString());
            fw.append('\n');
            fw.flush();
        }
    }
}
