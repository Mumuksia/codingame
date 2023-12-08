package leet;

import junit.framework.TestCase;

public class LargestOddNumberSubStringTest extends TestCase {

    public void testLargestOddNumber() {
        LargestOddNumberSubString testee = new LargestOddNumberSubString();

        assertEquals("5", testee.largestOddNumber("52"));
        assertEquals("35427", testee.largestOddNumber("35427"));
        assertEquals("", testee.largestOddNumber("4206"));
        assertEquals("35427", testee.largestOddNumber("354278"));
    }
}