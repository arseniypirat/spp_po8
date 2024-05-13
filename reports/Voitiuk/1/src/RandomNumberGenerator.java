import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Пожалуйста, введите число как аргумент командной строки.");
            return;
        }

        int n = Integer.parseInt(args[0]);

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        // Перемешиваем числа в рандомном порядке
        Collections.shuffle(numbers);

        System.out.println("Случайные числа:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
