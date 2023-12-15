package leet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        List<Character> temp = new ArrayList<>();
        if (s.length() == 1) {
            return 1;
        }

        int counter = 0;
        int max = 0;
        for (Character c : s.toCharArray()) {
            if (temp.contains(c)) {
                if (counter > max) {
                    max = counter;
                }
                while (temp.contains(c)) {
                    temp.remove(0);
                    counter--;
                }
                temp.add(c);
                counter++;
            } else {
                counter++;
                temp.add(c);
            }
        }
        return Math.max(max, counter);
    }
}
