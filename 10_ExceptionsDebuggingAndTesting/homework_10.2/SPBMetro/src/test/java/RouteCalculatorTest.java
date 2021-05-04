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
        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        route.add(new Station("Лесная", line1));
        route.add(new Station("Автово", line1));
        route.add(new Station("Парнас", line2));
        route.add(new Station("Пионерская", line2));

        line1.addStation(new Station("Лесная", line1));
        line1.addStation(new Station("Нарвская", line1));
        line1.addStation(new Station("Автово", line1));
        line1.getStations().forEach(station -> stationIndex.addStation(station));
        line2.addStation(new Station("Парнас", line2));
        line2.addStation(new Station("Озерки", line2));
        line2.addStation(new Station("Пионерская", line2));
        line2.getStations().forEach(station -> stationIndex.addStation(station));
        line3.addStation(new Station("Беговая", line3));
        line3.addStation(new Station("Маяковская", line3));
        line3.addStation(new Station("Рыбацкое", line3));
        line3.getStations().forEach(station -> stationIndex.addStation(station));
        stations.add(stationIndex.getStation("Автово"));
        stations.add(stationIndex.getStation("Парнас"));
        stationIndex.addConnection(stations);
        stations.clear();
        stations.add(stationIndex.getStation("Беговая"));
        stations.add(stationIndex.getStation("Пионерская"));
        stationIndex.addConnection(stations);

        routeCalculator = new RouteCalculator(stationIndex);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetShortestRoute() {

        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Лесная"),
                stationIndex.getStation("Автово"));
        Assert.assertEquals("[Лесная, Нарвская, Автово]",
                actual.toString());
        actual.clear();
        actual = routeCalculator.getShortestRoute(stationIndex.getStation("Нарвская"),
                stationIndex.getStation("Озерки"));
        Assert.assertEquals("[Нарвская, Автово, Парнас, Озерки]",
                actual.toString());
        actual.clear();
        actual = routeCalculator.getShortestRoute(stationIndex.getStation("Лесная"),
                stationIndex.getStation("Рыбацкое"));
        Assert.assertEquals("[Лесная, Нарвская, Автово, Парнас, Озерки, Пионерская, Беговая, Маяковская, Рыбацкое]",
                actual.toString());

    }

    @Test
    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 8.5;
        Assert.assertEquals(expected, actual, 0);
    }
}