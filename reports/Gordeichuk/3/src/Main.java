import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Объединение множеств");
            System.out.println("2. Проверка принадлежности элемента первому множеству");
            System.out.println("3. Удаление элемента из первого множества");
            System.out.println("4. Вывод множеств на экран");
            System.out.println("5. Выйти из программы");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    performUnion(scanner);
                    break;
                case 2:
                    performContainsCheck(scanner);
                    break;
                case 3:
                    performRemoval(scanner);
                    break;
                case 4:
                    printSets(scanner);
                    break;
                case 5:
                    System.out.println("Программа завершена.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Некорректный выбор.");
            }
        }
    }

    private static void performUnion(Scanner scanner) {
        System.out.println("Введите мощность первого множества: ");
        int capacity1 = scanner.nextInt();
        SymbolSet set1 = new SymbolSet(capacity1);

        System.out.println("Введите элементы первого множества:");
        for (int i = 0; i < capacity1; i++) {
            char element = scanner.next().charAt(0);
            set1.add(element);
        }

        System.out.println("Введите мощность второго множества: ");
        int capacity2 = scanner.nextInt();
        SymbolSet set2 = new SymbolSet(capacity2);

        System.out.println("Введите элементы второго множества:");
        for (int i = 0; i < capacity2; i++) {
            char element = scanner.next().charAt(0);
            set2.add(element);
        }

        SymbolSet unionSet = set1.union(set2);
        System.out.println("Объединение множеств: " + unionSet);
    }

    private static void performContainsCheck(Scanner scanner) {
        System.out.println("Введите элементы множества для проверки:");
        int capacity = scanner.nextInt();
        SymbolSet set = new SymbolSet(capacity);

        System.out.println("Введите элементы множества:");
        for (int i = 0; i < capacity; i++) {
            char element = scanner.next().charAt(0);
            set.add(element);
        }

        System.out.print("Введите элемент для проверки принадлежности множеству: ");
        char element = scanner.next().charAt(0);
        System.out.println("Принадлежит ли элемент множеству: " + set.contains(element));
    }

    private static void performRemoval(Scanner scanner) {
        System.out.println("Введите мощность множества:");
        int capacity = scanner.nextInt();
        SymbolSet set = new SymbolSet(capacity);

        System.out.println("Введите элементы множества:");
        for (int i = 0; i < capacity; i++) {
            char element = scanner.next().charAt(0);
            set.add(element);
        }

        System.out.print("Введите элемент для удаления из множества: ");
        char elementToRemove = scanner.next().charAt(0);
        set.remove(elementToRemove);
        System.out.println("Множество после удаления элемента: " + set);
    }

    private static void printSets(Scanner scanner) {
        System.out.println("Введите элементы первого множества (через пробел): ");
        String input1 = scanner.nextLine();
        char[] elements1 = input1.toCharArray();
        SymbolSet set1 = new SymbolSet(elements1);

        System.out.println("Введите элементы второго множества (через пробел): ");
        String input2 = scanner.nextLine();
        char[] elements2 = input2.toCharArray();
        SymbolSet set2 = new SymbolSet(elements2);

        System.out.println("Первое множество: " + set1);
        System.out.println("Второе множество: " + set2);
    }
}
