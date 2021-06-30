package hackerrank;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class CandlesTest {

    @Test
    public void candies() {

        assertEquals(10 ,Candles.candies(6, Arrays.asList(4, 6, 4, 5, 6, 2)));

        assertEquals(19 ,Candles.candies(10, Arrays.asList(2, 4, 2, 6, 1, 7, 8, 9, 2, 1)));


    }
}
