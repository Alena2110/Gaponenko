import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Menu {
    public void menuRun() throws NoSuchAlgorithmException {
        int choice;
        int choiceAdmin;
        int choiceUser;
        Library library = new Library();
        library.readUser();
        library.readBook();
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Добавление пользователя");
        System.out.println("2. Авторизация");
        System.out.println("3. Выход");
        do {
            System.out.println("Сделайте ваш выбор: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Необходимо ввести целое число");
                scanner.next();
            }
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    library.addUser();
                    break;
                case 2:
                    boolean[] result;
                    result = library.authorization();
                    if (result[0]) {
                        if (result[1]) {
                            System.out.println("1. Просмотр каталога книг(0-выход из просмотра)");
                            System.out.println("2. Добавление книги");
                            System.out.println("3. Удаление книги");
                            System.out.println("4. Поиск книги по автору");
                            System.out.println("5. Поиск книги по названию");
                            System.out.println("6. Выход");
                            do {
                                System.out.println("Сделайте ваш выбор: ");
                                while (!scanner.hasNextInt()) {
                                    System.out.println("Необходимо ввести целое число");
                                    scanner.next();
                                }
                                choiceAdmin = scanner.nextInt();
                                switch (choiceAdmin) {
                                    case 1:
                                        library.catalogBrowsing();
                                        break;
                                    case 2:
                                        library.addBook();
                                        break;
                                    case 3:
                                        library.deleteBook();
                                        break;
                                    case 4:
                                        System.out.println(library.searchByAuthor());
                                        break;
                                    case 5:
                                        System.out.println(library.searchByTitle());
                                        break;
                                    case 6:
                                        System.out.println("Выход из меню администратора");
                                        break;
                                    default:
                                        System.out.println("Введены некорректные данные");
                                }
                            }
                            while (choiceAdmin != 6);
                        } else {
                            System.out.println("1. Просмотр каталога книг(0-выход из просмотра)");
                            System.out.println("2. Поиск книги по автору");
                            System.out.println("3. Поиск книги по названию");
                            System.out.println("4. Выход");
                            do {
                                System.out.println("Сделайте ваш выбор: ");
                                while (!scanner.hasNextInt()) {
                                    System.out.println("Необходимо ввести целое число");
                                    scanner.next();
                                }
                                choiceUser = scanner.nextInt();
                                switch (choiceUser) {
                                    case 1:
                                        library.catalogBrowsing();
                                        break;
                                    case 2:
                                        System.out.println(library.searchByAuthor());
                                        break;
                                    case 3:
                                        System.out.println(library.searchByTitle());
                                        break;
                                    case 4:
                                        System.out.println("Выход из пользовательского меню");
                                        break;
                                    default:
                                        System.out.println("Введены некорректные данные");
                                }
                            }
                            while (choiceUser != 4);
                        }
                    } else {
                        System.out.println("Введены некорректные данные пользователя");
                    }
                    break;
                case 3:
                    System.out.println("Выход");
                    library.writeBook();
                    library.writeUser();
                    break;
                default:
                    System.out.println("Введены некорректные данные");
            }
        }
        while (choice != 3);
    }
}


