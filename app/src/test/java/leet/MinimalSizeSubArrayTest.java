package leet;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimalSizeSubArrayTest {

    MinimalSizeSubArray minimalSizeSubArray = new MinimalSizeSubArray();

    @Test
    public void minSubArrayLen() {

        assertEquals(2, minimalSizeSubArray.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));

        assertEquals(5, minimalSizeSubArray.minSubArrayLen(15, new int[]{1,2,3,4,5}));
    }
}