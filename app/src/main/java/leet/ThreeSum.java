package leet;

import java.util.*;
import java.util.stream.Stream;

public class ThreeSum {

    Map<Integer, List<Pair>> pairs = new HashMap<>();

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<String> triplets = new HashSet<>();
        for (int i = 0; i<nums.length-1; i++){
            for (int j = i+1; j<nums.length; j++){
                pairs.computeIfAbsent(nums[i] + nums[j], k -> new ArrayList<>());
                pairs.get(nums[i] + nums[j]).add(new Pair(nums[i], nums[j], i, j));
            }
        }

        //nums = Arrays.stream(nums).distinct().toArray();
        for (int i = 0; i < nums.length; i++){
            if (pairs.containsKey(-nums[i])){
                for (Pair p : pairs.get(-nums[i])){
                    if (p.i != i && p.j != i){
                        String triplet = Stream.of(p.x, p.y, nums[i]).sorted().map(x -> String.valueOf(x)).
                                reduce((a,b) -> a + b).get();
                        if (!triplets.contains(triplet)){
                            triplets.add(triplet);
                            result.add(List.of(p.x, p.y, nums[i]));
                        }

                    }
                }
            }
        }
        return result;
    }

    class Pair {
        int x;
        int y;
        int i;
        int j;

        public Pair(int x, int y, int i, int j) {
            this.x = x;
            this.y = y;
            this.i = i;
            this.j = j;
        }
    }
}
