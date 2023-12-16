package leet;

import java.util.*;

public class GroupAnagrams {

    Map<String, List<String>> anagrams = new HashMap<>();
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        for (String s : strs){
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String sortedS = new String(cs);

            anagrams.computeIfAbsent(sortedS, k -> new ArrayList<>());
            anagrams.get(sortedS).add(s);
        }

        for (String s : anagrams.keySet()){
            result.add(anagrams.get(s));
        }

        return result;
    }
}
