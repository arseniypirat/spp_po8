namespace Task1;

internal class Program
{
    static void Main()
    {
        Foo(1, 2, 3, 4, 5);
    }

    static void Foo(params int[] ints)
    {
        if (ints == null || ints.Length == 0)
        {
            Console.WriteLine("Массив не может быть пустым или равным null.");
            return;
        }

        int min = ints.Min();
        int max = ints.Max();

        int sum = ints.Sum();
        long product = 1;
        foreach (var number in ints)
        {
            // Проверка на переполнение
            if (number > Int32.MaxValue / product)
            {
                Console.WriteLine("Ошибка: переполнение при вычислении произведения.");
                return;
            }
            product *= number;
        }

        Console.WriteLine($"Min: {min}");
        Console.WriteLine($"Max: {max}");

        Console.WriteLine($"Sum: {sum}");
        Console.WriteLine($"Product: {product}");
    }
}

