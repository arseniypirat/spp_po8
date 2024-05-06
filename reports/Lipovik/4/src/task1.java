public class task1 {
    public static void main(String[] args) {
        Catalog catalog=new Catalog();
        catalog.addBook(new Catalog.issueInformation("a","a reader","24.12.2024"));
        catalog.addBook(new Catalog.issueInformation("b","b reader","24.11.2024"));
        catalog.addBook(new Catalog.issueInformation("c","c reader","24.10.2024"));
        catalog.addBook("e","e reader","24.09.2024");
        catalog.addBook("f","f reader","24.08.2024");
        System.out.println(catalog);
    }
}