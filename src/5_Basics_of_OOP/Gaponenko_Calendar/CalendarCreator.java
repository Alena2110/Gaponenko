/*Задача 3.
Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить информацию о выходных и
праздничных днях.
 */

import java.time.LocalDate;
import java.time.MonthDay;
import java.util.Collections;
import java.util.HashSet;

public class CalendarCreator {
    public static void main(String[] args) {
        MonthDay[] holidays = new MonthDay[]{MonthDay.of(1, 1), MonthDay.of(7, 1),
                MonthDay.of(3, 8), MonthDay.of(5, 1), MonthDay.of(5, 3),
                MonthDay.of(5, 9), MonthDay.of(7, 3), MonthDay.of(11, 7),
                MonthDay.of(12, 25)};
        HashSet<MonthDay> holidaysList = new HashSet<>();
        Collections.addAll(holidaysList, holidays);
        MyCalendar myCalendar = new MyCalendar(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 12, 31));
        System.out.println(myCalendar.defineHolidaysWeekends(holidaysList));
    }
}
