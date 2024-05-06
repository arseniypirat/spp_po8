namespace Task2;

abstract class PassengerCarrier
{
    public abstract TimeSpan CalculateTravelTime(double distance);
    public abstract decimal CalculateCost(TimeSpan time);
}
