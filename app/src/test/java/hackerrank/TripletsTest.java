package hackerrank;

import org.junit.Assert;
import org.junit.Test;

public class TripletsTest {

    @Test
    public void countTriplets() {
        Assert.assertEquals(8, Triplets.triplets(new int[]{1, 3, 5}, new int[]{2, 3, 2}, new int[]{1, 2, 3}));
        Assert.assertEquals(8, Triplets.triplets(new int[]{5, 3, 1}, new int[]{3, 2}, new int[]{3, 1, 2}));
        Assert.assertEquals(6, Triplets.triplets(new int[]{2, 3, 1}, new int[]{3}, new int[]{2, 1, 2}));
        Assert.assertEquals(6, Triplets.triplets(new int[]{2, 7}, new int[]{3, 2, 5, 6, 9}, new int[]{2}));
    }

    @Test
    public void countTripletsT() {
        Assert.assertEquals(6, Triplets.triplets(new int[]{2, 7}, new int[]{3, 2, 5, 6, 9}, new int[]{2}));
    }
}
