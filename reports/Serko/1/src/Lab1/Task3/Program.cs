if (args.Length == 0)
{
    Console.WriteLine("No words passed");
}
else
{
    Console.WriteLine(isAllLowerCase(args[0]));
    Console.ReadLine();
}
bool isAllLowerCase(string word)
{
    if (word.Length == 0)
    {
        return false;
    }
    if (word.ToLower() != word)
    {
        return false;
    }
    return true;
}