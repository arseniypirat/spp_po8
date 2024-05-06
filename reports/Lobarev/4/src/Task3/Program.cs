namespace Task3;

internal class Program
{
    static void Main()
    {
        // Инициализация каталога
        Catalog catalog = new();
        catalog.AddBook(new Book { Title = "Война и мир", Author = "Л. Толстой", IsAvailable = true });
        catalog.AddBook(new Book { Title = "Преступление и наказание", Author = "Ф. Достоевский", IsAvailable = true });

        // Создание читателя
        Reader reader = new() { Name = "Иван Иванов" };

        // Библиотекарь обрабатывает заказ
        Order? order = Librarian.ProcessOrder(reader, "Война и мир", catalog);

        if (order != null)
        {
            Console.WriteLine($"Книга '{order.Book.Title}' выдана читателю {order.Reader.Name}.");
        }
        else
        {
            Console.WriteLine("Книга не найдена или читатель в черном списке.");
        }

        // Администратор заносит читателя в черный список
        Administrator.BlacklistReader(reader);
    }
}
