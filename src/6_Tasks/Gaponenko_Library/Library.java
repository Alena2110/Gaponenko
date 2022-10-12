import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<User> users;//список пользователей
    private ArrayList<Book> books;//каталог книг
    private Scanner scanner;
    private String fileUser = "user.txt";//файл для записи/чтения пользователей
    private String fileBook = "book.txt";//файл для записи/чтения каталога книг

    public Library() {
        users = new ArrayList<>();
        books = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addBook() {//добавление книги в каталог
        String title;
        int year;
        String author;
        int numberOfPages;
        String publishingHouse;
        String city;
        boolean isEbook;
        System.out.println("Введите название книги:");
        title = scanner.nextLine();
        System.out.println("Ведите год издания:");
        while (!scanner.hasNextInt()) {
            System.out.println("Введены некорректные данные, повторите ввод:");
            scanner.next();
        }
        year = scanner.nextInt();
        System.out.println("Введите автора книги:");
        scanner.nextLine();
        author = scanner.nextLine();
        System.out.println("Введите количество страниц:");
        while (!scanner.hasNextInt()) {
            System.out.println("Введены некорректные данные, повторите ввод:");
            scanner.next();
        }
        numberOfPages = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите издательство:");
        publishingHouse = scanner.nextLine();
        System.out.println("Введите город:");
        city = scanner.nextLine();
        System.out.println("Является ли книга электронной?(+/-)");
        while (!scanner.hasNext("[+-]")) {
            System.out.println("Введены некорректные данные, повторите ввод:");
            scanner.nextLine();
        }
        isEbook = scanner.nextLine().equals("+");
        books.add(new Book(author, title, city, publishingHouse, year, numberOfPages, isEbook));
    }


    public void addUser() throws NoSuchAlgorithmException {//добавление пользователя
        String regexEmail = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        String login;
        String password;
        String email;
        boolean isAdmin;
        boolean uniqueLogin;
        boolean uniqueEmail;
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        System.out.println("Введите логин:");
        do {
            uniqueLogin = false;
            if (users.size() != 0) {
                login = scanner.nextLine();
                for (User user : users) {
                    if (login.equals(user.getLogin())) {
                        uniqueLogin = true;
                        System.out.println("Такой логин уже существует, повторите ввод");
                        break;
                    }
                }
            } else {
                login = scanner.nextLine();
            }
        }
        while (uniqueLogin);
        System.out.println("Введите пароль:");
        password = scanner.nextLine();
        byte[] bytesPassword = md5.digest(password.getBytes());
        StringBuilder hashPassword = new StringBuilder();
        for (byte b : bytesPassword) {
            hashPassword.append(b);
        }
        System.out.println("Введите e-mail:");
        do {
            uniqueEmail = false;
            if (users.size() != 0) {
                while (!((email = scanner.nextLine()).matches(regexEmail))) {
                    System.out.println("Необходимо ввести корректный e-mail");
                }
                for (User user : users) {
                    if (email.equals(user.getEmail())) {
                        uniqueEmail = true;
                        System.out.println("Такой e-mail уже существует, повторите ввод");
                        break;
                    }
                }
            } else {
                while (!((email = scanner.nextLine()).matches(regexEmail))) {
                    System.out.println("Необходимо ввести корректный e-mail");
                }
            }
        }
        while (uniqueEmail);
        System.out.println("Является ли пользователь администратором?(+/-)");
        while (!scanner.hasNext("[+-]")) {
            System.out.println("Введены некорректные данные, повторите ввод:");
            scanner.nextLine();
        }
        isAdmin = scanner.nextLine().equals("+");
        users.add(new User(login, hashPassword.toString(), email, isAdmin));
    }

    public void writeBook() {//запись каталога книг в файл
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileBook))) {
            oos.writeObject(books);
        } catch (Exception ex) {
        }
    }

    public void readBook() {//чтение каталога книг из файла
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileBook))) {
            books = (ArrayList<Book>) ois.readObject();
        } catch (Exception ex) {
        }
    }

    public void writeUser() {//запись пользователей в файл
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileUser))) {
            oos.writeObject(users);
        } catch (Exception ex) {
        }
    }

    public void readUser() {//чтение пользователей из файла
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileUser))) {
            users = (ArrayList<User>) ois.readObject();
        } catch (Exception ex) {
        }
    }

    public void catalogBrowsing() {//постраничный просмотр каталога
        int pageSize = 5; // количество книг на странице
        int page = 0;
        while (true) {
            System.out.println("Введите номер страницы от 1 до " + (int) Math.ceil((float) this.books.size() / pageSize) + ":");
            while (!scanner.hasNextInt()) {
                System.out.println("Количество страниц должно быть целым числом");
                scanner.next();
            }
            page = scanner.nextInt();
            if (page == 0) {
                scanner.nextLine();
                break; // выход из просмотра каталога
            }
            books.stream().skip((long) (page - 1) * pageSize).limit(pageSize).forEach(System.out::println);
        }
    }

    public void deleteBook() {//удаление книги из каталога
        int id;
        int index = -1;
        System.out.println("Введите id удаляемой книги: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Количество страниц должно быть целым числом");
            scanner.next();
        }
        id = scanner.nextInt();
        for (Book book : books) {
            if (book.getId() == id) {
                index = books.indexOf(book);
            }
        }
        if (index != -1) {
            books.remove(index);
        }
        scanner.nextLine();
    }

    public String searchByAuthor() {//поиск книг по автору
        System.out.println("Введите автора книги:");
        String author = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        for (Book book : books) {
            if (book.getAuthor().contains(author)) {
                result.append(book).append("\n");
            }
        }
        return result.toString();
    }

    public String searchByTitle() {//поиск книг по названию
        System.out.println("Введите название книги:");
        String title = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        for (Book book : books) {
            if (book.getTitle().contains(title)) {
                result.append(book).append("\n");
            }
        }
        return result.toString();
    }

    public boolean[] authorization() throws NoSuchAlgorithmException {//авторизация пользователя
        boolean[] result = new boolean[2];
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        String login;
        String password;
        System.out.println("Введите логин:");
        login = scanner.nextLine();
        System.out.println("Введите пароль:");
        password = scanner.nextLine();
        byte[] bytesPassword = md5.digest(password.getBytes());
        StringBuilder hashPassword = new StringBuilder();
        for (byte b : bytesPassword) {
            hashPassword.append(b);
        }
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(hashPassword.toString())) {
                result[0] = true;//пользователь авторизирован
                result[1] = user.isAdmin();//права пользователя
            }
        }
        return result;
    }
}
