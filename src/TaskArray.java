
import java.util.Scanner;

public class TaskArray {
    public static String Array1_1(int N, int K) {
        //1. В массив A [N] занесены натуральные числа.
        //Найти сумму тех элементов, которые кратны данному К.
        int sum = 0;
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = i + 1;
            if (A[i] % K == 0) {
                sum += A[i];
            }
        }
        return ("\n________________________________\n1. В массив A [N] занесены натуральные числа." +
                "\nНайти сумму тех элементов, которые кратны данному К.\n" +
                "Количество элементов массива = " + N + "\nK = " + K + "\n\nОтвет:" +
                "\n\nСумма элементов, кратных К = " + sum + "\n________________________________");
    }

    public static String Array1_2(int N, double Z) {
        //2. Дана последовательность действительных чисел а1 ,а2 ,..., ап.
        // Заменить все ее члены, большие данного Z, этим числом. Подсчитать количество замен.
        int count = 0;
        StringBuilder mas = new StringBuilder();
        StringBuilder masNew = new StringBuilder();
        double[] A = new double[N];
        for (int i = 0; i < N; i++) {
            A[i] = Math.round((Math.random() * 200 - 100) * 10.0) / 10.0;
            mas.append(A[i]).append("; ");
            if (A[i] > Z) {
                A[i] = Z;
                count++;
            }
            masNew.append(A[i]).append("; ");
        }
        return ("\n________________________________\n2. Дана последовательность действительных" +
                "\nчисел а1 ,а2 ,..., ап.Заменить все ее члены, " +
                "\nбольшие данного Z,этим числом.Подсчитать количество замен." +
                "\nN = " + N + "\nZ = " + Z + "\n\nОтвет:" +
                "\n\nИсходный массив: " + mas + "\nИтоговый массив: " + masNew +
                "\nКоличество замен: " + count + "\n________________________________");
    }

    public static String Array1_3(int N) {
        //3. Дан массив действительных чисел, размерность которого N.
        // Подсчитать, сколько в нем отрицательных, положительных и нулевых элементов.
        int countPozitive = 0;
        int countNegative = 0;
        int countZero = 0;
        StringBuilder mas = new StringBuilder();
        double[] A = new double[N];
        for (int i = 0; i < N; i++) {
            A[i] = Math.round((Math.random() * 200 - 100) * 10.0) / 10.0;
            mas.append(A[i]).append("; ");
            if (A[i] > 0) {
                countPozitive++;
            } else if (A[i] < 0) {
                countNegative++;
            } else {
                countZero++;
            }
        }
        return ("\n________________________________\n3. Дан массив действительных чисел, " +
                "размерность которого N. \nПодсчитать, сколько в нем отрицательных, " +
                "\nположительных и нулевых элементов." + "\nN = " + N + "\n\nОтвет:" +
                "\n\nИсходный массив: " + mas + "\nКоличество положительных элементов: " + countPozitive +
                "\nКоличество отрицательных элементов: " + countNegative +
                "\nКоличество нулевых элементов: " + countZero + "\n________________________________");
    }

    public static String Array1_4(int N) {
        //4. Даны действительные числа а1 ,а2 ,..., аn .
        //Поменять местами наибольший и наименьший элементы.
        double maxElem;
        double minElem;
        int maxIndex;
        int minIndex;
        double change;
        StringBuilder mas = new StringBuilder();
        StringBuilder masNew = new StringBuilder();
        double[] A = new double[N];
        A[0] = Math.round((Math.random() * 200 - 100) * 10.0) / 10.0;
        mas.append(A[0]).append("; ");
        maxElem = A[0];
        maxIndex = 0;
        minElem = A[0];
        minIndex = 0;
        for (int i = 1; i < N; i++) {
            A[i] = Math.round((Math.random() * 200 - 100) * 10.0) / 10.0;
            mas.append(A[i]).append("; ");
            if (A[i] > maxElem) {
                maxElem = A[i];
                maxIndex = i;
            }
            if (A[i] < minElem) {
                minElem = A[i];
                minIndex = i;
            }
        }
        change = A[minIndex];
        A[minIndex] = A[maxIndex];
        A[maxIndex] = change;
        for (int i = 0; i < N; i++) {
            masNew.append(A[i]).append("; ");
        }
        return ("\n________________________________\n4. 4. Даны действительные числа а1 ,а2 ,..., аn ." +
                "\nПоменять местами наибольший и наименьший элементы." +
                "\nN = " + N + "\n\nОтвет:" + "Минимальный элемент: " + minElem +
                "\nМаксимальный элемент: " + maxElem +
                "\n\nИсходный массив: " + mas + "\nИтоговый массив: " + masNew);

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
    }
}
