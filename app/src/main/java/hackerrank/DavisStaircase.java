package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class DavisStaircase {
    static Map<Integer, Integer> perms = new HashMap<>();

    public static int stepPerms(int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        if (!perms.containsKey(n)){
            perms.put(n , stepPerms(n-1) + stepPerms(n-2) + stepPerms(n-3));
        }
        // Write your code here
        return perms.get(n);
    }

}
