namespace Task3;

class PrintingState : IPrinterState
{
    public void Print()
    {
        Console.WriteLine("Printing document...");
    }

    public void LoadPaper()
    {
        Console.WriteLine("Cannot load paper while printing.");
    }

    public void ExtractJam()
    {
        Console.WriteLine("Cannot extract jam while printing.");
    }

    public void RefillCartridge()
    {
        Console.WriteLine("Cannot refill cartridge while printing.");
    }
}
