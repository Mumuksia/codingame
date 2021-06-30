package hackerrank;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PairsSearchTest {

    @Test
    public void pairs() {

        assertEquals(3, PairsSearch.pairs(1, Arrays.asList(1, 2, 3, 4)));
        assertEquals(3, PairsSearch.pairs(2, Arrays.asList(1, 5, 3, 4, 2)));
    }
}
