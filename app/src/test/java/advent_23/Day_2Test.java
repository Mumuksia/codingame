package advent_23;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class Day_2Test {

    Day_2 day_2 = new Day_2();
    private String input = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green\n" + "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue\n" + "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red\n" + "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red\n" + "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green";

    @Test
    public void calculate() {
        int result = day_2.calculate(input);
        assertEquals(8, result);
    }

    @Test
    public void calculate_result() throws URISyntaxException, IOException {
        input = Files.readString(Paths.get(getClass().getResource("/advent_23/day2_1.txt").toURI()));
        int result = day_2.calculate(input);
        //assertEquals(8, result); hiding result
    }

    @Test
    public void calculate_2() {
        int result = day_2.calculate_2(input);
        assertEquals(2286, result);
    }

    @Test
    public void calculate2_result() throws URISyntaxException, IOException {
        input = Files.readString(Paths.get(getClass().getResource("/advent_23/day2_1.txt").toURI()));
        int result = day_2.calculate_2(input);
        //assertEquals(8, result); hiding result
    }

}
