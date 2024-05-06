namespace Task3;

public class Catalog
{
    private readonly List<Book> books = [];

    public void AddBook(Book book)
    {
        books.Add(book);
    }

    public Book? FindBook(string title)
    {
        return books.Find(b => b.Title.Equals(title, StringComparison.OrdinalIgnoreCase) && b.IsAvailable);
    }
}
