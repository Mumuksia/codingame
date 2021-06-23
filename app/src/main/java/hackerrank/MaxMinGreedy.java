package hackerrank;

import java.util.Collections;
import java.util.List;

public class MaxMinGreedy {

    public static int maxMin(int k, List<Integer> arr) {

        Collections.sort(arr);
        int mixman = arr.get(k-1) - arr.get(0);
        for (int i=0; i<=arr.size()-k;i++){
            if (arr.get(i+k-1) - arr.get(i) < mixman){
                mixman = arr.get(i+k-1) - arr.get(i);
            }
        }

        return mixman;
    }
}
