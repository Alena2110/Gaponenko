/*5. Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение на единицу в
заданном диапазоне. Предусмотрите инициализацию счетчика значениями по умолчанию и произвольными значениями. Счетчик
 имеет методы увеличения и уменьшения состояния, и метод позволяющее получить его текущее состояние. Написать код,
 демонстрирующий все возможности класса.
*/

public class Enumerator {
    private int min;//минимальное значение диапазона
    private int max;//максимальное значение диапазона
    private int current; //текущее значение

    Enumerator() {//конструктор по умолчанию
        this.min = 100;
        this.max = 200;
        this.current = 110;
    }

    Enumerator(int min, int max, int current) { //конструктор с входными данными
        this(); //инициализация значениями по умолчанию на случай некорректного ввода данных пользователем
        if (max > min && current <= max && current >= min) { //инициализация данными пользователя при выполнении условия их корректности
            this.max = max;
            this.min = min;
            this.current = current;
        } else {
            System.out.println("Максимальное значение должно быть больше минимального, текущее значение - находится в" +
                    " заданном диапазоне. \nИсходные данные проинициализированы значениями по умолчанию.");
        }
    }

    public void increase() { //увеличение значения на единицу
        System.out.println("Увеличение текущего значения на единицу.");
        this.current++;
        if (this.current > this.max) {
            this.current = this.max;
            System.out.println("Увеличение текущего значения привело к выходу за пределы диапазона. Текущему значению " +
                    "присвоено максимальное значение диапазона: " + this.max);
        }
    }

    public void decrease() { //уменьшение значения на единицу
        System.out.println("Уменьшение текущего значения на единицу.");
        this.current--;
        if (this.current < this.min) {
            this.current = this.min;
            System.out.println(("Уменьшение текущего значения привело к выходу за пределы диапазона. Текущему значению " +
                    "присвоено минимальное значение диапазона: " + this.min));
        }
    }

    public int getCurrent() { //get-метод для current
        return this.current;
    }

    public void print() { //вывод на экран
        System.out.println("Минимальное значение: " + this.min + ". Максимальное значение: " + max +
                ". Текущее значение: " + current);
    }

    public static void main(String[] args) {
        System.out.println("Первый счетчик.");
        Enumerator enumeratorFirst = new Enumerator(500, 300, 1);
        enumeratorFirst.print();
        enumeratorFirst.decrease();
        System.out.println("Текущее значение: " + enumeratorFirst.getCurrent());
        enumeratorFirst.decrease();
        System.out.println("Текущее значение: " + enumeratorFirst.getCurrent());
        enumeratorFirst.increase();
        System.out.println("Текущее значение: " + enumeratorFirst.getCurrent());
        System.out.println("\nВторой счетчик.");
        Enumerator enumeratorSecond = new Enumerator(234, 1000, 700);
        enumeratorSecond.print();
        enumeratorSecond.decrease();
        System.out.println("Текущее значение: " + enumeratorSecond.getCurrent());
        enumeratorSecond.decrease();
        System.out.println("Текущее значение: " + enumeratorSecond.getCurrent());
        enumeratorSecond.increase();
        System.out.println("Текущее значение: " + enumeratorSecond.getCurrent());
        System.out.println("\nТретий счетчик.");
        Enumerator enumeratorThird = new Enumerator(100, 300, 299);
        enumeratorThird.print();
        enumeratorThird.increase();
        System.out.println("Текущее значение: " + enumeratorThird.getCurrent());
        enumeratorThird.increase();
        System.out.println("Текущее значение: " + enumeratorThird.getCurrent());
        enumeratorThird.decrease();
        System.out.println("Текущее значение: " + enumeratorThird.getCurrent());
    }
}


