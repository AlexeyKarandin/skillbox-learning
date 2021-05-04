import core.Line;
import core.Station;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest {

    List<Station> route;
    List<Station> stations;
    StationIndex stationIndex;
    RouteCalculator routeCalculator;

    @Before
    public void setUp() {
        route = new ArrayList<>();
        stations = new ArrayList<>();
        stationIndex = new StationIndex();

        Line line1 = new Line(1, "Кировско-Выборгская");
        Line line2 = new Line(2, "Московско-Петроградская");
        Line line3 = new Line(3, "Невско-Василеостровская");

        route.add(new Station("Лесная", line1));
        route.add(new Station("Автово", line1));
        route.add(new Station("Парнас", line2));
        route.add(new Station("Пионерская", line2));


        Station station1 = new Station("Владимирская", line1);
        Station station2 = new Station("Невский проспект", line2);
        Station station3 = new Station("Гостиный двор", line3);
        line1.addStation(new Station("Лесная", line1));
        line1.addStation(new Station("Автово", line1));
        line2.addStation(new Station("Парнас", line2));
        line2.addStation(new Station("Пионерская", line2));
        line3.addStation(new Station("Морковная", line3));
        line3.addStation(new Station("Яблочная", line3));

        stations.add(station1);
        stations.add(station2);
        stations.add(station3);

        stationIndex.addStation(station1);
        stationIndex.addStation(station2);
        stationIndex.addStation(station3);
        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);
        stationIndex.addConnection(stations);

        routeCalculator = new RouteCalculator(stationIndex);


    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetShortestRoute() {

        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Лесная"),
                stationIndex.getStation("Яблочная"));
        Assert.assertEquals("123", actual.toString());

    }

    @Test
    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 8.5;
        Assert.assertEquals(expected, actual, 0);

    }
}