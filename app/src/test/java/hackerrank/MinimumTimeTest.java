package hackerrank;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumTimeTest {

    @Test
    public void minTime() {

        assertEquals(8, MinimumTime.minTime(new long[]{2,3,2}, 10L));
    }
}
