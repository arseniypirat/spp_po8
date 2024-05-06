using System;

class Program
{
    static void Main(string[] args)
    {
        int[] numbers = args.Select(s=>int.Parse(s)).ToArray();
               
        int negativeSumOfSquares = SumOfSquaresOfNegatives(numbers);
        Console.WriteLine($"Сумма квадратов отрицательных чисел: {negativeSumOfSquares}");
    }

    static int SumOfSquaresOfNegatives(int[] numbers)
    {
        int sum = 0;

        foreach (var number in numbers)
        {
            if (number < 0)
            {
                sum += number * number;
            }
        }

        return sum;
    }
}