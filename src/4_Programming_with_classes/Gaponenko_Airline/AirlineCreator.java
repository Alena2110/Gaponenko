import java.time.LocalTime;


public class AirlineCreator {
    public static void main(String[] args) {
        Airlines airlines = new Airlines();
        airlines.airlineAdd(new Airline("Тбилиси", "B2 736", "Boeing 737-800", LocalTime.of(8, 25), new String[]{"пн", "ср"}));
        airlines.airlineAdd(new Airline("Анталия", "B2 8106", "Boeing 737-800", LocalTime.of(15, 56), new String[]{"вт", "пт", "сб"}));
        airlines.airlineAdd(new Airline("Москва", "B2 956", "Boeing 737-300", LocalTime.of(21, 47), new String[]{"вс"}));
        airlines.airlineAdd(new Airline("Санкт-Петербург", "B2 942", "Embraer 175", LocalTime.of(2, 5), new String[]{"пн", "ср"}));
        airlines.airlineAdd(new Airline("Москва", "B2 978", "Boeing 737-800", LocalTime.of(23, 55), new String[]{"вт", "чт", "пт"}));
        airlines.airlineAdd(new Airline("Дубай", "B2 728", "Boeing 737-800", LocalTime.of(17, 4), new String[]{"пн", "сб"}));
        airlines.airlineAdd(new Airline("Санкт-Петербург", "B2 940", "Embraer 195", LocalTime.of(7, 34), new String[]{"сб", "вс"}));
        System.out.println("Список рейсов для заданного пункта назначения\n");
        for (Airline airline : airlines.destinationFilter("Санкт-Петербург")) {
            System.out.println(airline);
        }
        System.out.println("\nСписок рейсов для заданного дня недели\n");
        for (Airline airline : airlines.dayFilter("пн")) {
            System.out.println(airline);
        }
        System.out.println("\nСписок рейсов для заданного дня недели, время вылета для которых больше заданного\n");
        for (Airline airline : airlines.timeFilter("сб", LocalTime.of(12, 45))) {
            System.out.println(airline);
        }
    }
}
