/*Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы: ехать, заправляться, менять колесо,
вывести на консоль марку автомобиля.*/

public class Car {
    private Engine engine = new Engine();//двигатель
    private Wheel[] wheel = new Wheel[4];//колеса
    private String brand;//марка машины

    public Car(String brand) {
        this.brand = brand;
        for (int i = 0; i < 4; i++) {
            this.wheel[i] = new Wheel("колесо " + i);
        }
    }

    public void carGo() { // машина едет
        System.out.println("Машина " + this.brand + " едет");
    }

    public void carFill() {//заправка машины
        System.out.println("Машина " + this.brand + " заправлена");
    }

    public void wheelChange(int numberWheel) {//замена колеса
        if (numberWheel <= 3 && numberWheel >= 0) {
            System.out.println("Произведена замена " + wheel[numberWheel].getNameWheel());
        } else {
            System.out.println("Некорректный ввод номера колеса");
        }
    }
}
