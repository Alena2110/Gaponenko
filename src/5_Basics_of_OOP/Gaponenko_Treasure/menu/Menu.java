package menu;

import cave.Cave;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void menuRun() {
        double sumBuy;
        Cave cave = new Cave();
        System.out.println("1. Просмотр сокровищ");
        System.out.println("2. Выбор самого дорогого сокровища по стоимости");
        System.out.println("3. Выбор сокровищ на заданную сумму");
        System.out.println("4. Выход");
        int choice;
        do {
            System.out.println("Сделайте ваш выбор: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Необходимо ввести целое число");
                scanner.next();
            }
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(cave.showTreasureList(cave.getTreasureList()));
                    break;
                case 2:
                    System.out.println(cave.maxCost());
                    break;
                case 3:
                    System.out.println("Введите сумму:");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Введены некорректные данные, повторите ввод:");
                        scanner.next();
                    }
                    sumBuy = scanner.nextDouble();
                    System.out.println(cave.buyTreasure(sumBuy));
                    break;
                case 4:
                    System.out.println("Выход");
                    break;
                default:
                    System.out.println("Введены некорректные данные");
            }
        }
        while (choice != 4);
    }
}
