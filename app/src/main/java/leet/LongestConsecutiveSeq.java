package leet;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LongestConsecutiveSeq {

    public int longestConsecutive(int[] nums) {
        Set<Integer> input = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int max = 0;
        for (int n : nums){
            int longest = 1;
            if (input.contains(n-1)){
                continue;
            }
            int t = n+1;
            while (input.contains(t)){
                longest++;
                t++;
            }
            max = Math.max(max, longest);
        }
        return max;
    }
}
