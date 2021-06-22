package hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SherlockAnagrams {

    public static int sherlockAndAnagrams(String s) {
        Map<String, Integer> anagrams = new HashMap<>();
        char[] sc = s.toCharArray();
        for (int i=0;i<s.length(); i++){
            for (int j=0;j<s.length()-i; j++){
                char[] chars = Arrays.copyOfRange(sc, i, i+j+1);
                Arrays.sort(chars);
                String sorted = new String(chars);
                anagrams.put(sorted, anagrams.getOrDefault(sorted, 0) + 1);
            }
        }
        int count = 0;
        for(String k : anagrams.keySet()){
            count+=(anagrams.get(k)-1)*anagrams.get(k)/2;
        }

        return count;
    }
}
