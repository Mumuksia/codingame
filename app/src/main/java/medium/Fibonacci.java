package medium;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    static Map<Long, BigInteger> fibonacciMap = new HashMap<>();

    static {
        fibonacciMap.put(0L, BigInteger.ZERO);
        fibonacciMap.put(1L, BigInteger.ONE);
    }

    public BigInteger getFibonacci(long n){
        if (n < 2){
            return fibonacciMap.get(n);
        }
        if (fibonacciMap.containsKey(n)){
            return fibonacciMap.get(n);
        }
        fibonacciMap.put(n, getFibonacci(n-1).add(getFibonacci(n-2)));
        return fibonacciMap.get(n);
    }


}
