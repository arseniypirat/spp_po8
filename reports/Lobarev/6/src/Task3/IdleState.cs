namespace Task3;

class IdleState : IPrinterState
{
    public void Print()
    {
        Console.WriteLine("Printer is idle. Please select a document to print.");
    }

    public void LoadPaper()
    {
        Console.WriteLine("Loading paper...");
    }

    public void ExtractJam()
    {
        Console.WriteLine("No paper jam detected.");
    }

    public void RefillCartridge()
    {
        Console.WriteLine("Cartridge is already full.");
    }
}
