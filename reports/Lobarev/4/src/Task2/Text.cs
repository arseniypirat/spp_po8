namespace Task2;

public class Text
{
    private List<Page> pages = new List<Page>();

    public void AddPage(Page page)
    {
        pages.Add(page);
    }

    public void PrintText()
    {
        foreach (var page in pages)
        {
            page.PrintWords();
            Console.WriteLine("--- Страница завершена ---");
        }
    }
}
