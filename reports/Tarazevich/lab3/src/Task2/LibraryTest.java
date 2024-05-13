package Task2;

public class LibraryTest {
    public static void main(String[] args) throws Exception {
        Library library = new Library();
        Book book1 = new Book("123", "Nikiat",
                "Книга1",
                2010, 666, 1, 1);
        Book book2 = new Book("321", "Nikita",
                "Книга2",
                2015, 666, 3, 2);
        Book book3 = new Book("213", "Nitika",
                "Книга3",
                2020, 666, 6, 1);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        System.out.println("All books:");
        for (Book bk : library.getAllBooks()){
            System.out.println(bk);
        }

        System.out.println("\nBooks on loan:");
        library.borrowBook(book1, "Kir");
        for (Book bk : library.getBooksOnLoan()){
            System.out.println(bk);
        }

        System.out.println("\nBooks older then 5 years:");
        for (Book bk : library.getBooksOlderThan(5)){
            System.out.println(bk);
        }
    }
}
