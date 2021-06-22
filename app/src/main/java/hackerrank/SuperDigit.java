package hackerrank;

import java.math.BigInteger;

public class SuperDigit {



    public static int superDigit(String n, int k) {
        if (n.length() <=1){
            return Integer.parseInt(n);
        }
        long t = 0L;
        for (char c : n.toCharArray()){
            t += (int) c;
        }
        t*=k;
        return superDigit(String.valueOf(t), 1);
    }
}
