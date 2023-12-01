package advent_23;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.*;

public class Day_1Test {

    Day_1 day_1 = new Day_1();

    @Test
    public void getCalibratedSum() throws IOException, URISyntaxException {
        assertEquals(142, day_1.getCalibratedSum("/advent_23/day1_test.txt"));
    }

    @Test
    public void getCalibratedSum_result() throws IOException, URISyntaxException {
        System.out.println(day_1.getCalibratedSum("/advent_23/day1.txt"));
    }

    @Test
    public void getCalibratedSum_2() throws IOException, URISyntaxException {
        assertEquals(281, day_1.getCalibratedSum_2("/advent_23/day1_2_test.txt"));
    }
    @Test
    public void getCalibratedSum2_result() throws IOException, URISyntaxException {
        System.out.println(day_1.getCalibratedSum_2("/advent_23/day1.txt"));
    }
}
