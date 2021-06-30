package hackerrank;

import java.util.Arrays;
import java.util.List;

public class Candles {

    public static long candies(int n, List<Integer> arr) {
        int[] values = arr.stream().mapToInt(i -> i).toArray();

        int descending_seq = 0;
        long sum = 0;
        int prev_c = 0;
        int prev_num_of_candies = 0;
        for (int c : values) {
            if (c >= prev_c) {
                if (descending_seq > 0) {
                    // agjust local max value if descending sequence
                    // was longer than ascending
                    if (descending_seq >= prev_num_of_candies) {
                        sum += 1 + descending_seq - prev_num_of_candies;
                    }
                    // last of descending = local minimum
                    prev_num_of_candies = 1;
                    descending_seq = 0;
                }
                if (c > prev_c) {
                    ++prev_num_of_candies;
                } else {
                    // optimal if previous value is the same
                    prev_num_of_candies = 1;
                }
                sum += prev_num_of_candies;
            } else {
                ++descending_seq;
                // For 3 descending numbers in a row this summing strategy
                // will increment like sum+=1+2+3 which is the same as
                // more usual and expected sum+=3+2+1
                sum += descending_seq;
            }
            prev_c = c;
        }
        if (descending_seq >= prev_num_of_candies) {
            sum += 1 + descending_seq - prev_num_of_candies;
        }
        return sum;

    }

}
