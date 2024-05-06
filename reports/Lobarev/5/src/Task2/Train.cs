namespace Task2;

class Train : PassengerCarrier
{
    public static decimal FuelCost { get; } = 0.645m; // per hour
    public double Speed { get; }

    public Train(double speed)
    {
        Speed = speed;
    }


    public override TimeSpan CalculateTravelTime(double distance)
    {
        double time = distance / Speed;
        return TimeSpan.FromHours(time);
    }

    public override decimal CalculateCost(TimeSpan time)
    {
        return FuelCost * (decimal)time.TotalHours;
    }
}
