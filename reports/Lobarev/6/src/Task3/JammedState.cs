namespace Task3;

class JammedState : IPrinterState
{
    public void Print()
    {
        Console.WriteLine("Cannot print due to paper jam.");
    }

    public void LoadPaper()
    {
        Console.WriteLine("Cannot load paper while jammed.");
    }

    public void ExtractJam()
    {
        Console.WriteLine("Extracting paper jam...");
    }

    public void RefillCartridge()
    {
        Console.WriteLine("Cannot refill cartridge while jammed.");
    }
}
