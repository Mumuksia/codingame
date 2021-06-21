package hackerrank;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FrequencyQueriesTest {

    @Test
    public void freqQuery() {

        List<List<Integer>> input = Arrays.asList(Arrays.asList(1, 1),
                Arrays.asList(2, 2),
                Arrays.asList(3, 2),
                Arrays.asList(1, 1),
                Arrays.asList(1, 1),
                Arrays.asList(2, 1),
                Arrays.asList(3, 2));

        assertEquals(Arrays.asList(0, 1), FrequencyQueries.freqQuery(input));
    }

    @Test
    public void freqQuery4() {

        List<List<Integer>> input = Arrays.asList(Arrays.asList(1, 1),
                Arrays.asList(2, 1),
                Arrays.asList(2, 1),
                Arrays.asList(3, 1),
                Arrays.asList(1, 1),
                Arrays.asList(3, 1),
                Arrays.asList(3, 2));

        assertEquals(Arrays.asList(0, 1, 0), FrequencyQueries.freqQuery(input));
    }

    @Test
    public void freqQuery5() {

        List<List<Integer>> input = Arrays.asList(Arrays.asList(1, 1),
                Arrays.asList(1, 1),
                Arrays.asList(2, 1),
                Arrays.asList(1, 1),
                Arrays.asList(1, 1),
                Arrays.asList(3, 1),
                Arrays.asList(3, 3));

        assertEquals(Arrays.asList(0, 1), FrequencyQueries.freqQuery(input));
    }


    @Test
    public void freqQuery2() {

        List<List<Integer>> input = Arrays.asList(Arrays.asList(1, 5),
                Arrays.asList(1, 6),
                Arrays.asList(3, 2),
                Arrays.asList(1, 10),
                Arrays.asList(1, 10),
                Arrays.asList(1, 6),
                Arrays.asList(2, 5),
                Arrays.asList(3, 2));

        assertEquals(Arrays.asList(0, 1), FrequencyQueries.freqQuery(input));
    }

    @Test
    public void freqQuery3() {

        List<List<Integer>> input = Arrays.asList(Arrays.asList(1, 3),
                Arrays.asList(2, 3),
                Arrays.asList(3, 2),
                Arrays.asList(1, 4),
                Arrays.asList(1, 5),
                Arrays.asList(1, 5),
                Arrays.asList(1, 4),
                Arrays.asList(3, 2),
                Arrays.asList(2, 4),
                Arrays.asList(3, 2));

        assertEquals(Arrays.asList(0, 1, 1), FrequencyQueries.freqQuery(input));
    }
}
