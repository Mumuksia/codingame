package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
        Map<Character, Integer> maps = new HashMap<>();
        int maxFreq = 1;
        int maxCount = 0;
        for (Character c : s.toCharArray()){
            if (maps.containsKey(c)){
                int temp = maps.get(c);
                maps.put(c, temp+1);
                maxFreq +=1;
            } else {
                maps.put(c, 1);
            }
        }

        int base = -1;
        int baseTemp = -1;
        boolean diff = false;

        for (Integer i : maps.values()){
            if (base == -1){
                base = i;
            }
            if (i != base){
                baseTemp = i;
            }

            if (i != base || i!=baseTemp){
                return "NO";
            }

        }
        return "";
    }

}
