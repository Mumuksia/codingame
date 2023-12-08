package advent_23;

import junit.framework.TestCase;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day_7Test extends TestCase {

    Day_7 day7 = new Day_7();

    public void testCardResult() throws URISyntaxException, IOException {

        List<String> lines = Files.readAllLines(Paths.get(getClass().getResource("/advent_23/day7.txt").toURI()));

        assertEquals(10, day7.cardResult(lines));
    }

    public void testCardResult_test() throws URISyntaxException, IOException {

        List<String> lines = Files.readAllLines(Paths.get(getClass().getResource("/advent_23/day7_test.txt").toURI()));

        assertEquals(6440, day7.cardResult(lines));
    }

    public void testCardResult_2() throws URISyntaxException, IOException {
        List<String> lines = Files.readAllLines(Paths.get(getClass().getResource("/advent_23/day7.txt").toURI()));

        assertEquals(10, day7.cardResult_2(lines));
    }
}