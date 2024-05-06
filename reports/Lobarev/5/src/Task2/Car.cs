namespace Task2;

class Car : PassengerCarrier
{
    public static decimal FuelCost { get; } = 0.245m; // per hour
    public double Speed { get; }

    public Car(double speed)
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
