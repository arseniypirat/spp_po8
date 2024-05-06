namespace Task2;

// Контекст (класс, использующий стратегии)
class AccountContext
{
    private IAccountStrategy _strategy;

    public void SetStrategy(IAccountStrategy strategy)
    {
        _strategy = strategy;
    }

    public void ShowAccountInfo(string username)
    {
        _strategy.ShowAccountInfo(username);
    }

    public void ShowUniqueOffers()
    {
        _strategy.ShowUniqueOffers();
    }
}
