package leet;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestSubstringTest {

    LongestSubstring longestSubstring = new LongestSubstring();

    @Test
    public void lengthOfLongestSubstring() {

        assertEquals(4, longestSubstring.lengthOfLongestSubstring("jbpnbwwd"));
    }
}