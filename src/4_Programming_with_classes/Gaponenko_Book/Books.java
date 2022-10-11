import java.util.ArrayList;

public class Books {
    ArrayList<Book> books = new ArrayList<>();

    public void bookAdd(Book book) {//добавление новой книги
        books.add(book);
    }

    public ArrayList<Book> authorFilter(String author) {
        //получение списка книг заданного автора
        ArrayList<Book> authorFilter = new ArrayList<>();
        for (Book book : books)
            if (book.getAuthor().equals(author)) {
                authorFilter.add(book);
            }
        return authorFilter;
    }

    public ArrayList<Book> publisherFilter(String publisher) {
        //получение списка книг, выпущенных заданным издательством
        ArrayList<Book> publisherFilter = new ArrayList<>();
        for (Book book : books)
            if (book.getPublisher().equals(publisher)) {
                publisherFilter.add(book);
            }
        return publisherFilter;
    }

    public ArrayList<Book> yearFilter(int year) {
        //получение списка книг, выпущенных после заданного года
        ArrayList<Book> yearFilter = new ArrayList<>();
        for (Book book : books)
            if (book.getYear() > year) {
                yearFilter.add(book);
            }
        return yearFilter;
    }

}
