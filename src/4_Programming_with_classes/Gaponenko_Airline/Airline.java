/*Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и метод
 toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и методами.
  Задать критерии выбора данных и вывести эти данные на консоль.
        Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
        Найти и вывести:
        а) список рейсов для заданного пункта назначения;
        b) список рейсов для заданного дня недели;
        с) список рейсов для заданного дня недели, время вылета для которых больше заданного.*/

import java.time.LocalTime;
import java.util.Arrays;

public class Airline {
    private String destination;//пункт назначения
    private String flightNumber;//номер рейса
    private String aircraftType;//тип самолета
    private LocalTime departureTime;//время вылета
    private String[] days;//дни недели

    public Airline(String destination, String flightNumber, String aircraftType, LocalTime departureTime, String[] days) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.aircraftType = aircraftType;
        this.departureTime = departureTime;
        this.days = days;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public void setDays(String[] days) {
        this.days = days;
    }


    public String getDestination() {
        return destination;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public String[] getDays() {
        return days;
    }

    @Override
    public String toString() {
        return "Пункт назначения: " + destination +
                ". Номер рейса: " + flightNumber +
                ". Тип самолета: " + aircraftType +
                ". Время вылета: " + departureTime +
                ". Дни недели: " + Arrays.toString(days);
    }
}

