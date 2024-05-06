namespace Task2;

class BasicAccountStrategy : IAccountStrategy
{
    public void ShowAccountInfo(string username)
    {
        Console.WriteLine($"Basic Account Info for {username}");
    }

    public void ShowUniqueOffers()
    {
        Console.WriteLine("No unique offers for Basic Account");
    }
}
