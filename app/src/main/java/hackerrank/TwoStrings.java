package hackerrank;

public class TwoStrings {

    public static String twoStrings(String s1, String s2) {
        boolean[] chars = new boolean[150];
        for (Character c: s1.toCharArray()){
            chars[c] = true;
        }

        for (Character c: s2.toCharArray()){
            if (chars[c]){
                return "YES";
            }
        }
        return "NO";
    }
}
