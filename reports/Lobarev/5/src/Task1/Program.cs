namespace Task1;

internal class Program
{
    static void Main()
    {
        Engineer engineer = new();
        Manager manager = new();

        engineer.DoWork();
        manager.DoWork();
        manager.Manage();
    }
}

