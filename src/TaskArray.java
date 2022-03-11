import java.util.*;

public class TaskArray {
    static class Fraction { //класс дробь
        int numerator; //числитель
        int denominator; //знаменатель

        Fraction(int numerator, int denominator) {
            this.numerator = numerator; //инициализация числителя
            this.denominator = denominator; //инициализация знаменателя
        }
    }

    public static StringBuilder ArrayOutputD(int N, int M, double[][] array) {
        //Вывод вещественной матрицы
        StringBuilder arrayOutput = new StringBuilder();
        for (int i = 0; i < N; i++) {
            arrayOutput.append("\n");
            for (int j = 0; j < M; j++) {
                arrayOutput.append(array[i][j]);
                if (array[i][j] < 10 && array[i][j] >= 0) {
                    arrayOutput.append("   ");
                } else if ((array[i][j] >= 10 && array[i][j] < 100) || (array[i][j] < 0 && array[i][j] > -10)) {
                    arrayOutput.append("  ");
                } else {
                    arrayOutput.append(" ");
                }
            }
        }
        return arrayOutput;
    }

    public static StringBuilder ArrayOutputI(int N, int M, int[][] array) {
        //Вывод целочисленной матрицы
        StringBuilder arrayOutput = new StringBuilder();
        for (int i = 0; i < N; i++) {
            arrayOutput.append("\n");
            for (int j = 0; j < M; j++) {
                arrayOutput.append(array[i][j]);
                if (array[i][j] < 10 && array[i][j] >= 0) {
                    arrayOutput.append("   ");
                } else if ((array[i][j] >= 10 && array[i][j] < 100) || (array[i][j] < 0 && array[i][j] > -10)) {
                    arrayOutput.append("  ");
                } else {
                    arrayOutput.append(" ");
                }
            }
        }
        return arrayOutput;
    }

    public static int[][] MagicSquare(int N) {
        //Магический квадрат нечетного порядка
        int[][] array = new int[N][N];
        int count = 2; //переменная для чисел, которыми будет заполнен квадрат
        int i = 0;
        int j = (N - 1) / 2;
        array[i][j] = 1; //единица записывается в центральном столбце верхней строки
        while (count <= N * N) {
            i--; //строка вверх
            j++; //столбец вправо
            if (i >= 0 && j <= N - 1 && array[i][j] == 0) {  //если элемент не заполнен и нет выхода за пределы массива
                array[i][j] = count;
            } else if (i < 0 && j <= N - 1) { //выход за верхний предел массива
                i = N - 1; //число записывается в самой нижней строке
                array[i][j] = count;
            } else if (j > N - 1 && i >= 0) { //выход за правый предел массива
                j = 0; //число записывается в первом столбце
                array[i][j] = count;
            } else { //если ячейка уже занята, число записывается под предыдущей записанной цифрой
                i = i + 2;
                j--;
                array[i][j] = count;
            }
            count++;
        }
        return array;
    }

    public static int[][] MagicSquare2(int N) {
        //Магический квадрат порядка одинарной четности (метод Чебракова)
        int[][] array = new int[N][N]; //итоговый магический квадрат
        int[][] arrayHelp; //квадрат нечетного порядка размера N/2
        int[][] arraySecondary = new int[N][N]; //вспомогательный квадрат
        arrayHelp = MagicSquare(N / 2); //формирование магического квадрата нечетного порядка
        for (int i = 0; i < N / 2; i++)
            for (int j = 0; j < N / 2; j++) {
                //заполнение каждой четверти итогового магического квадрата сформированным квадратом нечетного порядка
                array[i][j] = array[i][j + N / 2] = array[i + N / 2][j] = array[i + N / 2][j + N / 2] = arrayHelp[i][j];
            }
        for (int i = 0; i < N / 2; i++)
            for (int j = 0; j < N / 2; j++) { //формирование вспомогательного квадрата
                arraySecondary[i][j] = 0;
                arraySecondary[i][j + N / 2] = 2 * (N / 2) * (N / 2);
                arraySecondary[i + N / 2][j] = 3 * (N / 2) * (N / 2);
                arraySecondary[i + N / 2][j + N / 2] = (N / 2) * (N / 2);
            }
        for (int i = 0; i < N / 2; i++)
            for (int j = 0; j < (N - 2) / 4; j++) {
                if (i == (N / 2 - 1) / 2 || i == (N / 2 - 1) / 2 + N / 2) {
                    arraySecondary[i][j + 1] = 3 * (N / 2) * (N / 2);
                    arraySecondary[i + N / 2][j + 1] = 0;
                    continue;
                }
                arraySecondary[i][j] = 3 * (N / 2) * (N / 2);
                arraySecondary[i + N / 2][j] = 0;
            }

        for (int j = N - ((N - 2) / 4 - 1); j < N; j++)
            for (int i = 0; i < N / 2; i++) {
                arraySecondary[i][j] = (N / 2) * (N / 2);
                arraySecondary[i + N / 2][j] = 2 * (N / 2) * (N / 2);
            }
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                array[i][j] = array[i][j] + arraySecondary[i][j]; //итоговый магический квадрат порядка одинарной четности
            }
        return array;
    }

    public static int[][] MagicSquare24(int N) {
        //Магический квадрат порядка двойной четности
        int[][] array = new int[N][N];
        int number = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                number++;
                // выделение промежуточных квадратов и их заполнение прямым счетом
                if ((i <= N / 4 - 1 && j <= N / 4 - 1) || (i >= (N - N / 4) && j <= N / 4 - 1) ||
                        (i <= N / 4 - 1 && j >= N - N / 4) || (i >= N - N / 4 && j >= N - N / 4) ||
                        (i > N / 4 - 1 && i < N - N / 4 && j > N / 4 - 1 && j < N - N / 4)) {
                    array[i][j] = number;
                }
            }
        number = N * N + 1;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                number--;
                //заполнение оставшихся ячеек обратным счетом
                if (!((i <= N / 4 - 1 && j <= N / 4 - 1) || (i >= (N - N / 4) && j <= N / 4 - 1) ||
                        (i <= N / 4 - 1 && j >= N - N / 4) || (i >= N - N / 4 && j >= N - N / 4) ||
                        (i > N / 4 - 1 && i < N - N / 4 && j > N / 4 - 1 && j < N - N / 4))) {
                    array[i][j] = number;
                }
            }
        return array;
    }

    public static Integer BinarySearch(int[] array, int number, int first, int last) {
        //двоичный поиск индекса для вставки элемента (сортировка вставками)
        int index = -1; //индекс для вставки искомого элемента
        if (number < array[0]) {
            return 0;
        }
        while (first <= last && index == -1) {
            int mid = (first + last) / 2; //находим центральный элемент
            if (array[mid] <= number && array[mid + 1] > number) { //место для элемента найдено, записываем индекс
                index = mid;
            } else if (array[mid] >= number && array[mid + 1] >= number) { //если центральный элемент и следующий больше искомого
                last = mid - 1;//перемещаем последний индекс на один влево после центрального
            } else if (array[mid] <= number && array[mid + 1] <= number) { //если центральный элемент и следующий меньше искомого
                first = mid + 1; //перемещаем первый индекс на один вправо после центрального
            }
        }
        return index + 1;
    }

    public static Integer GCD(int a, int b) {
        //поиск наибольшего общего делителя для двух чисел a и b
        int change;
        if (b == 0) {
            return Math.abs(a);
        }
        while (b != 0) {
            change = a % b;
            a = b;
            b = change;
        }
        return a;
    }

    public static Integer LCM(int a, int b) {
        //поиск наименьшего общего кратного для двух чисел a и b
        return a / GCD(a, b) * b;
    }

    public static Double EquilateralTriangle(double a) {
        //поиск площади равностороннего треугольника
        return (a * a) / 4 * Math.pow(3, 0.5);
    }

    public static double DistanceAB(int[] a, int[] b) {
        //поиск расстояния между точками a и b
        return Math.pow(((b[0] - a[0]) * (b[0] - a[0]) + (b[1] - a[1]) * (b[1] - a[1])), 0.5);
    }

    public static String SearchSecondMax(int[] array, int N) {
        //поиск второго по величине элемента
        int maxFirst = Integer.MIN_VALUE; //максимальный элемент
        int maxSecond = Integer.MIN_VALUE; //второй по величине элемент
        for (int i = 0; i < N; i++) {
            //поиск максимального и второго по величине элемента
            if (array[i] > maxFirst) {
                maxSecond = maxFirst;
                maxFirst = array[i];
            } else if (array[i] > maxSecond && array[i] != maxFirst) {
                maxSecond = array[i];
            }
        }
        return ("\nМаксимальный элемент равен: " + maxFirst + "\nВторой по величине элемент равен: " + maxSecond);
    }

    public static int Factorial(int number) {
        //поиск факториала числа number
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }


    public static double SumArray(int k, int m, double[] array) {
        //поиск суммы элементов массива с номерами от k до m
        double sum = 0; //сумма элементов массива с номерами от k до m
        for (int i = k - 1; i < m; i++)
            sum += array[i]; //поиск суммы
        return sum;
    }

    public static double SquareRightTriangle(double x, double y) {
        //определение площади прямоугольного треугольника
        return x * y / 2;
    }

    public static double SquareTriangle(double x, double y, double z) {
        //определение площади треугольника
        double p;
        p = (x + y + z) / 2;//полупериметр треугольника
        return Math.pow((p * (p - x) * (p - y) * (p - z)), 0.5);
    }

    public static int NumberSum(int number) { //определение суммы цифр натурального числа
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static int NumberCount(int number) { //определение количества цифр натурального числа
        int count = 0;
        while (number > 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    public static boolean PrimeNumber(int number) { //определение является ли число простым
        int dividers = 0;//число делителей
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                dividers++;
            }
        }
        return dividers == 2;//если количество делителей равно 2, число является простым
    }

    public static boolean ArmstrongNumber(int number) { //определение является ли натуральное число числом Армстронга
        String[] array = Task1.NumberComposition(number).split(" ");
        int sumArmstrong = 0;
        for (String s : array) {
            sumArmstrong += Math.pow(Integer.parseInt(s), NumberCount(number));
        }
        return sumArmstrong == number;
    }

    public static boolean IncreasingSequence(int number) {
        //определение является ли состав натурального числа возрастающей последовательностью
        String[] array = Task1.NumberComposition(number).split(" ");
        for (int i = 0; i < array.length - 1; i++) {
            if (Integer.parseInt(array[i]) >= Integer.parseInt(array[i + 1])) {
                return false;
            }
        }
        return true;
    }


    public static boolean OddNumbers(int number) {
        //определение является ли состав натурального числа нечетным
        String[] array = Task1.NumberComposition(number).split(" ");
        for (String s : array) {
            if (Integer.parseInt(s) % 2 == 0) {
                return false;
            }
        }
        return true;
    }

    public static int CountEven(int number) {
        //определение количества четных цифр в натуральном числе
        int count = 0;
        String[] array = Task1.NumberComposition(number).split(" ");
        for (String s : array) {
            if (Integer.parseInt(s) % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static String Array1_1(int N, int K) {
        //1. В массив A [N] занесены натуральные числа.
        //Найти сумму тех элементов, которые кратны данному K.
        int sum = 0;
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = i + 1;
            if (array[i] % K == 0) {
                sum += array[i];
            }
        }
        return ("\n________________________________\n\n1. В массив A [N] занесены натуральные числа." +
                "\nНайти сумму тех элементов, которые кратны данному К.\n" +
                "Количество элементов массива = " + N + "\nK = " + K + "\n\nОтвет:" +
                "\n\nСумма элементов, кратных К = " + sum);
    }

    public static String Array1_2(int N, double Z) {
        //2. Дана последовательность действительных чисел а1, а2, ..., аn.
        // Заменить все ее члены, большие данного Z, этим числом. Подсчитать количество замен.
        int count = 0; //количество замен
        StringBuilder arrayString = new StringBuilder(); //для записи исходного массива
        StringBuilder arrayNew = new StringBuilder();    //для записи итогового массива
        double[] array = new double[N];
        for (int i = 0; i < N; i++) {
            array[i] = Math.round((Math.random() * 201 - 100) * 10.0) / 10.0; //заполнение массива случайными числами от -100 до 100
            arrayString.append(array[i]).append("; ");
            if (array[i] > Z) {
                array[i] = Z;
                count++;
            }
            arrayNew.append(array[i]).append("; ");
        }
        return ("\n________________________________\n\n2. Дана последовательность действительных" +
                "\nчисел а1 ,а2 ,..., ап.Заменить все ее члены, " +
                "\nбольшие данного Z,этим числом.Подсчитать количество замен." +
                "\nN = " + N + "\nZ = " + Z + "\n\nОтвет:" +
                "\n\nИсходный массив: " + arrayString + "\nИтоговый массив: " + arrayNew +
                "\nКоличество замен: " + count);
    }

    public static String Array1_3(int N) {
        //3. Дан массив действительных чисел, размерность которого N.
        // Подсчитать, сколько в нем отрицательных, положительных и нулевых элементов.
        int countPositive = 0; //положительные элементы
        int countNegative = 0; //отрицательные элементы
        int countZero = 0; //нулевые элементы
        StringBuilder arrayString = new StringBuilder(); //для записи исходного массива
        double[] array = new double[N];
        for (int i = 0; i < N; i++) {
            array[i] = Math.round((Math.random() * 201 - 100) * 10.0) / 10.0; //заполнение массива случайными числами от -100 до 100
            arrayString.append(array[i]).append("; ");
            if (array[i] > 0) {
                countPositive++;
            } else if (array[i] < 0) {
                countNegative++;
            } else {
                countZero++;
            }
        }
        return ("\n________________________________\n\n3. Дан массив действительных чисел, " +
                "размерность которого N. \nПодсчитать, сколько в нем отрицательных, " +
                "\nположительных и нулевых элементов." + "\nN = " + N + "\n\nОтвет:" +
                "\n\nИсходный массив: " + arrayString + "\nКоличество положительных элементов: " + countPositive +
                "\nКоличество отрицательных элементов: " + countNegative +
                "\nКоличество нулевых элементов: " + countZero);
    }

    public static String Array1_4(int N) {
        //4. Даны действительные числа а1, а2, ..., аn.
        //Поменять местами наибольший и наименьший элементы.
        double maxElem; //наибольший элемент
        double minElem; //наименьший элемент
        int maxIndex; //индекс наибольшего элемента
        int minIndex; //индекс наименьшего элемента
        double change; //вспомогательная переменная для перемены элементов
        StringBuilder arrayString = new StringBuilder(); //для записи исходного массива
        StringBuilder arrayNew = new StringBuilder(); //для записи итогового массива
        double[] array = new double[N];
        array[0] = Math.round((Math.random() * 201 - 100) * 10.0) / 10.0; //заполнение первого элемента массива случайными числами от -100 до 100
        arrayString.append(array[0]).append("; ");
        maxElem = array[0];
        maxIndex = 0;
        minElem = array[0];
        minIndex = 0;
        for (int i = 1; i < N; i++) {
            array[i] = Math.round((Math.random() * 200 - 100) * 10.0) / 10.0; ////заполнение массива случайными числами от -100 до 100
            arrayString.append(array[i]).append("; ");
            if (array[i] > maxElem) { //поиск максимального элемента и его индекса
                maxElem = array[i];
                maxIndex = i;
            }
            if (array[i] < minElem) { //поиск минимального элемента и его индекса
                minElem = array[i];
                minIndex = i;
            }
        }
        //перемена местами минимального и максимального элемента
        change = array[minIndex];
        array[minIndex] = array[maxIndex];
        array[maxIndex] = change;
        for (int i = 0; i < N; i++) {
            arrayNew.append(array[i]).append("; "); //заполнение строки итоговыми значениями массива
        }
        return ("\n________________________________\n\n4. Даны действительные числа а1 ,а2 ,..., аn ." +
                "\nПоменять местами наибольший и наименьший элементы." +
                "\nN = " + N + "\n\nОтвет:" + "\nМинимальный элемент: " + minElem +
                "\nМаксимальный элемент: " + maxElem +
                "\n\nИсходный массив: " + arrayString + "\nИтоговый массив: " + arrayNew);
    }

    public static String Array1_5(int N) {
        //5. Даны целые числа а1 ,а2 ,..., аn . Вывести на печать только те числа, для которых ai > i.
        Random myRandom = new Random();
        StringBuilder arrayString = new StringBuilder(); //для записи исходного массива
        StringBuilder arrayNew = new StringBuilder(); //для записи итогового массива
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = myRandom.nextInt(201) - 100; //заполнение массива случайными целыми числами от -100 до 100
            arrayString.append(array[i]).append("; ");
            if (array[i] > i) {
                arrayNew.append(array[i]).append("; "); //заполнение строки элементами массива, для которых ai > i
            }
        }
        return ("\n________________________________\n\n5. Даны целые числа а1 ,а2 ,..., аn . " +
                "\nВывести на печать только те числа, для которых аi > i." + "\nN = " + N +
                "\n\nОтвет:" + "\nМассив: " + arrayString + "\nЭлементы, для которых ai>i: " + arrayNew);

    }

    public static String Array1_6(int N) {
        //6. Задана последовательность N вещественных чисел. Вычислить сумму чисел, порядковые номера которых
        //являются простыми числами.
        StringBuilder arrayString = new StringBuilder(); //для записи исходного массива
        StringBuilder indexString = new StringBuilder(); //для записи итогового массива
        double sum = 0; //сумма чисел, порядковые номера которых простые числа
        int count = 0; //количество делителей
        double[] array = new double[N];
        array[0] = Math.round((Math.random() * 201 - 100) * 10.0) / 10.0; //заполнение первого элемента массива случайными числами от -100 до 100
        arrayString.append(array[0]).append("; ");
        for (int i = 1; i < N; i++) {
            array[i] = Math.round((Math.random() * 200 - 100) * 10.0) / 10.0; //заполнение массива случайными числами от -100 до 100
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++; //поиск количества делителей
                }
            }
            if (count == 2) { //если число простое (имеет два делителя), определяется сумма
                sum += array[i];
                indexString.append(i).append("; ");
            }
            count = 0;
            arrayString.append(array[i]).append("; ");
        }
        return ("\n________________________________\n\n6. Задана последовательность N вещественных чисел." +
                "\nВычислить сумму чисел, порядковые номера которых \nявляются простыми числами."
                + "\nN = " + N + "\n\nОтвет:" + "\nМассив: " + arrayString + "\nИндексы элементов, по которым" +
                " определялась сумма: " + indexString + "\nСумма составила: " + Math.round(sum * 10.0) / 10.0);
    }

    public static String Array1_7(int N) {
        //7. Даны действительные числа a1, a2,...,an. Найти
        //max(a1+a2n,a2+a2n-1,...,an+an+1 ).
        if (N % 2 == 0) {
            StringBuilder arrayString = new StringBuilder(); //для записи массива
            double[] array = new double[N];
            double max; //максимальное значение
            double sum; //сумма элементов по парам
            for (int i = 0; i < N; i++) {
                array[i] = Math.round((Math.random() * 201 - 100) * 10.0) / 10.0; ////заполнение массива случайными числами от -100 до 100
                arrayString.append(array[i]).append("; ");
            }
            max = array[0] + array[N - 1];
            for (int i = 1; i < N / 2; i++) { //поиск максимальной суммы
                sum = array[i] + array[N - i - 1];
                if (sum > max) {
                    max = sum;
                }
            }
            return ("\n________________________________\n\n7. Даны действительные числа a1, a2,...,an." +
                    "\nНайти max(a1+a2n,a2+a2n-1,...,an+an+1 ).\nN = " + N + "\n\nОтвет:\nМассив: " + arrayString +
                    "\nМаксимум: " + max);
        } else { //если задано нечетное количество элементов массива
            return ("\n________________________________\n\n7. Даны действительные числа a1, a2,...,an." +
                    "\nНайти max(a1+a2n,a2+a2n-1,...,an+an+1 ).\nN = " + N +
                    "\n\nОтвет:\nКоличество элементов массива должно быть четным.");
        }

    }

    public static String Array1_8(int N) {
        /*8. Дана последовательность целых чисел а1, а2, ..., аn.
        Образовать новую последовательность, выбросив из
        исходной те члены, которые равны min(a1, a2 , ... , an).*/
        Random myRandom = new Random();
        StringBuilder arrayString = new StringBuilder(); //для записи исходного массива
        StringBuilder arrayStringNew = new StringBuilder(); //для записи итогового массива
        int count = 0; // количество элементов равных минимальному
        int min;
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = myRandom.nextInt(201) - 100; //заполнение массива случайными целыми числами от -100 до 100
            arrayString.append(array[i]).append("; ");
        }
        min = array[0];
        for (int i = 1; i < N; i++) { //поиск минимального элемента
            if (array[i] < min) {
                min = array[i];
            }
        }
        for (int i = 0; i < N; i++) {
            if (array[i] == min) {
                count++;
            }
        }
        int[] arrayNew = new int[N - count]; //создание нового массива с меньшей размерностью без учета элементов равных минимальному
        int j = 0;
        for (int i = 0; i < N; i++) {
            if (array[i] != min) {
                arrayNew[j] = array[i];
                arrayStringNew.append(arrayNew[j]).append("; ");
                j++;
            }
        }
        return ("\n________________________________\n\n8. Дана последовательность целых чисел а1, а2, ..., аn." +
                "\nОбразовать новую последовательность, выбросив из\nисходной те члены, " +
                "которые равны min(a1, a2 , ... , an). N = " + N + "\n\nОтвет:\nМинимум: " + min +
                "\nИсходный массив: " + arrayString + "\nИтоговый массив: " + arrayStringNew);
    }

    public static String Array1_9(int N) {
        /*9. В массиве целых чисел с количеством элементов n
        найти наиболее часто встречающееся число. Если таких
        чисел несколько, то определить наименьшее из них.*/
        Random myRandom = new Random();
        StringBuilder arrayString = new StringBuilder(); //для записи исходного массива
        int indexMax = 0; //индекс элемента с наибольшим количеством повторений
        int[] array = new int[N]; //исходный массив
        int[] repeat = new int[N]; //массив количества повторений элемента
        for (int i = 0; i < N; i++) {
            array[i] = myRandom.nextInt(101); //заполнение массива случайными целыми числами от 0 до 100
            arrayString.append(array[i]).append("; ");
        }
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (array[i] == array[j]) {
                    repeat[i]++; //определение количества повторений элемента
                }
                if (repeat[i] > repeat[indexMax]) {
                    indexMax = i; //поиск индекса элемента с максимальным количеством повторений
                } else if (repeat[i] == repeat[indexMax]) {
                    indexMax = array[i] < array[indexMax] ? i : indexMax; //поиск минимального элемента при одинаковом количестве повторений
                }
            }
        }
        return ("\n________________________________\n\n9. В массиве целых чисел с количеством элементов n" +
                "\nнайти наиболее часто встречающееся число. Если таких \nчисел несколько, то определить " +
                "наименьшее из них \nN = " + N + "\n\nОтвет: \nМассив: " + arrayString +
                "\nНаиболее часто встречающееся число: " + array[indexMax]);
    }

    public static String Array1_10(int N) {
        /*10. Дан целочисленный массив с количеством элементов п.
        Сжать массив, выбросив из него каждый второй
        элемент (освободившиеся элементы заполнить нулями).
        Примечание. Дополнительный массив не использовать.*/
        Random myRandom = new Random();
        StringBuilder arrayString = new StringBuilder(); //для записи исходного массива
        StringBuilder arrayStringNew = new StringBuilder(); //для записи нового массива
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = myRandom.nextInt(101); //заполнение массива случайными целыми числами от 0 до 100
            arrayString.append(array[i]).append("; ");
        }
        for (int i = 0; i < (N + 1) / 2; i++) {
            array[i] = array[i * 2]; //сжатие массива
            arrayStringNew.append(array[i]).append("; ");
        }
        for (int i = (N + 1) / 2; i < N; i++) {
            array[i] = 0; //заполнение свободных элементов нулями
            arrayStringNew.append(array[i]).append("; ");
        }
        return ("\n________________________________\n\n9. В массиве целых чисел с количеством элементов n" +
                "\nнайти наиболее часто встречающееся число. Если таких \nчисел несколько, то определить " +
                "наименьшее из них \nN = " + N + "\n\nОтвет: \nИсходный массив: " + arrayString +
                "\nИтоговый массив: " + arrayStringNew + "\n________________________________\n");
    }

    public static String Array2_1(int N, int M) {
        //1. Дана матрица. Вывести на экран все нечетные столбцы,
        // у которых первый элемент больше последнего.
        Random myRandom = new Random();
        StringBuilder arrayColumn = new StringBuilder(); //для вывода нечетных столбцов, у которых первый элемент больше последнего
        int[][] array = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                array[i][j] = myRandom.nextInt(101); //заполнение матрицы случайными целыми числами от 0 до 100
            }
        }
        //запись нечетных столбцов, у которых первый элемент больше последнего
        for (int i = 0; i < N; i++) {
            arrayColumn.append("\n");
            for (int j = 0; j < M; j++)
                if ((j + 1) % 2 != 0 && array[0][j] > array[N - 1][j]) {
                    {
                        arrayColumn.append(array[i][j]);
                        if (array[i][j] < 10) {
                            arrayColumn.append("  ");
                        } else {
                            arrayColumn.append(" ");
                        }
                    }
                }
        }
        return ("\n________________________________\n\n1. Дана матрица. Вывести на экран все нечетные столбцы," +
                "\nу которых первый элемент больше последнего. \nЧисло строк = " + N + "\nЧисло столбцов = " + M +
                "\n\nОтвет: \n\nИсходный массив: " + ArrayOutputI(N, M, array) + "\n\nСтолбцы: " + arrayColumn);
    }

    public static String Array2_2(int N) {
        //2. Дана квадратная матрица. Вывести на экран элементы,
        // стоящие на диагонали.
        Random myRandom = new Random();
        StringBuilder arrayDiagonal = new StringBuilder(); //для вывода элементов, стоящих на диагонали
        int[][] array = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = myRandom.nextInt(101); //заполнение матрицы случайными целыми числами от 0 до 100
            }
        }
        //вывод элементов на диагонали
        for (int i = 0; i < N; i++) {
            arrayDiagonal.append("\n");
            for (int j = 0; j < N; j++)
                if (i == j) {
                    arrayDiagonal.append(array[i][j]);
                    if (array[i][j] < 10) {
                        arrayDiagonal.append("  ");
                    } else {
                        arrayDiagonal.append(" ");
                    }
                } else {
                    arrayDiagonal.append("   ");
                }
        }
        return ("\n________________________________\n\n2. Дана квадратная матрица. Вывести на экран элементы," +
                "\nстоящие на диагонали. \nЧисло строк = " + N + "\nЧисло столбцов = " + N +
                "\n\nОтвет: \n\nИсходный массив: " + ArrayOutputI(N, N, array) + "\n\nДиагональ: " + arrayDiagonal);
    }

    public static String Array2_3(int N, int M) {
        //3. Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
        Random myRandom = new Random();
        int k = myRandom.nextInt(N); //формирование случайного номера строки для вывода от 0 до количества строк
        int p = myRandom.nextInt(M); //формирование случайного номера столбца для вывода от 0 до количества столбцов
        StringBuilder arrayRez = new StringBuilder(); //для вывода выбранной строки и столбца
        int[][] array = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                array[i][j] = myRandom.nextInt(101);  //заполнение матрицы случайными целыми числами от 0 до 100
            }
        }
        //запись выбранной строки и столбца
        for (int i = 0; i < N; i++) {
            arrayRez.append("\n");
            for (int j = 0; j < M; j++)
                if (i == k || j == p) {
                    arrayRez.append(array[i][j]);
                    if (array[i][j] < 10) {
                        arrayRez.append("  ");
                    } else {
                        arrayRez.append(" ");
                    }
                } else {
                    arrayRez.append("   ");
                }
        }
        return ("\n________________________________\n\n3. Дана матрица. Вывести k-ю строку и p-й столбец матрицы." +
                "\nЧисло строк = " + N + "\nЧисло столбцов = " + M + "\nСтрока для вывода = " + (k + 1) +
                "\nСтолбец для вывода = " + (p + 1) + "\n\nОтвет: \n\nИсходный массив: " + ArrayOutputI(N, M, array) +
                "\n\nСтолбец + строка: " + arrayRez);
    }

    public static String Array2_4(int N) {
        /*4. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
        (1,   2,  3, ...,n;
         n, n-1, n-2,...,1
         1,  2,   3,...,n;
         n, n-1, n-2,...,1;
         ...;
         n, n-1, n-2,...,1)*/
        if (N % 2 == 0) {
            int[][] array = new int[N][N];
            //заполнение матрицы по заданному условию
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if ((i + 1) % 2 != 0) {
                        array[i][j] = j + 1;
                    } else {
                        array[i][j] = N - j;
                    }
                }
            }
            return ("\n________________________________\n\n4. Сформировать квадратную матрицу порядка n \nпо заданному " +
                    "образцу(n - четное): \n(1,   2,  3, ...,n;\nn, n-1, n-2,...,1; \n(1,   2,  3, ...,n;" +
                    "\nn, n-1, n-2,...,1;\n...;\nn, n-1, n-2,...,1" + "\nN = " + N + "\n\nОтвет: \n\nМассив: " +
                    ArrayOutputI(N, N, array));
        } else {
            return ("\n________________________________\n\n4. Сформировать квадратную матрицу порядка n \nпо заданному " +
                    "образцу(n - четное): \n(1,   2,  3, ...,n;\nn, n-1, n-2,...,1; \n(1,   2,  3, ...,n;" +
                    "\nn, n-1, n-2,...,1;\n...;\nn, n-1, n-2,...,1" + "\nN = " + N +
                    "\n\nОтвет:\nКоличество элементов массива должно быть четным.");
        }
    }

    public static String Array2_5(int N) {
        /* 5. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
        (1   1   1 ... 1 1 1
         2   2   2 ... 2 2 0
         3   3   3 ... 3 0 0
         n-1 n-1 0 ... 0 0 0
         n   0   0 ... 0 0 0)*/
        if (N % 2 == 0) {
            int[][] array = new int[N][N];
            //заполнение матрицы по заданному условию
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (j < N - i) {
                        array[i][j] = i + 1;
                    } else {
                        array[i][j] = 0;
                    }
                }
            }
            return ("\n________________________________\n\n5. Сформировать квадратную матрицу порядка n \nпо заданному " +
                    "образцу(n - четное): \n(1   1   1 ... 1 1 1;\n2   2   2 ... 2 2 0; \n3   3   3 ... 3 0 0;" +
                    "\n...;\nn-1 n-1 0 ... 0 0 0;\nn   0   0 ... 0 0 0)" + "\nN = " + N + "\n\nОтвет: \n\nМассив: " +
                    ArrayOutputI(N, N, array));
        } else {
            return ("\n________________________________\n\n5. Сформировать квадратную матрицу порядка n \nпо заданному " +
                    "образцу(n - четное): \n(1   1   1 ... 1 1 1;\n2   2   2 ... 2 2 0; \n3   3   3 ... 3 0 0;" +
                    "\nn...;\nn-1 n-1 0 ... 0 0 0;\nn   0   0 ... 0 0 0)" + "\nN = " + N +
                    "\n\nОтвет:\nКоличество элементов массива должно быть четным.");
        }
    }

    public static String Array2_6(int N) {
        /* 6. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
        (1   1   1 ... 1 1 1
         0   1   1 ... 1 1 0
         0   0   1 ... 1 0 0
         ...
         0   1   1 ... 1 1 0
         1   1   1 ... 1 1 1)*/
        if (N % 2 == 0) {
            int[][] array = new int[N][N];
            //заполнение матрицы по заданному условию
            for (int i = 0; i < (N / 2); i++) {
                for (int j = 0; j < N; j++) {
                    if (i <= j && j < (N - i)) {
                        array[i][j] = 1;
                        array[N - 1 - i][j] = 1;
                    } else {
                        array[i][j] = 0;
                        array[N - 1 - i][j] = 0;
                    }
                }
            }
            return ("\n________________________________\n\n5. Сформировать квадратную матрицу порядка n \nпо заданному " +
                    "образцу(n - четное): \n(1   1   1 ... 1 1 1;\n 0   1   1 ... 1 1 0; \n0   0   1 ... 1 0 0;" +
                    "\n...;\n0   1   1 ... 1 1 0;\n1   1   1 ... 1 1 1)" + "\nN = " + N + "\n\nОтвет: \n\nМассив: " +
                    ArrayOutputI(N, N, array));
        } else {
            return ("\n________________________________\n\n5. Сформировать квадратную матрицу порядка n \nпо заданному " +
                    "образцу(n - четное): \n(1   1   1 ... 1 1 1;\n 0   1   1 ... 1 1 0; \n0   0   1 ... 1 0 0;" +
                    "\n...;\n0   1   1 ... 1 1 0;\n1   1   1 ... 1 1 1)" + "\nN = " + N +
                    "\n\nОтвет:\nКоличество элементов массива должно быть четным.");
        }
    }

    public static String Array2_7(int N) {
        /* 7. Сформировать квадратную матрицу порядка N по правилу:
        A(i,j)=sin((i*i-j*j)/N)
        и подсчитать количество положительных элементов в ней.*/
        double[][] array = new double[N][N];
        int countPositive = 0; //количество положительных элементов
        //заполнение матрицы по заданному условию
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = Math.round(Math.sin((double) (i * i - j * j) / N) * 10.0) / 10.0;
                if (array[i][j] > 0) {
                    countPositive++;
                }
            }
        }
        return ("\n________________________________\n\n7. Сформировать квадратную матрицу порядка N по правилу:" +
                "\nA(i,j)=sin((i*i-j*j)/N)" + "\nи подсчитать количество положительных элементов в ней." +
                "\nN = " + N + "\n\nОтвет: \n\nМассив: " + ArrayOutputD(N, N, array) +
                "\nКоличество положительных элементов: " + countPositive);
    }

    public static String Array2_8(int N, int M) {
        //8. В числовой матрице поменять местами два любых столбца.
        //Номера столбцов вводит пользователь с клавиатуры.
        Scanner scanner = new Scanner(System.in);
        StringBuilder arrayString;
        Random myRandom = new Random();
        int oneCol; //первый столбец, который вводит пользователь
        int twoCol; //второй столбец, который вводит пользователь
        int[][] array = new int[N][M];
        int change; //вспомогательная переменная для перемены местами столбцов
        System.out.println("\n________________________________\n\n8.В числовой матрице поменять местами два любых" +
                " столбца.\nНомера столбцов вводит пользователь с клавиатуры.");
        //ввод номера первого столбца пользователем
        do {
            System.out.println("Введите номер первого столбца в диапазоне от 1 до " + M + ":");
            while (!scanner.hasNextInt()) {
                System.out.println("Число не является целым, повторите ввод");
                scanner.next();
            }
            oneCol = scanner.nextInt();
        } while (oneCol <= 1 || oneCol > M);
        //ввод номера второго столбца пользователем
        do {
            System.out.println("Введите номер второго столбца в диапазоне от 1 до " + M + ":");
            while (!scanner.hasNextInt()) {
                System.out.println("Число не является целым, повторите ввод");
                scanner.next();
            }
            twoCol = scanner.nextInt();
        } while (twoCol <= 1 || twoCol > M);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                array[i][j] = myRandom.nextInt(101); //заполнение матрицы случайными целыми числами от 0 до 100
            }
        }
        arrayString = ArrayOutputI(N, M, array);
        //перемена выбранных столбцов местами
        for (int i = 0; i < N; i++) {
            change = array[i][oneCol - 1];
            array[i][oneCol - 1] = array[i][twoCol - 1];
            array[i][twoCol - 1] = change;
        }
        return ("\nЧисло строк = " + N + "\nЧисло столбцов = " + M + "\n\nОтвет: \n\nМассив: " + arrayString +
                "\n\nИтоговый массив: " + ArrayOutputI(N, M, array));
    }

    public static String Array2_9(int N, int M) {
        /*9. Задана матрица неотрицательных чисел.
        Посчитать сумму элементов в каждом столбце.
        Определить, какой столбец содержит максимальную сумму.*/
        StringBuilder sumColumn = new StringBuilder(); //для записи суммы по столбцам
        double sum; //сумма по столбцам
        double max = 0; //максимальное значение суммы по столбцам
        int colMax = 0; //номер столбца, который содержит максимальную сумму
        double[][] array = new double[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                array[i][j] = Math.round((Math.random() * 100) * 10.0) / 10.0; //заполнение матрицы случайными числами от 0 до 100
            }
        }
        for (int j = 0; j < M; j++) {
            sum = 0;
            sumColumn.append("\n");
            for (int i = 0; i < N; i++) {
                sum += array[i][j]; //определение суммы j-го столбца
            }
            sumColumn.append(j + 1).append(" столбец: ").append(Math.round(sum * 10.0) / 10.0);
            if (max < sum) { //поиск максимальной суммы столбца и номера столбца с максимальной суммой
                max = Math.round(sum * 10.0) / 10.0;
                colMax = j + 1;

            }
        }
        return ("\n________________________________\n\n9. Задана матрица неотрицательных чисел." +
                "\nПосчитать сумму элементов в каждом столбце.\nОпределить, какой столбец содержит максимальную сумму." +
                "\nЧисло строк = " + N + "\nЧисло столбцов = " + M + "\n\nОтвет: \n\nМассив: "
                + ArrayOutputD(N, M, array) + "\n\nСумма по столбцам: " + sumColumn + "\n\nМаксимальная сумма: "
                + max + " в столбце " + colMax);
    }

    public static String Array2_10(int N) {
        //10. Найти положительные элементы главной
        // диагонали квадратной матрицы.
        Random myRandom = new Random();
        StringBuilder arrayDiagonal = new StringBuilder(); //для записи положительных элементов главной диагонали
        int[][] array = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = myRandom.nextInt(201) - 100; //заполнение матрицы случайными числами от -100 до 100
            }
        }
        //запись положительных элементов главной диагонали
        for (int i = 0; i < N; i++) {
            arrayDiagonal.append("\n");
            for (int j = 0; j < N; j++)
                if (i == j && array[i][j] > 0) {
                    arrayDiagonal.append(array[i][j]);
                    if (array[i][j] < 10) {
                        arrayDiagonal.append("  ");
                    } else {
                        arrayDiagonal.append(" ");
                    }
                } else {
                    arrayDiagonal.append("   ");
                }
        }
        return ("\n________________________________\n\n10. Найти положительные элементы главной" +
                "\nдиагонали квадратной матрицы. \nЧисло строк = " + N + "\nЧисло столбцов = " + N +
                "\n\nОтвет: \n\nИсходный массив: " + ArrayOutputI(N, N, array) + "\n\nГлавная диагональ из положительных элементов:" +
                arrayDiagonal);
    }

    public static String Array2_11() {
        /*11. Матрицу 10x20 заполнить случайными числами от 0 до 15.
        Вывести на экран саму матрицу и номера строк,
        в которых число 5 встречается три и более раза.*/
        StringBuilder row = new StringBuilder(); //для записи номеров строк, в которых 5 встречается три и более раза
        Random myRandom = new Random();
        int[][] array = new int[10][20];
        int count; //для определения количества цифры 5 по строкам
        for (int i = 0; i < 10; i++) {
            count = 0;
            for (int j = 0; j < 20; j++) {
                array[i][j] = myRandom.nextInt(16); //заполнение матрицы случайными числами от 0 до 15
                if (array[i][j] == 5) {
                    count++;
                }
            }
            //запись номеров строк, в которых 5 встречается три и более раза
            if (count >= 3) {
                row.append(i + 1).append(" строка").append("\n");
            }
        }
        return ("\n________________________________\n\n11. Матрицу 10x20 заполнить случайными числами от 0 до 15." +
                "\nВывести на экран саму матрицу и номера строк, \nв которых число 5 встречается три и более раз." +
                "\n\nОтвет: \n\nИсходный массив: " + ArrayOutputI(10, 20, array) +
                "\n\nНомера строк, в которых 5 повторяется 3 " + "и более раз:\n" + row);
    }

    public static String Array2_12(int N, int M) {
        //12. Отсортировать строки матрицы по возрастанию
        // и убыванию значений элементов.
        Random myRandom = new Random();
        StringBuilder arrayString;
        int[][] array = new int[N][M];
        int[][] reverse = new int[N][M]; //матрица, отсортированная по убыванию в строках
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                array[i][j] = myRandom.nextInt(101); //заполнение матрицы случайными целыми числами от 0 до 100
            }
        }
        arrayString = ArrayOutputI(N, M, array);
        for (int i = 0; i < N; i++) {
            Arrays.sort(array[i]); //сортировка матрицы по возрастанию в строках
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                reverse[i][j] = array[i][M - 1 - j]; //реверс матрицы, отсортированной по возрастанию в строках
            }
        }
        return ("\n________________________________\n\n12. Отсортировать строки матрицы по возрастанию" +
                "\n и убыванию значений элементов." + "\nЧисло строк = " + N + "\nЧисло столбцов = " + M +
                "\n\nОтвет: \n\nИсходный массив: " + arrayString + "\n\nСортировка по строкам по возрастанию:" +
                ArrayOutputI(N, M, array) + "\n\nСортировка по строкам по убыванию:" + ArrayOutputI(N, M, reverse));
    }

    public static String Array2_13(int N, int M) {
        //13. Отсортировать столбцы матрицы по возрастанию
        // и убыванию значений элементов.
        Random myRandom = new Random();
        StringBuilder arrayString;
        boolean sorted;
        int change; //для перемены элементов при сортировке
        int[][] array = new int[N][M];
        int[][] reverse = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                array[i][j] = myRandom.nextInt(100);
            }
        }
        arrayString = ArrayOutputI(N, M, array);
        //сортировка столбцов матрицы по возрастанию методом пузырька
        for (int j = 0; j < M; j++) {
            sorted = false;
            while (!sorted) {
                sorted = true;
                for (int i = 0; i < N - 1; i++) {
                    if (array[i][j] > array[i + 1][j]) {
                        sorted = false;
                        change = array[i][j];
                        array[i][j] = array[i + 1][j];
                        array[i + 1][j] = change;
                    }
                }
            }
        }
        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N; i++) {
                reverse[i][j] = array[N - 1 - i][j]; //реверс матрицы, отсортированной по возрастанию в столбцах
            }
        }
        return ("\n________________________________\n\n13. Отсортировать столбцы матрицы по возрастанию" +
                "\n и убыванию значений элементов." + "\nЧисло строк = " + N + "\nЧисло столбцов = " + M +
                "\n\nОтвет: \n\nИсходный массив: " + arrayString + "\n\nСортировка по столбцам по возрастанию:" +
                ArrayOutputI(N, M, array) + "\n\nСортировка по столбцам по убыванию:" + ArrayOutputI(N, M, reverse));
    }

    public static String Array2_14(int N, int M) {
        //14. Сформировать случайную матрицу m x n, состоящую из нулей и единиц, причем в каждом столбце число
        //единиц равно номеру столбца.
        if (N >= M) {
            StringBuilder arrayString;
            ArrayList<Integer> list = new ArrayList<>();
            int count = 0; //количество единиц в столбце
            int[][] array = new int[N][M];
            for (int j = 0; j < M; j++) {
                for (int i = 0; i < N; i++) {
                    if (count <= j) { //добавление в строку единиц, количество которых равно номеру столбца
                        array[i][j] = 1;
                        count++;
                    }
                    list.add(array[i][j]);
                }
                count = 0;
                Collections.shuffle(list); //перетасовка значений столбца
                for (int k = 0; k < N; k++) {
                    array[k][j] = list.get(count); //заполнение строки перетасованными значениями
                    count++;
                }
                count = 0;
                list.clear();
            }
            arrayString = ArrayOutputI(N, M, array);
            return ("\n________________________________\n\n14. Сформировать случайную матрицу m x n, \nсостоящую из нулей " +
                    "и единиц, причем в каждом столбце число \nединиц равно номеру столбца." +
                    "\nЧисло строк = " + N + "\nЧисло столбцов = " + M + "\n\nОтвет:" + arrayString);
        } else {
            return ("\n________________________________\n\n14. Сформировать случайную матрицу m x n, \nсостоящую из " +
                    "нулей и единиц, причем в каждом столбце число \nединиц равно номеру столбца." +
                    "\nЧисло строк = " + N + "\nЧисло столбцов = " + M + "\n\nОтвет: Количество строк должно быть " +
                    "больше или равно количества столбцов.");
        }

    }

    public static String Array2_15(int N, int M) {
        //15. Найдите наибольший элемент матрицы и заменить
        // все нечетные элементы на него.
        Random myRandom = new Random();
        StringBuilder arrayString;
        int max = 0; //наибольший элемент матрицы
        int[][] array = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                array[i][j] = myRandom.nextInt(101); //заполнение матрицы случайными целыми числами от 0 до 100
            }
        }
        arrayString = ArrayOutputI(N, M, array);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                max = Math.max(array[i][j], max); //поиск максимального элемента матрицы

            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (array[i][j] % 2 != 0) {
                    array[i][j] = max; //замена нечетных элементов на максимальный
                }
            }
        }
        return ("\n________________________________\n\n15. Найдите наибольший элемент матрицы и заменить" +
                "\nвсе нечетные элементы на него." + "\nЧисло строк = " + N + "\nЧисло столбцов = " + M +
                "\n\nОтвет: \n\nИсходный массив: " + arrayString + "\n\nМаксимальный элемент: " +
                max + "\n\nИтоговый массив:" + ArrayOutputI(N, M, array));
    }

    public static String Array2_16(int N) {
        //16. Построить магический квадрат
        int[][] array;
        if (N % 4 == 0) {
            array = MagicSquare24(N); //магический квадрат порядка двойной четности
        } else if (N % 2 != 0) {
            array = MagicSquare(N); //магический квадрат нечетного порядка
        } else {
            array = MagicSquare2(N); //магический квадрат порядка одинарной четности
        }
        return ("\n________________________________\n\n16. Построить магический квадрат" + "\nЧисло строк = " + N +
                "\nЧисло столбцов = " + N + "\n\nМагический квадрат:" + ArrayOutputI(N, N, array));
    }

    public static String Array3_1() {
        /*1. Заданы два одномерных массива с различным количеством элементов и натуральное число k. Объединить их в
        один массив, включив второй массив между k-м и (k+1) - м элементами первого, при этом не используя
        дополнительный массив.*/
        Random myRandom = new Random();
        int lengthOne = myRandom.nextInt(50) + 5; //длина первого массива: представляет собой целое положительное число от 5 до 50
        int lengthTwo = myRandom.nextInt(30) + 5; //длина второго массива: представляет собой целое положительное число от 5 до 30
        int k = myRandom.nextInt(lengthOne - 1) + 1; //номер элемента первого массива, после которого нужно вставить второй массив
        int[] arrayOne = new int[lengthOne];
        int[] arrayTwo = new int[lengthTwo];
        int[] arrayUnion = new int[lengthOne + lengthTwo]; //массив итоговый после объединения
        for (int i = 0; i < lengthOne; i++) {
            arrayOne[i] = myRandom.nextInt(101); //заполнение первого массива случайными целыми числами от 0 до 100
        }
        for (int i = 0; i < lengthTwo; i++) {
            arrayTwo[i] = myRandom.nextInt(101); //заполнение второго массива случайными целыми числами от 0 до 100
        }
        //объединение массивов
        for (int i = 0; i < arrayUnion.length; i++) {
            if (i < k) {
                arrayUnion[i] = arrayOne[i];
            } else if (i < k + lengthTwo) {
                arrayUnion[i] = arrayTwo[i - k];
            } else {
                arrayUnion[i] = arrayOne[i - lengthTwo];
            }
        }
        return ("\n________________________________\n\n1. Заданы два одномерных массива с различным количеством элементов" +
                " и натуральное число k.\nОбъединить их в один массив, включив второй массив между k-м и (k+1)-м" +
                "\nэлементами первого, при этом не использую дополнительный массив.\n\nОтвет\nЧисло элементов первого " +
                "массива = " + lengthOne + "\nПервый массив: " + Arrays.toString(arrayOne) + "\nЧисло элементов второго" +
                " массива = " + lengthTwo + "\nВторой массив: " + Arrays.toString(arrayTwo) + "\nНомер элемента, после " +
                "которого осуществлялось объединение = " + k + "\nОбъединенный массив: " + Arrays.toString(arrayUnion) +
                "\n________________________________\n");
    }

    public static String Array3_2() {
        //2. Даны две последовательности a1 < a2 < ...< an и  b1 < b2 <...< bm. Образовать из них новую последовательность
        //чисел так, чтобы она тоже была неубывающей. Примечание. Дополнительный массив не использовать.
        Random myRandom = new Random();
        int lengthOne = myRandom.nextInt(20) + 1; //длина первой последовательности: представляет собой целое положительное число от 1 до 20
        int lengthTwo = myRandom.nextInt(30) + 1; //длина второй последовательности: представляет собой целое положительное число от 1 до 30
        int[] arrayOne = new int[lengthOne]; //первая последовательность
        int[] arrayTwo = new int[lengthTwo]; //вторая последовательность
        int[] arrayUnion = new int[lengthOne + lengthTwo]; //объединенная последовательность
        for (int i = 0; i < lengthOne; i++) {
            arrayOne[i] = myRandom.nextInt(101); //заполнение первой последовательности случайными целыми числами от 0 до 100
        }
        for (int i = 0; i < lengthTwo; i++) {
            arrayTwo[i] = myRandom.nextInt(101); //заполнение второй последовательности случайными целыми числами от 0 до 100
        }
        Arrays.sort(arrayOne); //отсортированная первая последовательность
        Arrays.sort(arrayTwo); //отсортированная вторая последовательность
        System.arraycopy(arrayOne, 0, arrayUnion, 0, lengthOne); //добавление первой последовательности в итоговую
        System.arraycopy(arrayTwo, 0, arrayUnion, lengthOne, lengthTwo); //добавление второй последовательности в итоговую
        Arrays.sort(arrayUnion); //сортировка объединенной последовательности
        return ("\n________________________________\n\n2. Даны две последовательности a1 < a2 < ...< an и  b1 < b2 <...< bm." +
                "\nОбразовать из них новую последовательность чисел так, \nчтобы она тоже была неубывающей. Примечание. " +
                "\nДополнительный массив не использовать." + "\n\nОтвет:\nЧисло элементов первой последовательности: " +
                lengthOne + "\nПервая последовательность: " + Arrays.toString(arrayOne) + "\nЧисло элементов второй " +
                "последовательности: " + lengthTwo + "\nВторая последовательность: " + Arrays.toString(arrayTwo) +
                "\nОбъединенная последовательность: " + Arrays.toString(arrayUnion));
    }

    public static String Array3_3() {
        /*3. Сортировка выбором. Дана последовательность чисел a1, a2, ... ,an.
        Требуется переставить элементы так, чтобы они были расположены по убыванию. Для этого в массиве, начиная с
        первого, выбирается наибольший элемент и ставится на первое место, а первый - на место наибольшего. Затем,
        начиная со второго, эта процедура повторяется. Написать алгоритм сортировки выбором.*/
        Random myRandom = new Random();
        int max;
        int indexMax; //индекс максимального элемента
        String arrayString; //для записи исходной последовательности
        int change; //для перемены элементов местами
        int length = myRandom.nextInt(50) + 5; //длина последовательности: представляет собой целое положительное число от 5 до 50
        int[] array = new int[length]; //последовательность
        for (int i = 0; i < length; i++) {
            array[i] = myRandom.nextInt(101); //заполнение последовательности случайными целыми числами от 0 до 100
        }
        arrayString = Arrays.toString(array); //запись исходной последовательности
        for (int i = 0; i < length - 1; i++) {
            max = array[i];
            indexMax = i;
            for (int j = i + 1; j < length; j++) { //поиск максимального элемента и его индекса
                if (array[j] > max) {
                    max = array[j];
                    indexMax = j;
                }
            }
            //перемена максимального и последнего элемента последовательности
            change = array[i];
            array[i] = max;
            array[indexMax] = change;
        }
        return ("\n________________________________\n\n3. Сортировка выбором. Дана последовательность чисел a1, a2, ... ,an." +
                "\nТребуется переставить элементы так, чтобы они были расположены по убыванию. \n\nОтвет:" +
                "\nЧисло элементов последовательности: " + length + "\nПоследовательность: " + arrayString +
                "\nОтсортированная по убыванию последовательность: " + Arrays.toString(array));
    }

    public static String Array3_4() {
        /*4. Сортировка обменами. Дана последовательность чисел n a1, a2, ... , an. Требуется переставить числа в
        порядке возрастания. Для этого сравниваются два соседних числа ai + ai+1. Если ai > ai+1, то делается
        перестановка. Так продолжается до тех пор, пока все элементы не станут расположены в порядке возрастания.
        Составить алгоритм сортировки, подсчитывая при этом количества перестановок.*/
        Random myRandom = new Random();
        String arrayString; //для записи исходной последовательности
        int change; //для перемены элементов местами
        int count = 0; //количество перестановок
        boolean check; //проверка на наличие перестановок
        int length = myRandom.nextInt(50) + 5; //длина последовательности: представляет собой целое положительное число от 5 до 50
        int[] array = new int[length]; //последовательность
        for (int i = 0; i < length; i++) {
            array[i] = myRandom.nextInt(101); //заполнение последовательности случайными целыми числами от 0 до 100
        }
        arrayString = Arrays.toString(array); //запись исходной последовательности
        do {
            check = false;
            for (int i = 0; i < length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    check = true; //если были перестановки, переменная принимает значение истина
                    //перемена элементов местами
                    change = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = change;
                    count++; //подсчет количества перестановок
                }
            }
        }
        while (check); //проверка на наличие перестановок
        return ("\n________________________________\n\n4. Сортировка обменами. Дана последовательность чисел a1, a2, ... ,an." +
                "\nТребуется переставить числа в порядке возрастания.  \n\nОтвет:" + "\nЧисло элементов последовательности: " +
                length + "\nПоследовательность: " + arrayString +
                "\nОтсортированная по возрастанию последовательность: " + Arrays.toString(array) + "\nКоличество перестановок: "
                + count);
    }

    public static String Array3_5() {
        /*5. Сортировка вставками. Дана последовательность чисел  a1, a2, ... , an. Требуется переставить числа в порядке
        возрастания. Делается это следующим образом. Пусть  a1, a2, ... , ai - упорядоченная последовательность, т. е.
        a1 <= a2 <=, ... ,<= an.  Берется следующее число ai+1 и вставляется в последовательность так, чтобы новая
        последовательность была тоже возрастающей. Процесс производится до тех пор, пока все элементы от i +1 до n
        не будут перебраны. Примечание. Место помещения очередного элемента в отсортированную часть производить
        с помощью двоичного поиска. Двоичный поиск оформить в виде отдельной функции.*/
        Random myRandom = new Random();
        String arrayString; //для записи исходной последовательности
        int change; //для записи сортируемого элемента
        int index; //индекс для вставки элемента при сортировке
        int length = myRandom.nextInt(50) + 5; //длина последовательности: представляет собой целое положительное число от 5 до 50
        int[] array = new int[length]; //последовательность
        for (int i = 0; i < length; i++) {
            array[i] = myRandom.nextInt(101); //заполнение последовательности случайными целыми числами от 0 до 100
        }
        arrayString = Arrays.toString(array); //запись исходной последовательности
        for (int i = 1; i < length; i++) {
            if (array[i] < array[i - 1]) {  //если элемент i не отсортирован
                change = array[i]; //запись i-го элемента
                index = BinarySearch(array, array[i], 0, i - 1); //поиск индекса для вставки элемента
                System.arraycopy(array, index, array, index + 1, i - index); //сдвиг элементов
                array[index] = change; //запись i-го элемента в найденное место
            }
        }
        return ("\n________________________________\n\n5. Сортировка вставками. Дана последовательность чисел a1, a2, ... ,an." +
                "\nТребуется переставить числа в порядке возрастания.  \n\nОтвет:" + "\nЧисло элементов последовательности: " +
                length + "\nПоследовательность: " + arrayString +
                "\nОтсортированная по возрастанию последовательность: " + Arrays.toString(array));
    }

    public static String Array3_6(int N) {
        /*6. Сортировка Шелла. Дан массив n действительных чисел. Требуется упорядочить его по возрастанию.
        Делается это следующим образом: сравниваются два соседних элемента ai и ai + 1. Если ai <= a1 + 1, то продвигаются
        на один элемент вперед. Если ai > ai+1, то производится перестановка и сдвигаются на один элемент назад.
        Составить алгоритм этой сортировки.*/
        String arrayString; //для записи исходной последовательности
        double change; //для перемены элементов местами
        int k = 0; //для перехода по индексам массива при сортировке
        double[] array = new double[N];
        for (int i = 0; i < N; i++) {
            array[i] = Math.round((Math.random() * 100) * 10.0) / 10.0; //заполнение матрицы случайными числами от 0 до 100
        }
        arrayString = Arrays.toString(array); //запись исходной последовательности
        do {
            if (array[k] <= array[k + 1]) { //если ak <= ak+1 - переход на элемент вперед
                k++;
            } else {
                //если ak > ak+1 - перестановка элементов и переход на элемент назад
                change = array[k];
                array[k] = array[k + 1];
                array[k + 1] = change;
                if (k - 1 >= 0) {
                    k--;
                }
            }
        }
        while (k < N - 1);
        return ("\n________________________________\n\n6. Сортировка Шелла. Дан массив n действительных чисел. " +
                "Требуется упорядочить его по возрастанию. \n\nОтвет:" + "\nЧисло элементов массива: " + N +
                "\nИсходный массив " + arrayString + "\nОтсортированный по возрастанию массив " + Arrays.toString(array));
    }

    public static String Array3_7() {
        /*7. Пусть даны две неубывающие последовательности действительных чисел a1 < a2 < ... < an и b1, b2, ... ,bm.
        Требуется указать те места, на которые нужно вставлять элементы последовательности b1, b2, ..., bm в первую
        последовательность так, чтобы новая последовательность оставалась возрастающей.*/
        Random myRandom = new Random();
        StringBuilder result = new StringBuilder(); //для записи результата поиска
        //длина первой и второй последовательности: представляет собой целое положительное число от 5 до 30
        int lengthOne = myRandom.nextInt(30) + 5;
        int lengthTwo = myRandom.nextInt(30) + 5;
        int[] arrayOne = new int[lengthOne]; //первая последовательность
        int[] arrayTwo = new int[lengthTwo]; //вторая последовательность
        //заполнение первой последовательности случайными целыми числами от 0 до 100
        for (int i = 0; i < lengthOne; i++) {
            arrayOne[i] = myRandom.nextInt(101);
        }
        //заполнение второй последовательности случайными целыми числами от 0 до 100
        for (int i = 0; i < lengthTwo; i++) {
            arrayTwo[i] = myRandom.nextInt(101);
        }
        Arrays.sort(arrayOne); //отсортированная первая последовательность
        Arrays.sort(arrayTwo); //отсортированная вторая последовательность
        for (int i = 0; i < lengthTwo; i++) {
            for (int j = 0; j < lengthOne; j++) {
                if (arrayTwo[i] <= arrayOne[lengthOne - 1]) {//поиск номера для вставки элементов последовательности b
                    if (arrayTwo[i] <= arrayOne[j]) {
                        result.append("\n").append(i + 1).append(" элемент последовательности b нужно вставить до ").append(j + 1).
                                append(" элемента последовательности a");
                        break;
                    }
                } else {
                    result.append("\n").append(i + 1).append(" элемент последовательности b нужно вставить после ").
                            append(lengthOne).append(" элемента последовательности a");
                    break;
                }
            }
        }
        return ("\n________________________________\n\n7. Пусть даны две неубывающие последовательности" +
                "действительных чисел a1 < a2 < ... < an и b1, b2, ... ,bm. \nТребуется указать те места, на которые нужно" +
                "\nвставлять элементы последовательности b1, b2, ... ,bm в первую\nпоследовательность так," +
                " чтобы новая \nпоследовательность оставалась возрастающей. \n\nОтвет:\nЧисло элементов последовательности a: " +
                lengthOne + "\nПоследовательность a:\n" + Arrays.toString(arrayOne) + "\nЧисло элементов последовательности b: " +
                lengthTwo + "\nПоследовательность b:\n" + Arrays.toString(arrayTwo) + result);
    }

    public static String Array3_8(int N) {
        /*6. Даны дроби p1/q1, p2/q2, ... ,pn/qn (pi, qi - натуральные). Составить программу, которая приводит эти дроби
        к общему знаменателю и упорядочивает их в порядке возрастания.*/
        Random myRandom = new Random();
        StringBuilder result = new StringBuilder();//для записи исходных значений дробей
        StringBuilder resultNew = new StringBuilder();//для записи значений дробей, приведенных к общему знаменателю
        Fraction[] fractions = new Fraction[N]; //массив объектов
        int gcd; //НОД
        int lcm; //НОК
        for (int i = 0; i < N; i++) {
            //заполнение объектов "дробь"
            fractions[i] = new Fraction(myRandom.nextInt(8) + 1, myRandom.nextInt(8) + 1);
            //вывод объектов "дробь"
            result.append(fractions[i].numerator).append("/").append(fractions[i].denominator).append(" ");
        }
        gcd = fractions[0].denominator;
        lcm = fractions[0].denominator;
        //определение НОД
        for (int i = 1; i < N; i++) {
            gcd = GCD(gcd, fractions[i].denominator);
        }
        //определение НОК
        for (int i = 1; i < N; i++) {
            lcm = LCM(lcm, fractions[i].denominator);
        }
        //приведение к общему знаменателю
        for (int i = 0; i < N; i++) {
            fractions[i].numerator *= (double) lcm / fractions[i].denominator;
            fractions[i].denominator *= (double) lcm / fractions[i].denominator;
            //вывод объектов "дробь", приведенных к общему знаменателю
            resultNew.append(fractions[i].numerator).append("/").append(fractions[i].denominator).append(" ");
        }
        return ("\n________________________________\n\n8. Даны дроби p1/q1, p2/q2, ... ,pn/qn (pi, qi - натуральные)." +
                "Составить программу, которая приводит эти дроби к общему\n знаменателю и упорядочивает их в порядке " +
                "возрастания.\n\nОтвет:\nЧисло дробей в последовательности: " + N + "\nИсходный массив:\n " + result +
                "\nНОД: " + gcd + "\nНОK: " + lcm + "\nДроби, приведенные к общему знаменателю:\n" + resultNew +
                "\n________________________________\n");
    }

    public static String Array4_1(int a, int b) {
        /*1. Написать метод(методы) для нахождения наибольшего общего делителя и наименьшего общего кратного двух
        натуральных чисел.*/
        return ("\n________________________________\n\n1. Написать метод(методы) для нахождения наибольшего общего делителя" +
                "и наименьшего общего кратного двух.\n\nОтвет:\nПервое число: " + a + "\nВторое число: " + b +
                "\nНОД: " + GCD(a, b) + "\nНОK: " + LCM(a, b));
    }

    public static String Array4_2(int a, int b, int c, int d) {
        /*2. Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел.*/
        return ("\n________________________________\n\n2. Написать метод(методы) для нахождения наибольшего" +
                "общего делителя четырех натуральных чисел.\n\nОтвет:\nПервое число: " + a + "\nВторое число: " + b +
                "\nТретье число: " + c + "\nЧетвертое число: " + d + "\nНОД: " + GCD(d, (GCD(c, (GCD(a, b))))));
    }

    public static String Array4_3(double a) {
        /*3. Вычислить площадь правильного шестиугольника со стороной а, используя метод вычисления площади треугольника.*/
        return ("\n________________________________\n\n2. Написать метод(методы) для нахождения наибольшего" +
                "общего делителя четырех натуральных чисел.\n\nОтвет:\nСторона шестиугольника равна: " + a +
                "\nПлощадь шестиугольника: " + Math.round(6 * EquilateralTriangle(a) * 100.0) / 100.0);
    }

    public static String Array4_4() {
        /*4. На плоскости заданы своими координатами n точек. Написать метод(методы), определяющие, между какими из
        пар точек самое большое расстояние. Указание. Координаты точек занести в массив.*/
        Random myRandom = new Random();
        double maxDistance; //максимальное расстояние между точками
        int maxA; //номер первой точки, по которой найдено максимальное расстояние
        int maxB; //номер второй точки, по которой найдено максимальное расстояние
        int N = myRandom.nextInt(10) + 2; //число точек от 2 до 10
        int[][] arrayPoints = new int[N][2]; //массив точек
        for (int i = 0; i < N; i++)
            for (int j = 0; j < 2; j++) {
                //заполнение координат точек случайными целыми значениями от 0 до 100
                arrayPoints[i][j] = myRandom.nextInt(101);
            }
        maxDistance = DistanceAB(arrayPoints[0], arrayPoints[1]);// максимальное расстояние равно расстоянию между 1 и 2 точкой
        maxA = 1; //номер первой точки, по которой найдено максимальное расстояние равен 1
        maxB = 2; //номер второй точки, по которой найдено максимальное расстояние, равен 2
        if (N > 2) { //если количество точек больше 2
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++)
                    //поиск максимального расстояния между точками и их номеров
                    if (maxDistance < DistanceAB(arrayPoints[i], arrayPoints[j])) {
                        maxDistance = DistanceAB(arrayPoints[i], arrayPoints[j]);
                        maxA = i + 1;
                        maxB = j + 1;
                    }
            }
        }
        return ("\n________________________________\n\n4. На плоскости заданы своими координатами n точек." +
                "\nНаписать метод(методы), определяющие, между какими из\nпар точек самое большое расстояние." +
                "\n\nОтвет:\nКоличество точек: " + N + "\nМассив координат точек: " + ArrayOutputI(N, 2, arrayPoints) +
                "\nМаксимальное расстояние составило " + Math.round(maxDistance * 10.0) / 10.0 +
                " между точкой под номером " + (maxA) + " с координатами (" + arrayPoints[maxA - 1][0] + ":" +
                arrayPoints[maxA - 1][1] + ") и точкой под номером " + (maxB) + " с координатами (" +
                arrayPoints[maxB - 1][0] + ":" + arrayPoints[maxB - 1][1] + ")");
    }

    public static String Array4_5(int N) {
        /*5. Составить программу, которая в массиве A[N] находит второе по величине число.*/
        Random myRandom = new Random();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            //заполнение массива случайными целыми значениями от 0 до 100
            array[i] = myRandom.nextInt(101);
        }

        return ("\n________________________________\n\n5. Составить программу, которая в массиве A[N] \nнаходит второе" +
                " по величине число\n\nОтвет:\nКоличество элементов массива: " + N + "\nМассив:" + Arrays.toString(array) +
                SearchSecondMax(array, N));

    }

    public static String Array4_6(int a, int b, int c) {
        /*6. Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми.*/
        int gcd = GCD(c, GCD(a, b)); //поиск НОД для чисел a, b, c
        if (gcd == 1) {//если НОД 3-х чисел равен единице
            return ("\n________________________________\n\n6. Написать метод(методы), проверяющий, " +
                    "\nявляются ли данные три числа взаимно простыми.\n\nОтвет:\nПервое число: " + a +
                    "\nВторое число: " + b + "\nТретье число: " + c + "\nНОД трех чисел: " + gcd +
                    "\nЧисла являются взаимно простыми.");
        } else {
            return ("\n________________________________\n\n6. Написать метод(методы), проверяющий, " +
                    "\nявляются ли данные три числа взаимно простыми.\n\nОтвет:\nПервое число: " + a +
                    "\nВторое число: " + b + "\nТретье число: " + c + "\nНОД трех чисел: " + gcd +
                    "\nЧисла не являются взаимно простыми.");
        }
    }

    public static String Array4_7() {
        /*7. Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9.*/
        int sumFactorial = 0;//сумма факториалов нечетных чисел от 0 до 9
        for (int i = 1; i <= 9; i++) {
            if (i % 2 != 0) { //если i нечетное
                sumFactorial += Factorial(i); //определяем факториал и считаем сумму
            }
        }
        return ("\n________________________________\n\n7. Написать метод(методы) для вычисления суммы факториалов" +
                "\nвсех нечетных чисел от 1 до 9.\n\nОтвет:\nСумма факториалов всех нечетных чисел от 0 до 9: " +
                sumFactorial);
    }

    public static String Array4_8() {
        /*8. Задан массив D. Определить следующие суммы: D[1] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6].*/
        double[] array = new double[6];
        for (int i = 0; i < 6; i++) {
            array[i] = Math.round((Math.random() * 100) * 10.0) / 10.0; //заполнение массива случайными числами от 0 до 100
        }
        return ("\n________________________________\n\n8. Задан массив D. Определить следующие суммы: D[1] + D[2] + D[3]; " +
                "\nD[3] + D[4] + D[5]; D[4] +D[5] +D[6].\n\nОтвет:\nМассив: " +
                Arrays.toString(array) + "\nСумма 1,2,3 элемента: " + Math.round(SumArray(1, 3, array) * 10.0) / 10.0 +
                "\nСумма 3,4,5 элемента: " + Math.round(SumArray(3, 5, array) * 10.0) / 10.0 + "\nСумма 4,5,6 элемента: "
                + Math.round(SumArray(4, 6, array) * 10.0) / 10.0);
    }


    public static String Array4_9(double x, double y, double z, double w) {
        /*9. Даны числа X, Y, Z, Т — длины сторон четырехугольника. Написать метод(методы) вычисления его площади,
        если угол между сторонами длиной X и Y — прямой.*/
        return ("\n________________________________\n\n9. Даны числа X, Y, Z, Т — длины сторон четырехугольника." +
                "\nНаписать метод(методы) вычисления его площади,\nесли угол между сторонами длиной X и Y— прямой." +
                "\n\nОтвет:\nСтороны прямоугольника: " + x + " " + y + " " + z + " " + w + " \nПлощадь: " +
                Math.round((SquareRightTriangle(x, y) + SquareTriangle(Math.pow((x * x + y * y), 0.5), z, w)) * 10.0) / 10.0);

    }

    public static String Array4_10(int N) {
        /*10. Дано натуральное число N. Написать метод(методы) для формирования массива,
        элементами которого являются цифры числа N.*/
        if (N > 0) {
            //Получение строкового массива, элементы которого представляют собой цифра натурального числа N
            String[] result = Task1.NumberComposition(N).split(" ");
            return ("\n________________________________\n\n10. Дано натуральное число N. Написать метод(методы) для формирования " +
                    "\nмассива элементами которого являются цифры числа N." + "\n\nОтвет:\nИсходное число: "
                    + N + " \nМассив: " + Arrays.toString(result));

        } else {
            return ("\n________________________________\n\n10. Дано натуральное число N. Написать метод(методы) для формирования " +
                    "\nмассива элементами которого являются цифры числа N." + "\n\nОтвет:\nИсходное число должно быть положительным.");
        }
    }

    public static String Array4_11(int N, int M) {
        /*11. Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр.*/
        if (N < 0 || M < 0) {
            return ("\n________________________________\n\n11. Написать метод(методы), определяющий, в каком\n из данных " +
                    "двух чисел больше цифр." + "\n\nОтвет:\nN и M должны быть положительными.");
        } else {
            String[] arrayN = Task1.NumberComposition(N).split(" ");
            //получение строкового массива, элементы которого представляют собой цифры натурального числа M
            String[] arrayM = Task1.NumberComposition(M).split(" ");
            if (arrayN.length > arrayM.length) {
                return ("\n________________________________\n\n11. Написать метод(методы), определяющий, в каком\nиз данных " +
                        "двух чисел больше цифр." + "\n\nОтвет:\nПервое число: " + N + "\nДлина первого числа: " + arrayN.length
                        + "\nВторое число: " + M + "\nДлина второго числа : " + arrayM.length + "\nПервое число длиннее второго");
            } else {
                return ("\n________________________________\n\n11. Написать метод(методы), определяющий, в каком\nиз данных " +
                        "двух чисел больше цифр." + "\n\nОтвет:\nПервое число: " + N + "\nДлина первого числа: " + arrayN.length
                        + "\nВторое число: " + M + "\nДлина второго числа : " + arrayM.length + "\nВторое число длиннее первого");
            }
        }
    }

    public static String Array4_12(int K, int N) {
        /*12. Даны натуральные числа К и N. Написать метод(методы) формирования массива А, элементами которого являются
        числа, сумма цифр которых равна К и которые не большее N.*/
        if (K > 0 && N > 0) {
            int number = 0;//для поиска чисел, удовлетворяющих условию задачи
            StringBuilder result = new StringBuilder();//строка из чисел, которые удовлетворяют поиску
            while (number <= N) {
                if (NumberSum(number) == K) {//проверка равенства суммы цифр числа и K
                    result.append(number).append(" ");//формирование итоговой строки
                }
                number++;
            }
            String[] arrayA = result.toString().split(" ");//формирование итогового массива
            return ("\n________________________________\n\n12. Даны натуральные числа К и N. Написать метод(методы) " +
                    "\nформирования массива А, элементами которого являются\nчисла, сумма цифр которых равна К и которые не " +
                    "большее N." + "\n\nОтвет:\nK: " + K + "\nN: " + N + "\nМассив А: " + Arrays.toString(arrayA));
        } else {
            return ("\n________________________________\n\n12. Даны натуральные числа К и N. Написать метод(методы)" +
                    "\nформирования массива А, элементами которого являются\nчисла, сумма цифр которых равна К и которые не" +
                    "большее N.\n\nОтвет:\nK и N должны быть положительными.");
        }
    }

    public static String Array4_13(int N) {
        /*13. Два простых числа называются «близнецами», если они отличаются друг от друга на 2 (например, 41 и 43).
        Найти и напечатать все пары «близнецов» из отрезка [n,2n], где n - заданное натуральное число больше 2. Для
        решения задачи использовать декомпозицию.*/
        if (N > 2) {
            StringBuilder result = new StringBuilder();
            for (int i = N; i <= 2 * N - 2; i++) {
                if (PrimeNumber(i) && PrimeNumber(i + 2)) {//проверка, являются ли числа простыми
                    result.append("(").append(i).append(":").append(i + 2).append(") ");//запись пар близнецов
                }
            }
            return ("\n________________________________\n\n13. Найти и напечатать все пары «близнецов» из отрезка [n,2n]," +
                    "\nгде n - заданное натуральное число больше 2.\n\nОтвет:\nОтрезок: (" + N + ":" + 2 * N + ")" +
                    "\nПары близнецов: " + result);

        } else {
            return ("\n________________________________\n\n13. Найти и напечатать все пары «близнецов» из отрезка [n,2n]," +
                    "\nгде n - заданное натуральное число больше 2.\n\nОтвет:\nN должно быть больше двух.");
        }
    }

    public static String Array4_14(int K) {
        /*14. Натуральное число, в записи которого n цифр, называется числом Армстронга, если сумма его цифр, возведенная
         в степень n, равна самому числу. Найти все числа Армстронга от 1 до K. Для решения задачи использовать декомпозицию*/
        if (K > 0) {
            StringBuilder result = new StringBuilder();
            for (int i = 1; i <= K; i++) {
                if (ArmstrongNumber(i)) {
                    result.append(i).append("; ");//если число является числом Армстронга, записываем в результирующую строку
                }
            }
            return ("\n________________________________\n\n14. Найти все числа Армстронга от 1 до K.\n\nОтвет:\nK: " + K +
                    "\nЧисла Армстронга: " + result);
        } else {
            return ("\n________________________________\n\n14. Найти все числа Армстронга от 1 до K." +
                    "\n\nОтвет:\nK должно быть положительным.");
        }
    }

    public static String Array4_15(int n) {
        /*15. Найти все натуральные n-значные числа, цифры в которых образуют строго возрастающую последовательность
        (например, 1234, 5789). Для решения задачи использовать декомпозицию.*/
        if (n >= 2) {
            StringBuilder minNumber = new StringBuilder();//верхняя граница диапазона
            StringBuilder maxNumber = new StringBuilder();//нижняя граница диапазона
            StringBuilder result = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                maxNumber.append("9");
                if (i != 1) {
                    minNumber.append("0");
                } else {
                    minNumber.append("1");
                }
            }
            for (int i = Integer.parseInt(minNumber.toString()); i <= Integer.parseInt(maxNumber.toString()); i++) {
                if (IncreasingSequence(i)) {
                    result.append(i).append("; ");//заполнение результирующей строки числами, которые удовлетворяют условию
                }
            }
            return ("\n________________________________\n\n15. Найти все натуральные n-значные числа,  цифры в которых" +
                    "\nобразуют строго возрастающую последовательность.\n\nОтвет:\nn: " + n +
                    "\nНатуральные числа, которые образуют строго возрастающую последовательность:\n" + result);
        } else {
            return ("\n________________________________\n\n15. Найти все натуральные n-значные числа,  цифры в которых" +
                    "\nобразуют строго возрастающую последовательность.\n\nОтвет:\nn должно быть больше единицы.");
        }
    }

    public static String Array4_16(int n) {
        /*16. Написать программу, определяющую сумму n - значных чисел, содержащих только нечетные цифры. Определить также,
         сколько четных цифр в найденной сумме. Для решения задачи использовать декомпозицию. */
        if (n >= 2) {
            StringBuilder minNumber = new StringBuilder();//верхняя граница диапазона
            StringBuilder maxNumber = new StringBuilder();//нижняя граница диапазона
            StringBuilder result = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                maxNumber.append("9");
                if (i != 1) {
                    minNumber.append("0");
                } else {
                    minNumber.append("1");
                }
            }
            for (int i = Integer.parseInt(minNumber.toString()); i <= Integer.parseInt(maxNumber.toString()); i++) {
                if (OddNumbers(i)) {//если число состоит из нечетных чисел
                    //заполнение результирующей строки числами, которые удовлетворяют условию
                    result.append("число ").append(i).append("; сумма цифр =  ").append(NumberSum(i)).
                            append("; количество четных цифр в сумме: ").append(CountEven(NumberSum(i))).append("\n");
                }
            }
            return ("\n________________________________\n\n16. Написать программу, определяющую сумму n - значных чисел, " +
                    "\nсодержащих только нечетные цифры. Определить также,\nсколько четных цифр в найденной сумме." +
                    "\n\nОтвет:\nn: " + n + "\nНатуральные числа, которые образуют строго возрастающую последовательность:\n" + result);
        } else {
            return ("\n________________________________\n\n16. Написать программу, определяющую сумму n - значных чисел, " +
                    "\nсодержащих только нечетные цифры. Определить также,\nсколько четных цифр в найденной сумме.\n\nОтвет:" +
                    "\nn должно быть больше единицы.");
        }
    }

    public static String Array4_17(int n) {
        /*17. Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д.
        Сколько таких действий надо произвести, чтобы получился нуль? Для решения задачи использовать декомпозицию.*/
        if (n > 0) {
            int m = n;
            int count = 0;
            while (m != 0) {//определение количества вычитаний
                m -= NumberSum(m);
                count++;
            }
            return ("\n________________________________\n\n17. Из заданного числа вычли сумму его цифр. " +
                    "\nИз результата вновь вычли сумму его цифр и т.д.\nСколько таких действий надо произвести, чтобы получился нуль?" +
                    "\n\nОтвет:\nИсходное число: " + n + "\nКоличество вычитаний:\n" + count);
        } else {
            return ("\n________________________________\n\n17. Из заданного числа вычли сумму его цифр. " +
                    "\nИз результата вновь вычли сумму его цифр и т.д.\nСколько таких действий надо произвести, чтобы получился нуль?" +
                    "\n\nОтвет: n должно быть больше нуля.");
        }
    }

    public static void main(String[] args) {
        String result;
        System.out.println("Одномерные массивы");
        result = Array1_1(125, 7);
        System.out.println(result);
        result = Array1_2(20, 25);
        System.out.println(result);
        result = Array1_3(30);
        System.out.println(result);
        result = Array1_4(30);
        System.out.println(result);
        result = Array1_5(30);
        System.out.println(result);
        result = Array1_6(30);
        System.out.println(result);
        result = Array1_7(30);
        System.out.println(result);
        result = Array1_8(100);
        System.out.println(result);
        result = Array1_9(100);
        System.out.println(result);
        result = Array1_10(30);
        System.out.println(result);
        System.out.println("Массивы массивов");
        result = Array2_1(5, 10);
        System.out.println(result);
        result = Array2_2(10);
        System.out.println(result);
        result = Array2_3(10, 5);
        System.out.println(result);
        result = Array2_4(10);
        System.out.println(result);
        result = Array2_5(20);
        System.out.println(result);
        result = Array2_6(20);
        System.out.println(result);
        result = Array2_7(7);
        System.out.println(result);
        result = Array2_8(10, 8);
        System.out.println(result);
        result = Array2_9(10, 12);
        System.out.println(result);
        result = Array2_10(10);
        System.out.println(result);
        result = Array2_11();
        System.out.println(result);
        result = Array2_12(10, 11);
        System.out.println(result);
        result = Array2_13(10, 11);
        System.out.println(result);
        result = Array2_14(10, 8);
        System.out.println(result);
        result = Array2_15(10, 12);
        System.out.println(result);
        result = Array2_16(18);
        System.out.println(result);
        System.out.println("Одномерные массивы. Сортировки");
        result = Array3_1();
        System.out.println(result);
        result = Array3_2();
        System.out.println(result);
        result = Array3_3();
        System.out.println(result);
        result = Array3_4();
        System.out.println(result);
        result = Array3_5();
        System.out.println(result);
        result = Array3_6(20);
        System.out.println(result);
        result = Array3_7();
        System.out.println(result);
        result = Array3_8(5);
        System.out.println(result);
        System.out.println("Декомпозиция с использованием методов (подпрограммы)");
        result = Array4_1(27, 9);
        System.out.println(result);
        result = Array4_2(27, 9, 3, 60);
        System.out.println(result);
        result = Array4_3(15);
        System.out.println(result);
        result = Array4_4();
        System.out.println(result);
        result = Array4_5(40);
        System.out.println(result);
        result = Array4_6(3, 9, 27);
        System.out.println(result);
        result = Array4_7();
        System.out.println(result);
        result = Array4_8();
        System.out.println(result);
        result = Array4_9(5, 7, 13, 9);
        System.out.println(result);
        result = Array4_10(234598674);
        System.out.println(result);
        result = Array4_11(5643, 8765490);
        System.out.println(result);
        result = Array4_12(10, 1500);
        System.out.println(result);
        result = Array4_13(100);
        System.out.println(result);
        result = Array4_14(10000);
        System.out.println(result);
        result = Array4_15(5);
        System.out.println(result);
        result = Array4_16(2);
        System.out.println(result);
        result = Array4_17(81);
        System.out.println(result);
    }
}
