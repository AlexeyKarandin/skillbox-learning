import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest {

    List<Station> route;

    @Before
    public void setUp() {
        route = new ArrayList<>();

        Line line1 = new Line(1, "Кировско-Выборгская");
        Line line2 = new Line(2, "Московско-Петроградская");
        Line line3 = new Line(3, "Невско-Василеостровская");

        route.add(new Station("Девяткино", line1));
        route.add(new Station("Автово", line1));
        route.add(new Station("Парнас", line2));
        route.add(new Station("Пионерская", line2));
        route.add(new Station("Морковная", line3));
        route.add(new Station("Яблочная", line3));

    }

    @After
    public void tearDown() {

    }

    @Test
    public void getShortestRoute() {

    }

    @Test
    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 14.5;
        Assert.assertEquals(expected, actual);

    }
}