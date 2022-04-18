import java.util.Random;

/*3. Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив из пяти
 элементов). Создайте массив из десяти элементов такого типа. Добавьте возможность вывода фамилий и номеров групп
 студентов, имеющих оценки, равные только 9 или 10.*/
public class Student {
    String fullName; //ФИО
    int numberGroup; //номер группы
    int[] performance = new int[5]; //успеваемость

    Student(String fullName, int numberGroup) { //конструктор
        this.fullName = fullName;
        this.numberGroup = numberGroup;
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            this.performance[i] = random.nextInt(8) + 3; //заполнение массива успеваемости случайными числами от 3 до 10
        }
    }

    public void SetPerformance(int[] performance) { //set-метод для performance
        System.arraycopy(performance, 0, this.performance, 0, 5);
    }

    public void BestStudent() { //определение лучших студентов с оценками 9 и 10
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (this.performance[i] >= 9) {
                count++;
            }
        }
        if (count == 5) {
            System.out.println("Студент: " + this.fullName + " № группы: " + this.numberGroup);
        }
    }

    public void Print() { //вывод на экран
        StringBuilder mark = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            mark.append(this.performance[i]).append(" ");
        }
        System.out.println("Студент: " + this.fullName + " учится в групп № " + numberGroup + ". Успеваемость студента: "
                + mark);
    }

    public static void main(String[] args) {
        Student[] students = new Student[10]; //массив из 10 элементов типа Student
        students[0] = new Student("Дмитриев Г.Н", 1);
        students[1] = new Student("Иванов В.В", 2);
        students[2] = new Student("Петров М.П", 3);
        students[3] = new Student("Алексеева С.Н", 1);
        students[4] = new Student("Заводевкина К.Д", 2);
        students[5] = new Student("Гулько Л.П", 3);
        students[6] = new Student("Кириллов Д.С", 1);
        students[7] = new Student("Горбылева Г.М", 2);
        students[7].SetPerformance(new int[]{9, 9, 10, 10, 10});
        students[8] = new Student("Стасев Д.Н", 3);
        students[9] = new Student("Олешкевич Н.Н", 1);
        for (int i = 0; i < 10; i++) {//вывод информации по студентам на экран
            students[i].Print();
        }
        System.out.println("Лучшие студенты:");
        for (int i = 0; i < 10; i++) { //определение лучших студентов
            students[i].BestStudent();
        }
    }
}


