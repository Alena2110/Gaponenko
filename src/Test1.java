public class Test1 {
    private int a;
    private int b;

    Test1(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int Sum() {
        return this.a + this.b;
    }

    public void Change(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int Max() {
        return Math.max(this.a, this.b);
    }

    public void Print() {
        System.out.println("Переменная a: " + a + "\nПеременная b: " + b);
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
