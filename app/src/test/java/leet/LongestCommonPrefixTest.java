package leet;

import junit.framework.TestCase;

public class LongestCommonPrefixTest extends TestCase {

    public void testLongestCommonPrefix(){
        LongestCommonPrefix prefix = new LongestCommonPrefix();
        String[] input = new String[]{"flower","flow","flight"};
        assertEquals("fl", prefix.longestCommonPrefix(input));

        input = new String[]{"dog","racecar","car"};
        assertEquals("", prefix.longestCommonPrefix(input));
    }

}