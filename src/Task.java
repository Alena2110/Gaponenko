import java.math.BigInteger;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        String result;
        System.out.println("Линейные программы");
        result = task1_1(-5, 7, 8);
        System.out.println(result);
        result = task1_2(2, 9.7, 3);
        System.out.println(result);
        result = task1_3(45, 30);
        System.out.println(result);
        result = task1_4(567.453);
        System.out.println(result);
        result = task1_5(89200);
        System.out.println(result);
        result = task1_6(4, -3.1);
        System.out.println(result);
        System.out.println("Ветвления");
        result = task2_1(30, 60);
        System.out.println(result);
        result = task2_2(10, 40, 1000, 950);
        System.out.println(result);
        result = task2_3(10, 20, 30, 40, 50, 60);
        System.out.println(result);
        result = task2_4(100, 200, 700, 100, 195);
        System.out.println(result);
        result = task2_5(5);
        System.out.println(result);
        System.out.println("Циклы");
        result = task3_1();
        System.out.println(result);
        result = task3_2(-5, 20, 5);
        System.out.println(result);
        result = task3_3();
        System.out.println(result);
        result = task3_4();
        System.out.println(result);
        result = task3_5(0.004);
        System.out.println(result);
        task3_6();
        result = task3_7();
        System.out.println(result);
        result = task3_8(12030, 4506780);
        System.out.println(result);
    }

    public static String task1_1(double a, double b, double c) {
        //1. Найдите значение функции: z = ((a – 3 ) * b / 2) + c.
        return ("________________________________\n1. Найдите значение функции: z = ((a – 3 ) * b / 2) + c." +
                "\n\na = " + a + "; b = " + b + "; c = " + c + "\n\nОтвет: " + (((a - 3) * b / 2) + c));
    }

    public static String task1_2(double a, double b, double c) {
        //2. Вычислить значение выражения по формуле (все переменные принимают действительные значения).
        return ("________________________________\n2. Вычислить значение выражения по формуле " +
                "\n(все переменные принимают действительные значения)" +
                "\n\na = " + a + "; b = " + b + "; c = " + c + "\n\nОтвет: " +
                (Math.round(((b + Math.pow((Math.pow(b, 2) + 4 * a * c), 0.5)) / (2 * a) - Math.pow(a, 3) * c +
                        Math.pow(b, -2)) * 100.0) / 100.0));
    }

    public static String task1_3(double x, double y) {
        //3. Вычислить значение выражения по формуле (все переменные принимают действительные значения):
        //(𝑠𝑖𝑛𝑥+𝑐𝑜𝑠𝑦)/(𝑐𝑜𝑠𝑥−𝑠𝑖𝑛𝑦)∗𝑡𝑔 𝑥𝑦
        return ("________________________________\n3. Вычислить значение выражения по формуле " +
                "\n(все переменные принимают действительные значения):\n(sin(x)+cos(y))/(cos(x)-sin(y))*tg(xy)" +
                "\n\nx = " + x + "; y = " + y + "\n\nОтвет: " +
                ((Math.sin(x) + Math.cos(y)) / (Math.cos(x) - Math.sin(y)) * Math.tan(x * y)));
    }

    public static String task1_4(double a) {
        //4. Дано действительное число R вида nnn.ddd (три цифровых разряда в дробной и целой частях).
        // Поменять местами дробную и целую части числа и вывести полученное значение числа.
        return ("________________________________\n4. Дано действительное число R вида nnn.ddd" +
                "\nПоменять местами дробную и целую части числа." +
                "\n\nИсходное число " + a + "\n\nОтвет: " + String.format("%.3f", (a % 1 * 1000 + Math.floor(a) / 1000)));
    }

    public static String task1_5(int a) {
        //5. Дано натуральное число Т, которое представляет длительность прошедшего времени в секундах.
        //Вывести данное значение длительности в часах, минутах и секундах в следующей форме: НН ч MM мин SS c.
        int hour;
        int min;
        int seconds;
        hour = (a / 3600);
        min = (a % 3600) / 60;
        seconds = a % 60;
        return ("________________________________\n5. Дано натуральное число Т, которое представляет \nдлительность " +
                "прошедшего времени в секундах. \nВывести данное значение длительности в часах, минутах и " +
                "\nсекундах в следующей форме: НН ч ММ мин SS c." +
                "\n\nИсходное число: " + a + "\n\nОтвет: \n" + hour + " ч. " + min + " мин. " + seconds + " c. ");
    }

    public static String task1_6(double x, double y) {
        //6. Для данной области составить линейную программу, которая печатает true,
        //если точка с координатами (х, у) принадлежит закрашенной области, и false — в противном случае.
        return ("________________________________\n6. Для данной области составить линейную программу," +
                "\n которая печатает true, если точка с координатами (х, у)\nпринадлежит закрашенной области," +
                " и false — в противном случае." + "\n\nx: " + x + "\ny: " + y + "\n\nОтвет: " +
                (x <= 4 && x >= -4 && y <= 4 && y >= -3)) + "\n________________________________";
    }

    public static String task2_1(double x, double y) {
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
        return ("________________________________\n1. Даны два угла треугольника (в градусах)." +
                "\nОпределить, существует ли такой треугольник, \n и если да, то будет ли он прямоугольным." +
                "\n\nx: " + x + "\ny: " + y + "\n\nОтвет: " + result);
    }

    public static String task2_2(double a, double b, double c, double d) {
        //2. Найти max{min(a, b), min(c, d)}.
        return ("________________________________\n2. Найти max{min(a, b), min(c, d)}." +
                "\n\na: " + a + "\nb: " + b + "\nc: " + c + "\nd: " + d + "\n\nОтвет: " +
                ((a < b ? a : b) > (c < d ? c : d) ? (a < b ? a : b) : (c < d ? c : d)));
    }

    public static String task2_3(double x1, double y1, double x2, double y2, double x3, double y3) {
        //3. Даны три точки А(х1,у1), В(х2,у2) и С(х3,у3). Определить, будут ли они расположены на одной прямой.
        if ((y3 - y1) / (y2 - y1) == (x3 - x1) / (x2 - x1)) {
            return ("________________________________\n3. Даны три точки А(х1,у1), В(х2,у2) и С(х3,у3)." +
                    "\nОпределить, будут ли они расположены на одной прямой." + "\n\nx1: " + x1 + "\ny1: " + y1 +
                    "\nx2: " + x2 + "\ny2: " + y2 + "\nx3: " + x3 + "\ny3: " + y3 + "\n\nОтвет:" +
                    "Три точки принадлежат прямой.");
        } else {
            return ("________________________________\n3. Даны три точки А(х1,у1), В(х2,у2) и С(х3,у3)." +
                    "\nОпределить, будут ли они расположены на одной прямой." + "\n\nx1: " + x1 + "\ny1: " + y1 +
                    "\nx2: " + x2 + "\ny2: " + y2 + "\nx3: " + x3 + "\ny3: " + y3 + "\n\nОтвет:" +
                    "Три точки не принадлежат прямой.");
        }
    }

    public static String task2_4(double a, double b, double x, double y, double z) {
        //4. Заданы размеры А, В прямоугольного отверстия и размеры х, у, z кирпича. Определить,
        // пройдет ли кирпич через отверстие.
        if (((x <= a || x <= b) && (y <= a || y <= b)) || ((x <= a || x <= b) && (z <= a || z <= b)) ||
                ((y <= a || y <= b) && (z <= a || z <= b))) {
            return ("________________________________\n4. Заданы размеры А, В прямоугольного отверстия" +
                    "\nи размеры х, у, z кирпича.\nОпределить, пройдет ли кирпич через отверстие."
                    + "\n\nx: " + x + "\ny: " + y + "\nz: " + z + "\na: " + a + "\nb: " + b + "\n\nОтвет: " +
                    "Кирпич пройдет в прямоугольное отверстие.");
        } else {
            return ("________________________________\n4. Заданы размеры А, В прямоугольного отверстия" +
                    "\nи размеры х, у, z кирпича.\nОпределить, пройдет ли кирпич через отверстие."
                    + "\n\nx: " + x + "\ny: " + y + "\nz: " + z + "\na: " + a + "\nb: " + b + "\n\nОтвет: " +
                    "Кирпич не пройдет в прямоугольное отверстие.");
        }
    }

    public static String task2_5(double x) {
        //5. Вычислить значение функции: y = x^2 - 3x + 9, x <= 3; y = 1 / (x^3 + 6), x > 3.
        if (x <= 3) {
            return ("________________________________\n5. Вычислить значение функции:y = x^2 - 3x + 9, x <= 3;" +
                    "\ny = 1 / (x^3 + 6), x > 3.\n\nx = " + x + "\n\nОтвет: " +
                    String.format("%3f", (Math.pow(x, 2) - 3 * x + 9)) + "\n________________________________");
        } else {
            return ("________________________________\n5. Вычислить значение функции:y = x^2 - 3x + 9, x <= 3;" +
                    "\ny = 1 / (x^3 + 6), x > 3.\n\nx = " + x + "\n\nОтвет: " +
                    String.format("%.3f", (1 / (Math.pow(x, 3) + 6))) + "\n________________________________");
        }
    }

    public static String task3_1() {
        //1. Напишите программу, где пользователь вводит любое целое положительное число.
        // А программа суммирует все числа от 1 до введенного пользователем числа.
        int number;   //число, которое вводит пользователь
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("________________________________\n1.  Напишите программу, где пользователь вводит " +
                "\nлюбое целое положительное число.\nА программа суммирует все числа от 1 " +
                "\nдо введенного пользователем числа.\n");
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
        return ("\nОтвет: " + sum);

    }

    public static String task3_2(double a, double b, double h) {
        //2. Вычислить значения функции на отрезке [а,b] c шагом h: y = x, x > 2; y = - x, x <= 2.
        StringBuilder result = new StringBuilder();
        for (double i = a; i <= b; i += h) {
            if (i > 2) {
                result.append(i).append(" ");
            }
            if (i <= 2) {
                result.append(-i).append(" ");
            }
        }
        return ("________________________________\n2. Вычислить значения функции на отрезке [а,b] c шагом h:" +
                "\ny = x, x > 2; y = - x, x <= 2.\n\na = " + a + "\nb = " + b + "\nh = " + h + "\n\nОтвет: " +
                result);
    }

    public static String task3_3() {
        //3. Найти сумму квадратов первых ста чисел.
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += Math.pow(i, 2);
        }
        return ("________________________________\n3. Найти сумму квадратов первых ста чисел." +
                "\n\nОтвет: " + sum);
    }

    public static String task3_4() {
        //4. Составить программу нахождения произведения квадратов первых двухсот чисел.
        BigInteger bigNumber = BigInteger.valueOf(1);
        for (long i = 1; i <= 200; i++) {
            bigNumber = bigNumber.multiply(BigInteger.valueOf(i * i));
        }
        return ("________________________________\n4. Составить программу нахождения произведения " +
                "\nквадратов первых двухсот чисел." + "\n\nОтвет: " + bigNumber);
    }

    public static String task3_5(double e) {
        //5. Даны числовой ряд и некоторое число е. Найти сумму тех членов ряда, модуль которых больше или равен
        //заданному е. Общий член ряда имеет вид: an = 1 / 2^n + 1 / 3^n.
        double sum = 0;
        int n = 1;
        while (Math.abs(1 / Math.pow(2, n) + 1 / Math.pow(3, n)) >= e) {
            sum += Math.abs(1 / Math.pow(2, n) + 1 / Math.pow(3, n));
            n++;
        }
        return ("________________________________\n5. Даны числовой ряд и некоторое число е. Найти сумму" +
                "\nтех членов ряда, модуль которых больше или равен заданному е.\nОбщий член ряда имеет вид: " +
                "an = 1 / 2^n + 1 / 3^n." + "\n\ne = " + e + "\n\nОтвет: " + sum);
    }

    public static void task3_6() {
        //6. Вывести на экран соответствие между символами и их численными обозначениями в памяти компьютера.
        System.out.println("________________________________\n6. Вывести на экран соответствие между символами" +
                "\nи их численными обозначениями в памяти компьютера. \n\nОтвет: ");
        for (int i = 0; i <= 255; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print("(" + i + "_" + (char) i + ") ");
        }
    }

    public static String task3_7() {
        //7. Для каждого натурального числа в промежутке от M до N вывести все делители, кроме единицы
        // и самого числа. M и N вводятся с клавиатуры.
        StringBuilder result = new StringBuilder();
        int m;      //начальное значение промежутка
        int n;      //конечное значение промежутка
        int k;      //переменная для проверки существования делителей
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n________________________________\n7. Для каждого натурального числа в промежутке от m до n" +
                "\nвывести все делители, кроме единицы\nи самого числа. m и n вводятся с клавиатуры.");
        do {
            System.out.println("\nВведите натуральное число m: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Число не является целым, повторите ввод.");
                scanner.next();
            }
            m = scanner.nextInt();
        } while (m <= 0);
        do {
            System.out.println("\nВведите натуральное число n: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Число не является целым, повторите ввод.");
                scanner.next();
            }
            n = scanner.nextInt();
        } while (n <= 0);
        for (int i = m; i <= n; i++) {
            result.append("Делители для ").append(i).append(": ");
            k = 0;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    result.append(j).append(" ");
                    k = 1;
                }
            }
            if (k == 0) {
                result.append("Делители отсутствуют");
            }
            result.append("\n");
        }
        return result.toString();
    }

    public static String numberComposition(int number) { //определение состава числа
        StringBuilder result = new StringBuilder();
        while (number > 0) {
            result.append(" ").append(number % 10);
            number /= 10;
        }
        return result.reverse().toString();
    }

    public static String task3_8(int a, int b) {
        //8. Даны два числа. Определить цифры, входящие в запись как первого, так и второго числа.
        return ("________________________________\n8. Даны два числа. Определить цифры, " +
                "\nвходящие в запись как первого так и второго числа. \n\nПервое число: " + a + "\nВторое число: " + b +
                "\n\nОтвет:\nСостав первого числа: " + numberComposition(a) + "\nСостав второго числа: " +
                numberComposition(b));
    }
}