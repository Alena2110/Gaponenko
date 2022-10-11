/*2. Создайте класс Test2 двумя переменными. Добавьте конструктор с входными параметрами. Добавьте конструктор,
инициализирующий члены класса по умолчанию. Добавьте set- и get- методы для полей экземпляра класса. */

public class Test2 {
    private int a;
    private int b;

    Test2(int a, int b) { //конструктор с входными данными
        this.a = a;
        this.b = b;
    }

    Test2() { //конструктор по умолчанию
        this.a = 100;
        this.b = 200;
    }

    public int getA() { //get-метод для a
        return a;
    }

    public void setA(int a) { //set-метод для a
        this.a = a;
    }

    public int getB() { //get-метод для b
        return b;
    }

    public void setB(int b) { //set-метод для b
        this.b = b;
    }

    public static void main(String[] args) {
        Test2 one = new Test2(45, 55);
        System.out.println("Переменная one поле а: " + one.getA() + ". Переменная one поле b: " + one.getB());
        one.setA(350);
        System.out.println("Переменная one поле а: " + one.getA() + ". Переменная one поле b: " + one.getB());
        Test2 two = new Test2();
        System.out.println("Переменная one поле а: " + two.getA() + ". Переменная one поле b: " + two.getB());
    }
}
