import java.util.ArrayList;
import java.util.concurrent.Semaphore;


public class Port {
    private int numberPier;//количество причалов в порту
    private ArrayList<Ship> ships;//список кораблей в порту
    private int numberShip;//количество кораблей
    private int capacity = 30;//начальное значение контейнеров в порту
    private int capacityPort;//вместимость порта
    private Semaphore controlNumberPier;//семафор для контроля одновременно занятых портов

    Port(int numberPier, int numberShip, int capacityPort) {
        this.numberPier = numberPier;
        this.controlNumberPier = new Semaphore(numberPier);
        this.numberShip = numberShip;
        this.capacityPort = capacityPort;
        ships = new ArrayList<>();
    }


    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public int getNumberShip() {
        return numberShip;
    }

    public int getNumberPier() {
        return numberPier;
    }

    public Semaphore getControlNumberPier() {
        return controlNumberPier;
    }

    public synchronized void unloading() {//разгрузка корабля

        while (capacity >= capacityPort) {//если превышена вместимость порта, корабль ожидает разгрузки
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        capacity++;//увеличение количества контейнеров в порту
        System.out.println(Thread.currentThread().getName() + " разгрузил 1 контейнер");
        System.out.println("Контейнеров  в порту " + capacity);
        notifyAll();//разрешена загрузка ожидающим кораблям
    }


    public synchronized void loading() {//загрузка корабля

        while (capacity < 1) {//если в порту нет контейнеров, корабль ожидает загрузки
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        capacity--;//уменьшение количества контейнеров в порту
        System.out.println(Thread.currentThread().getName() + " загрузил 1 контейнер");
        System.out.println("Контейнеров  в порту " + capacity);
        notifyAll();//разрешена разгрузка ожидающим кораблям
    }

    @Override
    public String toString() {
        StringBuilder ships = new StringBuilder();
        for (Ship ship : this.ships) {
            ships.append(ship);
        }
        return "В порту с грузоподъемностью " + capacityPort + " следующие корабли:" + ships;
    }
}

