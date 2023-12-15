package leet;

import java.util.Arrays;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();

        Arrays.sort(sa);
        Arrays.sort(ta);
        if (s.length() == 1){
            return true;
        }
        for (int i = 1; i<sa.length; i++){
            if (sa[i-1] != sa[i] && ta[i-1] == ta[i]){
                return false;
            }
            if (sa[i-1] == sa[i] && ta[i-1] != ta[i]){
                return false;
            }
        }
        return true;
    }
}
