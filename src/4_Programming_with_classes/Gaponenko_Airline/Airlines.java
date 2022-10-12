import java.time.LocalTime;
import java.util.ArrayList;

public class Airlines {
    ArrayList<Airline> airlines = new ArrayList<>();

    public void airlineAdd(Airline airline) {
        //добавление новой авиакомпании
        airlines.add(airline);
    }

    public ArrayList<Airline> destinationFilter(String destination) {
        //получение списка рейсов для заданного пункта назначения;
        ArrayList<Airline> destinationFilter = new ArrayList<>();
        for (Airline airline : airlines)
            if (airline.getDestination().equals(destination)) {
                destinationFilter.add(airline);
            }
        return destinationFilter;
    }

    public ArrayList<Airline> dayFilter(String day) {
        //получение списка рейсов для заданного дня недели;
        ArrayList<Airline> dayFilter = new ArrayList<>();
        for (Airline airline : airlines)
            for (String a : airline.getDays())
                if (a.equals(day)) {
                    dayFilter.add(airline);
                    break;
                }
        return dayFilter;
    }

    public ArrayList<Airline> timeFilter(String day, LocalTime time) {
        //получение списка рейсов для заданного дня недели, время вылета для которых больше заданного.
        ArrayList<Airline> timeFilter = new ArrayList<>();
        for (Airline airline : dayFilter(day)) {
            if (airline.getDepartureTime().compareTo(time) > 0) {
                timeFilter.add(airline);
            }
        }
        return timeFilter;
    }
}

