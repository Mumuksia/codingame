package leet;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeIntervalsTest {

    MergeIntervals mergeIntervals = new MergeIntervals();

    @Test
    public void merge(){
        int[][] input = new int[2][2];
        input[0] = new int[]{1,4};
        input[1] = new int[]{4,5};
        int[][] result = mergeIntervals.merge(input);
        System.out.println(result);
    }

}