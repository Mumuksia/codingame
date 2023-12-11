package advent_23;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

public class Day_10Test {

    Day_10 day10 = new Day_10();

    @Test
    public void labyrinth() throws URISyntaxException, IOException {
        String input = Files.readString(Paths.get(getClass().getResource("/advent_23/day10.txt").toURI()));
        input = input.replaceAll("\r", "");

        // Split the input into lines
        String[] lines = input.split("\n");



        day10.labyrinth(List.of(lines));
    }
}