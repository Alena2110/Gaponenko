/*Многопоточность. Порт. Корабли заходят в порт для разгрузки/загрузки контейнеров. Число контейнеров, находящихся в
 текущий момент в порту и на корабле, должно быть неотрицательным и превышающим заданную грузоподъемность судна
  и вместимость порта. В порту работает несколько причалов. У одного причала может стоять один корабль.
   Корабль может загружаться у причала или разгружаться.
 */

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Port port = new Port(2, 20, 50);//создание порта
        generateShips(port.getNumberShip(), port);//генерация списка кораблей для порта
        System.out.println(port);
        for (Ship ship : port.getShips()) {
            ship.start();//запуск кораблей
        }
    }

    public static void generateShips(int numberShip, Port port) {//случайная генерация списка кораблей для порта
        Random random = new Random();
        for (int i = 0; i < numberShip; i++) {
            port.addShip(new Ship(port, CapacityShip.values()[random.nextInt(CapacityShip.values().length)],
                    random.nextBoolean(), ("Корабль " + (i + 1))));
        }
    }
}


