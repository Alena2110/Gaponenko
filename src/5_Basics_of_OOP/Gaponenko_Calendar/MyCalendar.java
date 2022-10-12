import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.util.HashSet;

public class MyCalendar {
    LocalDate begin;//дата начала календаря
    LocalDate end;//дата окончания календаря

    public MyCalendar(LocalDate begin, LocalDate end) {
        this.begin = begin;
        this.end = end;
    }

    public StringBuilder defineHolidaysWeekends(HashSet<MonthDay> holidays) {//выходные и праздничные дни
        Holiday holiday = new Holiday(holidays);
        return holiday.holidaysWeekends();
    }

    private class Holiday {
        private HashSet<MonthDay> holidays;

        public Holiday(HashSet<MonthDay> holidays) {
            this.holidays = new HashSet<>(holidays);
        }

        public StringBuilder holidaysWeekends() {//определение выходных и праздничных дней
            StringBuilder result = new StringBuilder();
            for (LocalDate i = begin; i.isBefore(end.plusDays(1)); i = i.plusDays(1)) {
                if (holidays.contains(MonthDay.of(i.getMonth(), i.getDayOfMonth()))) {
                    result.append(i).append(" - праздничный день ").append(i.getDayOfWeek()).append("\n");
                } else if (i.getDayOfWeek() == DayOfWeek.SATURDAY || i.getDayOfWeek() == DayOfWeek.SUNDAY) {
                    result.append(i).append(" - выходной день ").append(i.getDayOfWeek()).append("\n");
                }
            }
            return result;
        }
    }
}