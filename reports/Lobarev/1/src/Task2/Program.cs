namespace Task2;

internal class Program
{
    static void Main()
    {
        var arr = new long[] { 1, 2, 3, 4, 5 };

        // Проверка на null и пустой массив
        if (arr == null || arr.Length == 0)
        {
            Console.WriteLine("Массив не может быть пустым или равным null.");
            return;
        }

        var res = RemoveElement(arr, 5);

        // Проверка на null результата
        if (res != null)
        {
            Console.WriteLine(string.Join(", ", res));
        }
        else
        {
            Console.WriteLine("Элемент для удаления не найден.");
        }
    }

    static long[] RemoveElement(long[] array, long element)
    {
        for (int i = 0; i < array.Length; i++)
        {
            if (array[i] == element)
            {
                long[] newArray = new long[array.Length - 1];
                if (newArray == null)
                {
                    Console.WriteLine("Ошибка при создании нового массива.");
                    return null;
                }

                int index = 0;
                for (int j = 0; j < array.Length; j++)
                {
                    if (i == j) continue;
                    newArray[index++] = array[j];
                }

                return newArray;
            }
        }

        // Возвращаем исходный массив, если элемент не найден
        Console.WriteLine("Указанный элемент не найден в массиве.");
        return array;
    }
}

