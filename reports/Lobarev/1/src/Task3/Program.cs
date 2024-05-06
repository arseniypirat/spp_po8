namespace Task3;

internal class Program
{
    static void Main()
    {
        // Проверка на допустимую длину строки
        var str = RandomString(128, false);
        if (str != null)
        {
            Console.WriteLine(str);
        }
        else
        {
            Console.WriteLine("Ошибка: Строка не была создана.");
        }
    }

    static string RandomString(int length, bool asciiOnly)
    {
        // Проверка на отрицательную длину
        if (length < 0)
        {
            Console.WriteLine("Длина строки не может быть отрицательной.");
            return null;
        }

        int min = 0;
        int max = 255;

        if (asciiOnly)
        {
            min = 0x0021; // Начало печатаемых ASCII символов
            max = 0x007E; // Конец печатаемых ASCII символов
        }



        char[] chars = new char[length];

        var rand = new Random();

        for (int i = 0; i < length; i++)
        {
            char character = (char)rand.Next(min, max + 1);
            chars[i] = character;
        }

        return new string(chars);
    }

}

