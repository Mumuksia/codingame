package hackerrank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairsSearch {

    public static int pairs(int k, List<Integer> arr) {
        Map<Integer, Integer> values = new HashMap<>();

        for (Integer v : arr){
            values.put(v, values.getOrDefault(v, 0) + 1);
        }
        int sum = 0;
        for (Integer v : arr){
            if (values.containsKey(v-k)){
                sum +=values.get(v-k);
                if (v == (v-k))
                    sum--;
            }
        }
        return sum;
    }

}
