namespace Task2;

public class RentalSystem
{
    private List<Room> roomsList = new List<Room>();

    public void AddRoom(Room room)
    {
        roomsList.Add(room);
    }

    public List<Room> GetFreeRooms()
    {
        return roomsList.Where(room => !room.IsRented).ToList();
    }

    public List<Room> GetRentedRooms()
    {
        return roomsList.Where(room => room.IsRented).ToList();
    }

    public Room? FindRoom(int rooms, int floor, double areaTolerance = 10)
    {
        return roomsList.FirstOrDefault(room => room.Rooms == rooms && room.Floor == floor && Math.Abs(room.Area - areaTolerance) <= 10);
    }

    public void RentRoom(Room room)
    {
        room.IsRented = true;
    }

    public void RemoveRoom(Room room)
    {
        roomsList.Remove(room);
    }

    public List<Room> GetRoomsByRoomsCount(int rooms)
    {
        return roomsList.Where(room => room.Rooms == rooms).ToList();
    }

    public List<Room> GetRoomsByFloorRange(int rooms, int minFloor, int maxFloor)
    {
        return roomsList.Where(room => room.Rooms == rooms && room.Floor >= minFloor && room.Floor <= maxFloor).ToList();
    }

    public List<Room> GetRoomsByArea(double area)
    {
        return roomsList.Where(room => room.Area > area).ToList();
    }

    public void DisplayRooms()
    {
        foreach (var room in roomsList)
        {
            Console.WriteLine($"Address: {room.Address}, Rooms: {room.Rooms}, Area: {room.Area}, Floor: {room.Floor}, Rent: {room.RentPrice}, Status: {(room.IsRented ? "Rented" : "Available")}");
        }
    }
}
