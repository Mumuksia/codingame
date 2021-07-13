package hackerrank;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LargestRectangleTest {

    @Test
    public void largestRectangle() {

        assertEquals(9, LargestRectangle.largestRectangle(Arrays.asList(1, 2, 3, 4, 5)));
    }
}
