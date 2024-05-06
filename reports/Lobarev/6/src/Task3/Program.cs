namespace Task3;

class Program
{
    static void Main()
    {
        var printer = new Printer();

        printer.LoadPaper();
        printer.Print();
        printer.ExtractJam();
        printer.RefillCartridge();
    }
}
