namespace Task2;

class Airplane : PassengerCarrier
{
    public static decimal FuelCost { get; } = 1.845m; // per hour
    public double Speed { get; }

    public Airplane(double speed)
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
