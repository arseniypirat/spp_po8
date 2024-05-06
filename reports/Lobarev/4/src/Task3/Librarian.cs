namespace Task3;

public class Librarian
{
    public static Order? ProcessOrder(Reader reader, string bookTitle, Catalog catalog)
    {
        Book? book = catalog.FindBook(bookTitle);
        if (book != null && !reader.IsBlacklisted)
        {
            book.IsAvailable = false;
            return new Order { Book = book, Reader = reader };
        }
        return null;
    }
}
