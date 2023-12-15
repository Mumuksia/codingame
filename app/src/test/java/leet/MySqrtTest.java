package leet;

import org.junit.Test;

import static org.junit.Assert.*;

public class MySqrtTest {

    MySqrt mySqrt = new MySqrt();
    @Test
    public void mySqrt() {

        assertEquals(46340, mySqrt.mySqrt(2147395600));
    }
}