using System.Globalization;

namespace Task2;

internal class Program
{
    static void Main()
    {
        CultureInfo.CurrentCulture = new CultureInfo("en-US");

        PassengerCarrier[] carriers =
        [
            new Airplane(900),
            new Train(90),
            new Car(60)
        ];

        var distance = 1000d;

        foreach (var carrier in carriers)
        {
            var travelTime = carrier.CalculateTravelTime(distance);
            var cost = carrier.CalculateCost(travelTime);
            Console.WriteLine($"Travel time: {travelTime}, Cost: {cost:C}");
        }
    }
}
