package advent_23;

import junit.framework.TestCase;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day_9Test extends TestCase {

    Day_9 day9 = new Day_9();

    public void testSensor_test() throws URISyntaxException, IOException {
        String input = Files.readString(Paths.get(getClass().getResource("/advent_23/day9_test.txt").toURI()));

        // Split the input into lines
        String[] lines = input.split("\n");

        assertEquals(114, day9.sensor(List.of(lines)));
    }

    public void testSensor_part1() throws URISyntaxException, IOException {
        String input = Files.readString(Paths.get(getClass().getResource("/advent_23/day9.txt").toURI()));

        // Split the input into lines
        String[] lines = input.split("\n");

        assertEquals(114, day9.sensor(List.of(lines)));
    }
}