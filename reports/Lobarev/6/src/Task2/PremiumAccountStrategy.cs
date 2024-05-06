namespace Task2;

class PremiumAccountStrategy : IAccountStrategy
{
    public void ShowAccountInfo(string username)
    {
        Console.WriteLine($"Premium Account Info for {username}");
    }

    public void ShowUniqueOffers()
    {
        Console.WriteLine("Access to premium book previews and exclusive discounts");
    }
}
