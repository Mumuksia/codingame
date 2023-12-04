package advent_23;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;

public class Day_4Test {

    Day_4 day4 = new Day_4();
    @Test
    public void winningCard() throws URISyntaxException, IOException {

        int result = day4.winningCard("/advent_23/day4_test.txt");

        //assertEquals(13, result);
    }

    @Test
    public void winningCard_result() throws URISyntaxException, IOException {

        int result = day4.winningCard("/advent_23/day4.txt");

        //assertEquals(13, result);
    }

    @Test
    public void winningCard_2() throws URISyntaxException, IOException {

        int result = day4.winningCard("/advent_23/day4_test.txt");

        assertEquals(30, result);
    }

    @Test
    public void winningCard_2_result() throws URISyntaxException, IOException {

        int result = day4.winningCard("/advent_23/day4.txt");

        assertEquals(30, result);
    }
}
