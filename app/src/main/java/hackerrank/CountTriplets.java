package hackerrank;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountTriplets {

    static long countTriplets(List<Long> arr, long r) {


        if (r != 1){
            return countTripletsBackward(arr, r);
        }
        Map<Long, List<Integer>> countMap = new HashMap<>();


        long count = 0;
        for (int i=0; i< arr.size(); i++){
                    if (!countMap.containsKey(arr.get(i))){
                        countMap.put(arr.get(i), new ArrayList<>());
                    }
                    countMap.get(arr.get(i)).add(i);
       }

        for (int i=0; i< arr.size(); i++){
            long k = arr.get(i);
            if (countMap.containsKey(k * r) && countMap.containsKey(k * r * r)) {
                count += countIndexSecond(i, countMap.get(k*r), countMap.get(k*r*r));
            }
        }

        return count;
    }

    static long countTripletsBackward(List<Long> arr, long r){
        Map<Long, Integer> values = new HashMap<>();
        Map<Long, Integer> pairs = new HashMap<>();


        long count = 0;
        for (int i=arr.size()-1; i >= 0; i--){
            if (pairs.containsKey(arr.get(i)*r)){
                count += pairs.get(arr.get(i)*r);
            }

            if (values.containsKey(arr.get(i) * r)){
                int pv = pairs.getOrDefault(arr.get(i), 0);
                pairs.put(arr.get(i), pv + values.get(arr.get(i) * r));
            }

            if (!values.containsKey(arr.get(i))){
                values.put(arr.get(i), 0);
            }
            values.put(arr.get(i), values.get(arr.get(i)) + 1);

        }

        return count;
    }

    private static long countIndexSecond(int i, List<Integer> l, List<Integer> ls){
        long count = 0;
        List<Integer> filtered = l.stream().filter(k -> k>i).collect(Collectors.toList());
        for (int first : filtered){
            count += ls.stream().filter(second -> second>first).count();
        }
        return count;
    }
}
