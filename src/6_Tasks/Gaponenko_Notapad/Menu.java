import java.util.Scanner;

public class Menu {

    public void menuRun() {
        int choice;
        int choiceSort;
        int choiceFind;
        NotePad notePad = new NotePad();
        notePad.read();
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Просмотр блокнота");
        System.out.println("2. Добавление записи");
        System.out.println("3. Сортировка");
        System.out.println("4. Поиск записей");
        System.out.println("5. Выход");

        do {
            System.out.println("Сделайте ваш выбор: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Необходимо ввести целое число");
                scanner.next();
            }
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(notePad);
                    break;
                case 2:
                    notePad.addNote();
                    break;
                case 3:
                    System.out.println("1. Сортировка по теме");
                    System.out.println("2. Сортировка по дате");
                    System.out.println("3. Сортировка по адресу электронной почты");
                    System.out.println("4. Сортировка по сообщению");
                    System.out.println("5. Выход из сортировки");
                    do {
                        System.out.println("Сделайте ваш выбор: ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Необходимо ввести целое число");
                            scanner.next();
                        }
                        choiceSort = scanner.nextInt();
                        switch (choiceSort) {
                            case 1:
                                System.out.println(notePad.sortTopic().toString().replace(",", ""));
                                break;
                            case 2:
                                System.out.println(notePad.sortData().toString().replace(",", ""));
                                break;
                            case 3:
                                System.out.println(notePad.sortEmail().toString().replace(",", ""));
                                break;
                            case 4:
                                System.out.println(notePad.sortMessage().toString().replace(",", ""));
                                break;
                            case 5:
                                System.out.println("Выход из сортировки");
                                break;
                            default:
                                System.out.println("Введены некорректные данные");
                        }
                    }
                    while (choiceSort != 5);
                    break;
                case 4:
                    System.out.println("1. Поиск по теме");
                    System.out.println("2. Поиск по дате");
                    System.out.println("3. Поиск по адресу электронной почты");
                    System.out.println("4. Поиск по сообщению");
                    System.out.println("5. Поиск по теме и адресу электронной почты");
                    System.out.println("6. Поиск по вхождению слова");
                    System.out.println("7. Выход");
                    do {
                        System.out.println("Сделайте ваш выбор: ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Необходимо ввести целое число");
                            scanner.next();
                        }
                        choiceFind = scanner.nextInt();
                        switch (choiceFind) {
                            case 1:
                                System.out.println(notePad.findTopic().toString().replace(",", ""));
                                break;
                            case 2:
                                System.out.println(notePad.findData().toString().replace(",", ""));
                                break;
                            case 3:
                                System.out.println(notePad.findEmail().toString().replace(",", ""));
                                break;
                            case 4:
                                System.out.println(notePad.findMessage().toString().replace(",", ""));
                                break;
                            case 5:
                                System.out.println(notePad.findEmailTopic().toString().replace(",", ""));
                                break;
                            case 6:
                                System.out.println(notePad.findWord().toString().replace(",", ""));
                                break;
                            case 7:
                                System.out.println("Выход из поиска");
                                break;
                            default:
                                System.out.println("Введены некорректные данные");
                        }
                    }
                    while (choiceFind != 7);
                    break;
                case 5:
                    System.out.println("Выход");
                    notePad.write();
                    break;
                default:
                    System.out.println("Введены некорректные данные");
            }
        }
        while (choice != 5);
    }
}
