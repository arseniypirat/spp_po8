namespace Task3;

class Printer
{
    private IPrinterState _currentState;

    public Printer()
    {
        _currentState = new IdleState();
    }

    public void SetState(IPrinterState state)
    {
        _currentState = state;
    }

    public void Print()
    {
        _currentState.Print();
    }

    public void LoadPaper()
    {
        _currentState.LoadPaper();
    }

    public void ExtractJam()
    {
        _currentState.ExtractJam();
    }

    public void RefillCartridge()
    {
        _currentState.RefillCartridge();
    }
}
