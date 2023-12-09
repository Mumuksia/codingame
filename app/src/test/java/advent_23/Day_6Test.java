package advent_23;

import junit.framework.TestCase;

public class Day_6Test extends TestCase {

    Day_6 day6 = new Day_6();

    public void testBoatRace_test() {
        int[] times = new int[]{7, 15, 30};
        int[] records = new int[]{9, 40, 200};

        assertEquals(288, day6.boatRace(times, records));
    }

    public void testBoatRace_result() {
        int[] times = new int[]{55,     99,     97,    93};
        int[] records = new int[]{401,   1485,   2274,   1405};

        assertEquals(288, day6.boatRace(times, records));
    }

    public void testBoatRace_result_2() {
        assertEquals(288, day6.numberOfWaysForRace(55999793, 401148522741405L));
    }
}