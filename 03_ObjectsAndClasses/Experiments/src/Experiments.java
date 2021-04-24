//import com.skillbox.airport.Aircraft;
//import com.skillbox.airport.Airport;

public class Experiments {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        int counter = 1;
        for (Aircraft crafts :
                airport.getAllAircrafts()) {
            System.out.print(crafts + "\t");
            if (counter % 10 == 0) {
                System.out.println();
                counter = 1;
            }
            counter++;
        }
        System.out.println();
        System.out.println(airport.getTerminals());

        int craftsSize = airport.getAllAircrafts().size();
        System.out.println("Кол-во самолетов: " + craftsSize);
    }
}
