package hackerrank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IceCreamLabour {

    public static void whatFlavors(List<Integer> cost, int money) {
        Map<Integer, Integer> prices = new HashMap<>();

        for (int i=0; i<cost.size(); i++){
            if (prices.containsKey(money - cost.get(i))){
                System.out.println((prices.get(money-cost.get(i)) + 1) + " " + (i+1));
                return;
            }
            if (!prices.containsKey(cost.get(i))){
                prices.put(cost.get(i), i);
            }
        }
    }
}
