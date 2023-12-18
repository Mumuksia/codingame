package leet;

import java.util.Arrays;

public class MergeIntervals {

    boolean[] seen = new boolean[100001];
    public int[][] merge(int[][] intervals) {
        int[][] result = new int[10000][2];
        for (int[] interval : intervals){
            for (int i =interval[0]; i<interval[1]+1; i++){
                seen[i] = true;
            }
        }
        int counter = 0;
        boolean start = false;
        int startPoint = -1;

        for (int i=0; i<seen.length;i++){



            if (seen[i] && !start){
                startPoint = i;
                start = true;
            }
            if (!seen[i] && start){
                result[counter] = new int[]{startPoint, i-1};
                counter++;
                start = false;

            }
        }
        int[][] output = new int[counter][2];
        System.arraycopy(result, 0, output, 0, counter);

        return output;
    }
}
