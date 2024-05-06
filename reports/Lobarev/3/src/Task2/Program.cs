namespace Task2;

internal class Program
{
    static void Main()
    {
        var rentalSystem = new RentalSystem();
        rentalSystem.AddRoom(new Room(3, 70, 5, "123 Main St", 1500, false));
        rentalSystem.AddRoom(new Room(2, 50, 2, "456 Elm St", 1200, true));
        rentalSystem.AddRoom(new Room(1, 30, 1, "789 Oak St", 900, false));

        rentalSystem.DisplayRooms();
    }
}
