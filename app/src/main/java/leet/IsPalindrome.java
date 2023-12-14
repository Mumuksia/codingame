package leet;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IsPalindrome {
    public boolean isPalindrome(String s) {
        s=s.trim().toLowerCase().replaceAll("[^0-9a-zA-Z]", "");

        char[] pal = s.toCharArray();
        for (int i = 0; i<pal.length/2;i++){
            if (pal[i] != pal[pal.length-1-i]){
                return false;
            }
        }
        return true;
    }
}
