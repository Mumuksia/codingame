package leet;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int start= nums[0];
        int prev = nums[0];
        for (int i=1; i<nums.length; i++){
            if (nums[i] - prev != 1) {
                result.add(format(start, nums[i-1]));
                start = nums[i];
            }
            prev = nums[i];
        }
        result.add(format(start, nums[nums.length-1]));
        return result;
    }

    private String format(int a, int b){
        if (a == b){
            return String.valueOf(a);
        }
        return a + "->" + b;
    }
}
