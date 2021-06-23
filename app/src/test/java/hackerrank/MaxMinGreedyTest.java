package hackerrank;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MaxMinGreedyTest {

    @Test
    public void maxMin() {

        //assertEquals(1, MaxMinGreedy.maxMin(2, Arrays.asList(1, 4, 7, 2)));
        assertEquals(2, MaxMinGreedy.maxMin(3, Arrays.asList(10, 20, 30, 100, 101, 102)));
    }
}
