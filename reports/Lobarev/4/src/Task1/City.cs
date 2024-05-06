namespace Task1;

internal class City
{
    private List<Street> streets = new List<Street>();

    public class Street
    {
        public string Name { get; set; }
        public string Type { get; set; } // Тип, например: "улица", "проспект", "площадь"

        public Street(string name, string type)
        {
            Name = name;
            Type = type;
        }
    }

    public void AddStreet(string name, string type)
    {
        streets.Add(new Street(name, type));
    }

    public void DisplayStreets()
    {
        foreach (var street in streets)
        {
            Console.WriteLine($"Название: {street.Name}, Тип: {street.Type}");
        }
    }
}
