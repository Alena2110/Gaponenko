
public class BooksCreator {
    public static void main(String[] args) {
        Books books = new Books();
        books.bookAdd(new Book("Панфилов М.Ю.", "Аверсэв", 2020, 456, "твердый", 248));
        books.bookAdd(new Book("Юрьев А. П.", "Белый ветер", 1986, 100, "мягкий", 248));
        books.bookAdd(new Book("Иванов М.Ю.", "Аверсэв", 2001, 200, "твердый", 248));
        books.bookAdd(new Book("Юрьев А. П.", "Беларусь", 1999, 409, "мягкий", 248));
        books.bookAdd(new Book("Гавриленко М.Ю.", "Белый ветер", 2006, 86, "твердый", 248));
        books.bookAdd(new Book("Афанасенко М.Ю.", "Аверсэв", 2005, 90, "мягкий", 248));
        books.bookAdd(new Book("Юрьев А. П.", "Юнипресс", 2000, 177, "твердый", 248));
        System.out.println("Список книг заданного автора\n");
        for (Book book : books.authorFilter("Юрьев А. П.")) {
            System.out.println(book);
        }
        System.out.println("\nСписок книг, выпущенных заданным издательством\n");
        for (Book book : books.publisherFilter("Аверсэв")) {
            System.out.println(book);
        }
        System.out.println("\nСписок книг, выпущенных после заданного года\n");
        for (Book book : books.yearFilter(2000)) {
            System.out.println(book);
        }
    }
}



