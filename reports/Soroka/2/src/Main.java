import java.io.*;
import java.util.*;

public class Main
{
    public static void randomizeText(String text)
    {
        String[] lines = text.split("\n"); // Разбиваем текст на строки

        for (String line : lines)
        {
            // Разбиваем строку на слова
            List<String> words = new ArrayList<>(Arrays.asList(line.split(" ")));
            Random random = new Random();

            // Перемешиваем порядок слов
            for (int i = words.size() - 1; i > 0; i--)
            {
                int j = random.nextInt(i + 1);
                String temp = words.get(i);
                words.set(i, words.get(j));
                words.set(j, temp);
            }
            // Выводим строку с новым порядком слов
            System.out.println(String.join(" ", words));
        }
    }

    public static void runNlCommand(String nlArgs)
    {
        String[] args = nlArgs.split(" ");
        String inputFile = args[args.length - 1];
        String outputFile = "";
        int step = 1;
        boolean emptyLineNumbering = true;
        String numberingFormat = "ln";

        if (inputFile.equals("-"))
        {
            inputFile = "./src/stdin.txt";
            writeInputToTempFile(inputFile);
        }

        // Указываем абсолютный путь к файлу in.txt
        inputFile = "./src/in.txt";
        for (int i = 0; i < args.length - 1; i++)
        {
            switch (args[i])
            {
                case "-i":
                    step = Integer.parseInt(args[i + 1]);
                    break;
                case "-l":
                    emptyLineNumbering = args[i + 1].equals("1");
                    break;
                case "-n":
                    numberingFormat = args[i + 1];
                    break;
            }
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null)
            {
                if (!line.trim().isEmpty() || emptyLineNumbering)
                {
                    String formattedLineNumber = formatLineNumber(lineNumber, numberingFormat);
                    System.out.println(formattedLineNumber + " " + line);
                    lineNumber += step;
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    public static void writeInputToTempFile(String fileName)
    {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            Scanner scanner = new Scanner(System.in);
            String line;

            while (!(line = scanner.nextLine()).isEmpty())
            {
                writer.write(line);
                writer.newLine();
            }
            writer.close();
            scanner.close();
        } catch (IOException e) {
            System.out.println("Ошибка при записи входных данных: " + e.getMessage());
        }
    }

    public static String formatLineNumber(int number, String format)
    {
        switch (format)
        {
            case "ln":
                return String.valueOf(number);
            case "rn":
                return String.valueOf(number).trim();
            case "rz":
                return String.format("%02d", number);
            default:
                return String.valueOf(number);
        }
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int choice = 0;
        String input = "";

        while (choice != 3)
        {
            while (true) {

                System.out.println("1. Задание 1\n2. Задание 2\n3. Выход\n");
                System.out.print("Выберите необходимое:  ");
                input = in.nextLine();

                // Проверка, что введено только одно целое число
                if (input.matches("^\\d+$")) {
                    choice = Integer.parseInt(input);
                    if (choice >= 1 && choice <= 3) {
                        break; // Выбор корректен, выходим из цикла
                    }
                }
                System.out.println("Неверный ввод! Введите только одно число от 1 до 3.\n");
            }

            switch (choice)
            {
                case 1:
                    System.out.println("\n=========================================");
                    System.out.println("Введите текст для изменения порядка слов: ");
                    input = in.nextLine();
                    System.out.println("\nСтроки с новым порядком слов: ");
                    randomizeText(input);
                    System.out.println("=========================================\n");
                    break;

                case 2:
                    System.out.println("\n=========================================");
                    System.out.println("Введите аргументы для команды nl (пример: -i 2 -l 0 -n ln in.txt): ");
                    input = in.nextLine();
                    runNlCommand(input);
                    System.out.println("=========================================\n");
                    break;

                case 3:
                    System.out.println("Завершение работы...");
                    break;

                default:
                    System.out.println("Неверное значение!\n");
            }
        }
    }
}
