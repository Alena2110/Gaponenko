import java.util.Scanner;

/*4. Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления. Создайте данные
 в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива по номерам поездов.
 Добавьте возможность вывода информации о поезде, номер которого введен пользователем. Добавьте возможность сортировки
 массив по пункту назначения, причем поезда с одинаковыми пунктами назначения должны быть упорядочены по времени отправления.
 */
public class Train {
    private final String destination; //пункт назначения
    private int numberTrain;//номер поезда
    private String time;//время отправления поезда

    Train(String destination, int numberTrain, String time) {//конструктор
        this.destination = destination;
        this.numberTrain = numberTrain;
        this.time = time;
    }

    public static void SortingNumber(Train[] trains) {//сортировка массива элементов типа Train по номеру поезда
        Train temp;
        for (int i = 0; i < trains.length - 1; i++)
            for (int j = i; j < trains.length; j++) {
                if (trains[i].numberTrain > trains[j].numberTrain) {
                    temp = trains[i];
                    trains[i] = trains[j];
                    trains[j] = temp;
                }
            }
    }

    public static void SortingDestination(Train[] trains) {
        //сортировка массива элементов типа Train по станции отправления (в случае равенства по времени отправления)
        Train temp;
        for (int i = 0; i < trains.length - 1; i++)
            for (int j = i; j < trains.length; j++) {
                if (trains[i].destination.compareToIgnoreCase(trains[j].destination) > 0) {
                    temp = trains[i];
                    trains[i] = trains[j];
                    trains[j] = temp;
                } else if (trains[i].destination.compareToIgnoreCase(trains[j].destination) == 0) {
                    if (trains[i].time.compareToIgnoreCase(trains[j].time) > 0) {
                        temp = trains[i];
                        trains[i] = trains[j];
                        trains[j] = temp;
                    }
                }
            }
    }

    public void Print() { //вывод на экран
        System.out.println("Станция назначения: " + this.destination + ". Номер поезда " + numberTrain +
                ". Время отправления: " + time);
    }

    public static void main(String[] args) {
        int number;
        Scanner scanner = new Scanner(System.in);
        Train[] trains = new Train[5]; //массив из 5 элементов типа Train
        trains[0] = new Train("Минск", 56, "24:45");
        trains[1] = new Train("Хотимск", 103, "11:22");
        trains[2] = new Train("Минск", 76, "11:22");
        trains[3] = new Train("Минск", 1, "02:42");
        trains[4] = new Train("Гомель", 4, "00:15");
        System.out.println("Исходные данные:");
        for (Train train : trains) {
            train.Print();
        }
        System.out.println("\nСортировка по номеру поезда:");
        Train.SortingNumber(trains);
        for (Train train : trains) {
            train.Print();
        }
        System.out.println("\nСортировка по станции назначения(в случае равенства по времени отправления):");
        Train.SortingDestination(trains);
        for (Train train : trains) {
            train.Print();
        }
        do {
            System.out.println("\nВведите число от 1 до: " + trains.length + " для вывода данных о поезде");
            while (!scanner.hasNextInt()) {
                System.out.println("Число не является целым, повторите ввод.");
                scanner.next();
            }
            number = scanner.nextInt();
        } while (number <= 0 || number > trains.length);
        trains[number - 1].Print();
    }
}
