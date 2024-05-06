namespace Task2;

class Program
{
    static void Main()
    {
        var basicAccount = new BasicAccountStrategy();
        var premiumAccount = new PremiumAccountStrategy();

        var context = new AccountContext();

        context.SetStrategy(basicAccount);
        context.ShowAccountInfo("user123");
        context.ShowUniqueOffers();

        Console.WriteLine();

        context.SetStrategy(premiumAccount);
        context.ShowAccountInfo("premiumUser");
        context.ShowUniqueOffers();
    }
}
