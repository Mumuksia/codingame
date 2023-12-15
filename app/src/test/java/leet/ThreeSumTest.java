package leet;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ThreeSumTest {

    ThreeSum threeSum = new ThreeSum();

    @Test
    public void threeSum() {

        //List<List<Integer>> result = threeSum.threeSum(new int[]{-1,0,1,2,-1,-4});
        List<List<Integer>> result = threeSum.threeSum(new int[]{0,0,0});
        assertTrue(result.isEmpty());


    }
}