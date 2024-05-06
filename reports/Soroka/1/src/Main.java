import java.util.*;

public class Main
{
    public static void printResult(int[] array)
    {
        Map<Integer, Integer> uniqueNumbers = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++)
        {
            if (uniqueNumbers.containsKey(array[i]))
            {
                uniqueNumbers.put(array[i], uniqueNumbers.get(array[i]) + 1);
            } else {
                uniqueNumbers.put(array[i], 1);
            }
        }
        System.out.println("Уникальные числа:");
        for (Map.Entry<Integer, Integer> item : uniqueNumbers.entrySet())
        {
            if (item.getValue() == 1)
            {
                System.out.print(item.getKey() + " ");
            }
        }
    }

    public static double[][] createIdentityMatrix(int size)
    {
        double[][] matrix = new double[size][size];
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                if (i == j)
                {
                    matrix[i][j] = 1.0;
                } else {
                    matrix[i][j] = 0.0;
                }
            }
        }
        return matrix;
    }


    public static String capitalize(String str)
    {
        if (str == null) {
            return null;
        }
        if (str.equalsIgnoreCase("null")) {
            return str;
        }
        if (str.isEmpty()) {
            return "";
        }
        String[] words = str.trim().split(" ");
        StringBuilder capitalizedStr = new StringBuilder();
        for (String word : words) {
            if (word != null && !word.isEmpty()) {
                char firstChar = Character.toUpperCase(word.charAt(0));
                String restOfWord = word.substring(1);
                String capitalizedWord = firstChar + restOfWord;
                capitalizedStr.append(capitalizedWord).append(" ");
            }
        }
        return capitalizedStr.toString().trim();
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("1. Задание 1\n2. Задание 2\n3. Задание 3\n4. Выход\n");
            System.out.print("Выберите необходимое:  ");

            // Проверка наличия целого числа во входных данных
            while (!in.hasNextInt())
            {
                System.out.println("Неверный ввод! Введите число от 1 до 4.\n");
                in.next(); // Пропускаем текущий ввод
                System.out.println("1. Задание 1\n2. Задание 2\n3. Задание 3\n4. Выход\n");
                System.out.print("Выберите необходимое:  ");
            }
            choice = in.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.print("\n=====================================\n");
                    Random rand = new Random();
                    int[] array = new int[5];
                    for (int i = 0; i < 5; i++)
                    {
                        array[i] = rand.nextInt(10) + 1;
                    }
                    System.out.println("Исходный массив:\n" + Arrays.toString(array));
                    printResult(array);
                    System.out.print("\n=====================================\n\n");
                    break;

                case 2:
                    System.out.print("\n=====================================\n");
                    int size;
                    while (true)
                    {
                        System.out.print("Введите размер единичной матрицы: ");
                        size = in.nextInt();
                        // Проверка на отрицательные числа, 0 и числа не более 20
                        if (size <= 0 || size > 20)
                        {
                            System.out.println("Размер единичной матрицы должен быть положительным и не превышать 20. Повторите ввод.\n");
                            continue;
                        }
                        break;
                    }
                    double[][] matrix = createIdentityMatrix(size);
                    System.out.println("Единичная матрица:\n");
                    for (int i = 0; i < size; i++)
                    {
                        for (int j = 0; j < size; j++)
                        {
                            System.out.print(matrix[i][j] + " ");
                        }
                        System.out.println();
                    }
                    System.out.print("\n=====================================\n\n");
                    break;

                case 3:
                    System.out.print("\n=====================================\n");
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Введите строку: ");
                    String str = scanner.nextLine();
                    String capitalizedStr = capitalize(str.trim());
                    System.out.println("Капитализированная строка: " + capitalizedStr);
                    System.out.print("\n=====================================\n\n");
                    break;

                case 4:
                    System.out.println("Завершение работы...");
                    break;

                default:
                    System.out.println("Неверное значение!\n");
            }
        } while (choice != 4);
    }
}