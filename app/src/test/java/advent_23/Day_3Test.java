package advent_23;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.*;

public class Day_3Test {

    Day_3 day_3 = new Day_3();

    @Test
    public void engine() throws IOException, URISyntaxException {
        String input = "/advent_23/day3_test.txt";
        assertEquals(4361, day_3.engine(input));
    }

    @Test
    public void engine_result() throws IOException, URISyntaxException {
        String input = "/advent_23/day3_1.txt";
        //assertEquals(4361, day_3.engine(input)); hiding answer
    }

    @Test
    public void engine2() throws IOException, URISyntaxException {
        String input = "/advent_23/day3_test.txt";
        assertEquals(467835, day_3.engine_2(input));
    }

    @Test
    public void engine2_result() throws IOException, URISyntaxException {
        String input = "/advent_23/day3_1.txt";
        assertEquals(467835, day_3.engine_2(input));
    }
}
