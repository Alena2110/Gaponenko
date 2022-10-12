import java.io.Serializable;

public class Book implements Serializable {
    static int ID = 1;
    private int id;
    private String title;//заголовок книги
    private int year;//год издания
    private String author;//автор
    private int numberOfPages;//количество страниц
    private String publishingHouse;//издательство
    private String city;//город
    private boolean isEbook;//true-электронная книга, false - бумажная

    public Book(String author, String title, String city, String publishingHouse, int year, int numberOfPages, boolean isEbook) {
        this.id = ID++;
        this.title = title;
        this.year = year;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.publishingHouse = publishingHouse;
        this.city = city;
        this.isEbook = isEbook;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return id + ". " + author + ". " + title + ". - " + city + ": " + publishingHouse + ", " + year + ". - " +
                numberOfPages + " c. " + (isEbook ? "Электронный вариант" : "Бумажный вариант");
    }
}
