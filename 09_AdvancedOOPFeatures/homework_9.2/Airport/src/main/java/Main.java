import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();

        System.out.println(findPlanesLeavingInTheNextTwoHours(airport));

    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.HOUR_OF_DAY, 2);
        return airport.getTerminals().stream()
                .flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> flight.getType().equals(Flight.Type.DEPARTURE))
                .filter(flight -> {
                    calendar.setTime(flight.getDate());
                    return calendar.before(calendar1);
                }).collect(Collectors.toList());
    }

}