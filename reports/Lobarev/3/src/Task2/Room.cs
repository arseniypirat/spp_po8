namespace Task2;

public class Room
{
    public int Rooms { get; set; }
    public double Area { get; set; }
    public int Floor { get; set; }
    public string Address { get; set; }
    public double RentPrice { get; set; }
    public bool IsRented { get; set; }

    public Room(int rooms, double area, int floor, string address, double rentPrice, bool isRented)
    {
        Rooms = rooms;
        Area = area;
        Floor = floor;
        Address = address;
        RentPrice = rentPrice;
        IsRented = isRented;
    }
}