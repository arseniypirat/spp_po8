using System.Globalization;

namespace Task1;

internal class Program
{
    static void Main()
    {
        CultureInfo.CurrentCulture = CultureInfo.InvariantCulture;

        var set1 = new RealNumberSet(5);
        set1.Add(1.1);
        set1.Add(2.2);
        set1.Add(3.3);

        var set2 = new RealNumberSet(5);
        set2.Add(4.4);
        set2.Add(5.5);
        set2.Add(3.3);

        var unionSet = set1.Union(set2);
        unionSet.Print(); // Выведет 1.1 2.2 3.3 4.4 5.5

        Console.WriteLine(set1.Contains(2.2)); // Выведет true
        Console.WriteLine(set1.Contains(6.6)); // Выведет false

        set1.Remove(2.2);
        set1.Print(); // Выведет 1.1 3.3
    }
}
