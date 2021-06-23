package hackerrank;

import org.junit.Test;

import static org.junit.Assert.*;

public class GreedyFlouristTest {

    @Test
    public void getMinimumCost() {

        assertEquals(15, GreedyFlourist.getMinimumCost(2, new int[]{2, 5, 6}));
    }
}
