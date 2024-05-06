namespace Task2;

public class Page
{
    private List<Word> words = new List<Word>();

    public void AddWord(Word word)
    {
        words.Add(word);
    }

    public void PrintWords()
    {
        foreach (var word in words)
        {
            Console.Write(word.Value + " ");
        }
        Console.WriteLine();
    }
}
