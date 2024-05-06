namespace Task1;

internal class Program
{
    static void Main()
    {
        City city = new City();
        city.AddStreet("Тверская", "улица");
        city.AddStreet("Невский", "проспект");
        city.AddStreet("Красная", "площадь");

        city.DisplayStreets();
    }
}
