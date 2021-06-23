package hackerrank;

import java.util.Arrays;

public class GreedyFlourist {

    static int getMinimumCost(int k, int[] c) {
        int sum = 0;

        int i = 0;
        Arrays.sort(c);
        int multi = 0;

        for (int j = c.length - 1; j >= 0; j--) {
            sum += c[j] * (multi + 1);
            i++;
            if (i >= k) {
                multi++;
                i=0;
            }
        }
        return sum;
    }


}
