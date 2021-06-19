package hackerrank;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountTriplets {

    static long countTriplets(List<Long> arr, long r) {
        //Map<Integer, Integer> countMap = new HashMap<>();

        Map<Long, Long> countMap = arr.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        long count = 0;
        for (Long k : countMap.keySet()){
                    if (countMap.containsKey(k * r) && countMap.containsKey(k * r * r)) {
                        count += countMap.get(k) * countMap.get(k * r) * countMap.get(k * r * r);
                    }

       }
        return count;
    }
}
