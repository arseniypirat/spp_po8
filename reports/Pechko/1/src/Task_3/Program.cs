using System;

class Program
{
    static void Main(string[] args)
    {

        char ch = args[0][0];

        int repeat = Convert.ToInt32(args[1]);

        string result = Repeat(ch, repeat);

        Console.WriteLine($"\nРезультат: {result}");
    }

    static string Repeat(char ch, int repeat)
    {
        if (repeat < 0)
        {
            return "";
        }

        return new string(ch, repeat);
    }
}