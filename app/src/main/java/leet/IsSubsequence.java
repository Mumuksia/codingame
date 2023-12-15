package leet;

import java.util.Arrays;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int j = 0;
        for (char c : sc){
            boolean found = false;
            for (int i = j; i<tc.length; i++){
                if (c == tc[i]){
                    j = i+1;
                    found = true;
                    break;
                }
            }
            if (!found){
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram(String s, String t) {
        char[] sa = s.toCharArray();
        Arrays.sort(sa);
        char[] ta = t.toCharArray();
        Arrays.sort(ta);
        return new String(sa).equals(new String(ta));
    }
}
