namespace Task1;

internal class Program
{
    static void Main()
    {
        var path = @"C:\Users\Gygabyte\source\repos\Studies\6 sem\SPP\Lab2\Task1\Text.txt";

        var reader = new StreamReader(path);

        string? temp;
        while ((temp = reader.ReadLine()) != null)
        {
            var lex = temp.Trim().Split(' ', StringSplitOptions.RemoveEmptyEntries);
            Console.WriteLine(string.Join(" ", lex.Reverse()));
        }
    }
}
