package medium;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class FibonacciTest {

    Fibonacci fibonacci = new Fibonacci();

    @Test
    public void getFibonacci() {
        assertEquals(new BigInteger("34"), fibonacci.getFibonacci(9));

        assertEquals(new BigInteger("354224848179261915075"), fibonacci.getFibonacci(100));

        assertEquals(new BigInteger("280571172992510140037611932413038677189525"), fibonacci.getFibonacci(200));
    }
}