/*9. Создать класс Book, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и метод
toString(). Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и методами.
Задать критерии выбора данных и вывести эти данные на консоль.
        Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
        Найти и вывести:
        a) список книг заданного автора;
        b) список книг, выпущенных заданным издательством;
        c) список книг, выпущенных после заданного года.*/

public class Book {
    private static int ID = 1;
    private final int id;
    private String author;//автор
    private String publisher;//издательство
    private int year;//год
    private int price;//цена
    private int pages;//количество страниц
    private String binding;//тип переплета

    public Book(String author, String publisher, int year, int pages, String binding, int price) {
        this.id = ID++;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.pages = pages;
        this.binding = binding;
        this.price = price;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }

    public int getPages() {
        return pages;
    }

    public String getBinding() {
        return binding;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Книга " +
                "номер: " + id +
                ", автор: " + author +
                ", издательство: " + publisher +
                ", год: " + year +
                ", количество страниц: " + pages +
                ", переплет: " + binding +
                ", цена: " + price;
    }
}




