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

    public int Sum() { //сумма переменных
        return this.a + this.b;
    }

    public void Change(int a, int b) { //изменение переменных
        this.a = a;
        this.b = b;
    }

    public int Max() { //поиск максимального значения
        return Math.max(this.a, this.b);
    }

    public void Print() {
        System.out.println("Переменная a: " + a + "\nПеременная b: " + b); //вывод переменных на экран
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1(45, 55);
        test1.Print();
        System.out.println(test1.Sum());
        System.out.println(test1.Max());
        test1.Change(44, 55);
        test1.Print();
        System.out.println(test1.Sum());
        System.out.println(test1.Max());
    }
}
