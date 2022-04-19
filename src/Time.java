/*6. Составьте описание класса для представления времени. Предусмотрите возможности установки времени и изменения его
отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений. В случае недопустимых значений полей
поле устанавливается в значение 0. Создать методы изменения времени на заданное количество часов, минут и секунд.*/

public class Time {
    int minute; //минуты
    int second; //cекунды
    int hour; //часы

    Time(int hour, int minute, int second) {//конструктор
        if (second >= 0 && second <= 59) {
            this.second = second;
        } else {
            this.second = 0;
        }
        if (minute >= 0 && minute <= 59) {
            this.minute = minute;
        } else {
            this.minute = 0;
        }
        if (hour >= 0 && hour <= 23) {
            this.hour = hour;
        } else {
            this.hour = 0;
        }
    }

    public void setSecond(int second) { //set-метод для second
        if (second >= 0 && second <= 59) {
            this.second = second;
        } else {
            this.second = 0;
        }
    }

    public void setMinute(int minute) { //set-метод для minute
        if (minute >= 0 && minute <= 59) {
            this.minute = minute;
        } else {
            this.minute = 0;
        }
    }

    public void setHour(int hour) { //set-метод для hour
        if (hour >= 0 && hour <= 23) {
            this.hour = hour;
        } else {
            this.hour = 0;
        }
    }

    public void decreaseTime(int stepHour, int stepMinute, int stepSecond) { //уменьшение времени на заданные величины
        if (this.hour - stepHour >= 0 && this.hour - stepHour <= 23) {
            this.hour -= stepHour;
        } else {
            this.hour = 0;
        }
        if (this.minute - stepMinute >= 0 && this.minute - stepMinute <= 59) {
            this.minute -= stepMinute;
        } else {
            this.minute = 0;
        }
        if (this.second - stepSecond >= 0 && this.second - stepSecond <= 59) {
            this.second -= stepSecond;
        } else {
            this.second = 0;
        }
    }

    public void increaseTime(int stepHour, int stepMinute, int stepSecond) {//увеличение времени на заданные величины
        if (this.hour + stepHour >= 0 && this.hour + stepHour <= 23) {
            this.hour += stepHour;
        } else {
            this.hour = 0;
        }
        if (this.minute + stepMinute >= 0 && this.minute + stepMinute <= 59) {
            this.minute += stepMinute;
        } else {
            this.minute = 0;
        }
        if (this.second + stepSecond >= 0 && this.second + stepSecond <= 59) {
            this.second += stepSecond;
        } else {
            this.second = 0;
        }
    }

    public String toString() {
        return hour + ":" + minute + ":" + second;
    }

    public static void main(String[] args) {

        Time time = new Time(44, 34, 55);
        System.out.println("Исходное время " + time);
        time.setMinute(45);
        System.out.println("Изменение минут " + time);
        time.increaseTime(2, 56, 1);
        System.out.println("Увеличение времени на заданные величины: " + time);
        time.decreaseTime(1, 56, 45);
        System.out.println("Уменьшение времени на заданные величины: " + time);
    }
}

