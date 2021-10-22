import java.math.BigInteger;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        double z;
        String result;
        boolean rez;
        z = TaskOneOne(-5, 7, 8);
        System.out.println("Линейные программы\n_____________________");
        System.out.println("Задание 1.1. \nРезультат: " + z + "\n_____________________");
        z = TaskOneTwo(2, 9.7, 3);
        System.out.println("Задание 1.2. \nРезультат: " + z + "\n_____________________");
        z = TaskOneThree(45, 30);
        System.out.println("Задание 1.3. \nРезультат: " + z + "\n_____________________");
        z = TaskOneFour(567.453);
        System.out.print("Задание 1.4. \nРезультат: ");
        System.out.printf("%.3f", z);
        System.out.println("\n_____________________");
        result = TaskOneFive(89200);
        System.out.println("Задание 1.5. \nРезультат: " + result + "\n_____________________");
        rez = TaskOneSix(4, -3.1);
        System.out.println("Задание 1.6. \nРезультат: " + rez + "\n_____________________");
        result = TaskTwoOne(30, 60);
        System.out.println("Ветвления\n_____________________");
        System.out.println("Задание 2.1. \nРезультат: " + result + "\n_____________________");
        z = TaskTwoTwo(10, 40, 1000, 950);
        System.out.println("Задание 2.2. \nРезультат: " + z + "\n_____________________");
        result = TaskTwoThree(10, 20, 30, 40, 50, 60);
        System.out.println("Задание 2.3. \nРезультат: " + result + "\n_____________________");
        result = TaskTwoFour(100, 200, 700, 95, 195);
        System.out.println("Задание 2.4. \nРезультат: " + result + "\n_____________________");
        z = TaskTwoFive(5);
        System.out.println("Задание 2.5. \nРезультат: " + z + "\n_____________________");
        TaskThreeOne();
        result = TaskThreeTwo(-5, 20, 5);
        System.out.println("Задание 3.2. \n" + result + "\n_____________________");
        TaskThreeThree();
        TaskThreeFour();
        z = TaskThreeFive(0.004);
        System.out.println("Задание 3.5.\nРезультат: " + z + "\n_____________________");
        System.out.println("Задание 3.6.\nРезультат: ");
        TaskThreeSix();
        System.out.println("\n_____________________");
        result = TaskThreeSeven();
        System.out.println(result + "\n_____________________");
        result = TaskThreeEight(12030, 4506780);
        System.out.println("Задание 3.8.\nРезультат: " + result + "\n_____________________");
    }

    public static double TaskOneOne(double a, double b, double c) {
        //  1. Найдите значение функции: z = ( (a – 3 ) * b / 2) + c.
        return ((a - 3) * b / 2) + c;
    }

    public static double TaskOneTwo(double a, double b, double c) {
        //2. Вычислить значение выражения по формуле (все переменные принимают действительные значения)
        return (b + Math.pow((Math.pow(b, 2) + 4 * a * c), 0.5)) / (2 * a) - Math.pow(a, 3) * c + Math.pow(b, -2);
    }

    public static double TaskOneThree(double x, double y) {
        // 3. Вычислить значение выражения по формуле (все переменные принимают действительные значения):
        // (𝑠𝑖𝑛𝑥+𝑐𝑜𝑠𝑦)/(𝑐𝑜𝑠𝑥−𝑠𝑖𝑛𝑦)∗𝑡𝑔 𝑥𝑦
        return ((Math.sin(x) + Math.cos(y)) / (Math.cos(x) - Math.sin(y))) * Math.tan(x * y);
    }

    public static double TaskOneFour(double a) {
        //4. Дано действительное число R вида nnn.ddd (три цифровых разряда в дробной и целой частях).
        // Поменять местами дробную и целую части числа и вывести полученное значение числа.
        return a % 1 * 1000 + Math.floor(a) / 1000;
    }

    public static String TaskOneFive(int a) {
        //5. Дано натуральное число Т, которое представляет длительность прошедшего времени в секундах.
        // Вывести данное значение длительности в часах, минутах и секундах в следующей форме: ННч ММмин SSc.
        int hour;
        int min;
        int seconds;
        hour = (a / 3600);
        min = (a % 3600) / 60;
        seconds = a % 60;
        return hour + " ч. " + min + " мин.  " + seconds + " c. ";
    }

    public static boolean TaskOneSix(double x, double y) {
        //6. Для данной области составить линейную программу, которая печатает true,
        // если точка с координатами (х, у) принадлежит закрашенной области, и false — в противном случае:
        return x <= 4 && x >= -4 && y <= 4 && y >= -3;

    }

    public static String TaskTwoOne(double x, double y) {
        //1. Даны два угла треугольника (в градусах). Определить, существует ли такой треугольник,
        // и если да, то будет ли он прямоугольным.
        String result;
        if (x > 0 && y > 0 && 180 - x - y > 0) {
            result = "Треугольник существует";
            if (x == 90 || y == 90 || 180 - x - y == 90) {
                result += ", треугольник прямоугольный.";
            } else {
                result += ", треугольник непрямоугольный.";
            }
        } else {
            result = "Треугольник не существует.";
        }
        return result;
    }

    public static double TaskTwoTwo(double a, double b, double c, double d) {
        //2. Найти max{min(a, b), min(c, d)}.
        double min1;
        double min2;
        min1 = a < b ? a : b;
        min2 = c < d ? c : d;

        return min1 > min2 ? min1 : min2;
    }

    public static String TaskTwoThree(double x1, double y1, double x2, double y2, double x3, double y3) {
        //3. Даны три точки А(х1,у1), В(х2,у2) и С(х3,у3). Определить, будут ли они расположены на одной прямой.
        if ((y3 - y1) / (y2 - y1) == (x3 - x1) / (x2 - x1)) {
            return "Три точки принадлежат прямой.";
        } else {
            return "Три точки не принадлежат прямой.";
        }
    }

    public static String TaskTwoFour(double a, double b, double x, double y, double z) {
        //4. Заданы размеры А, В прямоугольного отверстия и размеры х, у, z кирпича. Определить,
        // пройдет ли кирпич через отверстие.
        if ((x <= a || x <= b && y <= a && y <= b) || (x <= a || x <= b && z <= a && z <= b) ||
                (y <= a || y <= b && z <= a && z <= b)) {
            return "Кирпич пройдет в прямоугольное отверстие.";
        } else {
            return "Кирпич не пройдет в прямоугольное отверстие.";
        }
    }

    public static double TaskTwoFive(double x) {
        //5. Вычислить значение функции:
        if (x <= 3) {
            return Math.pow(x, 2) - 3 * x + 9;
        } else {
            return 1 / (Math.pow(x, 3) + 6);
        }
    }

    public static void TaskThreeOne() {
        //1. Напишите программу, где пользователь вводит любое целое положительное число.
        // А программа суммирует все числа от 1 до введенного пользователем числа.
        int number;
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задание 3.1. \n");
        do {
            System.out.println("Введите целое положительное число!");
            while (!scanner.hasNextInt()) {
                System.out.println("Число не является целым, повторите ввод");
                scanner.next();
            }
            number = scanner.nextInt();
        } while (number <= 0);
        for (int i = 1; i <= number; i++) {
            sum += i;
        }
        System.out.println("Результат: " + sum + "\n_____________________");
    }

    public static String TaskThreeTwo(double a, double b, double h) {
        //2. Вычислить значения функции на отрезке [а,b] c шагом h:
        StringBuilder result = new StringBuilder("Значения функции:");
        for (double i = a; i <= b; i += h) {
            if (i > 2) {
                result.append(i).append(" ");
            }
            if (i <= 2) {
                result.append(-i).append(" ");
            }
        }
        return result.toString();
    }

    public static void TaskThreeThree() {
        //3. Найти сумму квадратов первых ста чисел.
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += Math.pow(i, 2);
        }
        System.out.println("Задание 3.3. \nСумма квадратов первых ста чисел: " + sum + "\n_____________________");
    }

    public static void TaskThreeFour() {
        //4. Составить программу нахождения произведения квадратов первых двухсот чисел.
        BigInteger mult = BigInteger.valueOf(1);
        for (int i = 1; i <= 200; i++) {
            mult = mult.multiply(BigInteger.valueOf((long) i * i));
        }
        System.out.println("Задание 3.4. \nПроизведение квадратов первых двухсот чисел:  \n" + mult +
                "\n_____________________");
    }

    public static double TaskThreeFive(double e) {
        //5. Даны числовой ряд и некоторое число е. Найти сумму тех членов ряда, модуль которых больше или равен
        //заданному е. Общий член ряда имеет вид:
        double sum = 0;
        int n = 1;
        while (Math.abs(1 / Math.pow(2, n) + 1 / Math.pow(3, n)) >= e) {
            sum += Math.abs(1 / Math.pow(2, n) + 1 / Math.pow(3, n));
            n++;
        }
        return sum;
    }

    public static void TaskThreeSix() {
        //6. Вывести на экран соответствий между символами и их численными обозначениями в памяти компьютера.
        for (int i = 0; i <= 255; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print("(" + i + "_" + (char) i + ") ");
        }
    }

    public static String TaskThreeSeven() {
        //7. Для каждого натурального числа в промежутке от m до n вывести все делители, кроме единицы
        // и самого числа. m и n вводятся с клавиатуры.
        StringBuilder result = new StringBuilder();
        int n;
        int m;
        int k;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задание 3.7. \n");
        do {
            System.out.println("Введите натуральное число m");
            while (!scanner.hasNextInt()) {
                System.out.println("Число не является целым, повторите ввод");
                scanner.next();
            }
            m = scanner.nextInt();
        } while (m <= 0);
        do {
            System.out.println("Введите натуральное число n");
            while (!scanner.hasNextInt()) {
                System.out.println("Число не является целым, повторите ввод");
                scanner.next();
            }
            n = scanner.nextInt();
        } while (n <= 0);
        for (int i = m; i <= n; i++) {
            result.append("делители для ").append(i).append(": ");
            k = 0;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    result.append(j).append(" ");
                    k = 1;
                }
            }
            if (k == 0) {
                result.append("Делители отсутсвуют");
            }
            result.append("\n");
        }
        return result.toString();
    }

    public static String TaskThreeEight(int a, int b) {
        //8. Даны два числа. Определить цифры, входящие в запись как первого так и второго числа.
        StringBuilder resultA = new StringBuilder();
        StringBuilder resultB = new StringBuilder();
        int i;
        do {
            i = a % 10;
            a /= 10;
            if (i == 0 && a < 0.1) continue;
            resultA.append(i).append(" ");
        }
        while (i != 0 || a > 0.1);
        resultA.reverse();
        resultA.append(" Состав первого числа");
        resultA.append("\n");
        do {
            i = b % 10;
            b /= 10;
            if (i == 0 && b < 0.1) continue;
            resultB.append(i).append(" ");
        }
        while (i != 0 || b > 0.1);
        resultB.reverse();
        resultB.append(" Состав второго числа");
        return resultA.append(resultB).toString();
    }
}