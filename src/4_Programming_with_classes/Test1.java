/*1. Создайте класс Test1 двумя переменными. Добавьте метод вывода на экран и методы изменения этих переменных. Добавьте
метод, который находит сумму значений этих переменных, и метод, который находит наибольшее значение из этих двух переменных.
 */
public class Test1 { //класс Test 1 с двумя переменными
    private int a;
    private int b;

    Test1(int a, int b) { //конструктор
        this.a = a;
        this.b = b;
    }

    public int sum() { //сумма переменных
        return this.a + this.b;
    }

    public void change(int a, int b) { //изменение переменных
        this.a = a;
        this.b = b;
    }

    public int max() { //поиск максимального значения
        return Math.max(this.a, this.b);
    }

    public void print() {
        System.out.println("Переменная a: " + a + "\nПеременная b: " + b); //вывод переменных на экран
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1(45, 55);
        test1.print();
        System.out.println(test1.sum());
        System.out.println(test1.max());
        test1.change(44, 55);
        test1.print();
        System.out.println(test1.sum());
        System.out.println(test1.max());
    }
}
