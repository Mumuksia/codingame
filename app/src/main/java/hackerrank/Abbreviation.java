package hackerrank;

public class Abbreviation {

    static String abbreviation(String a, String b) {
        int aLen = a.length(), bLen=b.length();
        // arr[i][j] = true iff a(0..i-1) can match b(0..j-1)
        boolean[][] arr = new boolean[aLen+1][bLen+1];
        arr[0][0] = true;
        for (int i=1; i<=aLen; i++) {
            arr[i][0] = arr[i-1][0] && Character.isLowerCase(a.charAt(i-1));
        }
        for (int i=1; i<=aLen; i++) {
            for (int j=1; j<=bLen; j++) {
                arr[i][j] = (arr[i-1][j-1] && Character.toUpperCase(a.charAt(i-1)) == b.charAt(j-1)) ||
                        (arr[i-1][j] && Character.isLowerCase(a.charAt(i-1)));
            }
        }

        return (arr[aLen][bLen]) ? "YES" : "NO";
    }


}
