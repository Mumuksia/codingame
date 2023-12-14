package leet;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();

        String smallest = Arrays.stream(strs).sorted((a, b) -> a.length() - b.length()).collect(Collectors.toList()).get(0);
        for (int i = 0; i< smallest.length(); i++){
            char c = smallest.charAt(i);
            for (String s : strs){
                if (c != s.charAt(i)){
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
