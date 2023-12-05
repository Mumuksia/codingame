package advent_23;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;

public class Day_5Test {

    Day_5 day5 = new Day_5();

    @Test
    public void findLowest() throws IOException, URISyntaxException {
        long result = day5.findLowest("/advent_23/day_5_test.txt", "79 14 55 13");

        assertEquals(35, result);

    }

    @Test
    public void findLowest_result() throws IOException, URISyntaxException {
        long result = day5.findLowest("/advent_23/day5.txt", "3489262449 222250568 2315397239 327729713 1284963 12560465 1219676803 10003052 291763704 177898461 136674754 107182783 2917625223 260345082 1554280164 216251358 3900312676 5629667 494259693 397354410");

        assertEquals(35, result);

    }
}
