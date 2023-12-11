package advent_23;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

public class Day_11Test {

    Day_11 day11 = new Day_11();

    @Test
    public void galaxyDistance() throws URISyntaxException, IOException {
        String input = Files.readString(Paths.get(getClass().getResource("/advent_23/day11_test.txt").toURI()));
        input = input.replaceAll("\r", "");

        // Split the input into lines
        String[] lines = input.split("\n");

        assertEquals(374, day11.galaxyDistance(List.of(lines)));
    }

    @Test
    public void galaxyDistance_result() throws URISyntaxException, IOException {
        String input = Files.readString(Paths.get(getClass().getResource("/advent_23/day11.txt").toURI()));
        input = input.replaceAll("\r", "");

        // Split the input into lines
        String[] lines = input.split("\n");

        assertEquals(9556896, day11.galaxyDistance(List.of(lines)));
    }
}