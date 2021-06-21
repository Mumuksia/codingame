package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyQueries {

    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> result = new ArrayList<>();

        Map<Integer, Integer> values = new HashMap<>();
        Map<Integer, Integer> frequencies = new HashMap<>();

        for (List<Integer> query : queries){
            switch (query.get(0)){
                case 1:
                    values.put(query.get(1), values.getOrDefault(query.get(1), 0) + 1);
                    frequencies.put(values.get(query.get(1)), frequencies.getOrDefault(values.get(query.get(1)), 0) + 1);
                    frequencies.put(getOrDefaultMinus(values, query.get(1)), getOrDefaultMinus(frequencies, values.get(query.get(1))));
                    break;
                case 2:
                    if (values.containsKey(query.get(1)) && values.get(query.get(1)) > 0){
                        frequencies.put(values.get(query.get(1)), getOrDefaultMinus(frequencies, values.get(query.get(1))));
                        values.put(query.get(1), getOrDefaultMinus(values, query.get(1)));
                        frequencies.put(values.get(query.get(1)), frequencies.getOrDefault(values.get(query.get(1)), 0) + 1);
                    }

                    break;
                default:
                    frequencies.remove(0);
                    if (frequencies.containsKey(query.get(1)) && frequencies.get(query.get(1)) > 0){
                        result.add(1);
                    } else {
                        result.add(0);
                    }
                    break;
            }
        }

        return result;
    }

    private static int getOrDefaultMinus(Map<Integer, Integer> map, int value){
        if (map.containsKey(value) && map.get(value) > 0 && value > 0){
            return map.get(value) - 1;
        }
        return 0;
    }


}
