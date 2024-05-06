using System;

class Program
{
    static void Main(string[] args)
    {
        int n = Convert.ToInt32(args[0]);
        double[] arr = new double[n];
        for (int i = 0; i < n; i++)
        {
            arr[i] = Convert.ToDouble(args[i + 1]);
        }
        int index = Convert.ToInt32(args[n + 1]);
        double value = Convert.ToDouble(args[n + 2]);

        arr = Add (arr, index, value);

        foreach (var item in arr)
        {
            Console.Write($"{item} ");
        }

    }
    static double[] Add(double[] arr, int index, double value) 
    {
        double[] doubles = new double[arr.Length + 1];
        int position = 0;
        for (int i = 0;i < arr.Length; i++)
        {
            if (i == index){
                doubles[position] = value;
                position++;
                doubles[position] = arr[i];
                position++;
            }
            else
            {
                doubles[position] = arr[i];
                position++;
            }
        }
        return doubles;
    }

}