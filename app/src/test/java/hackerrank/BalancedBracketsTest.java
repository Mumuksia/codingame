package hackerrank;

import org.junit.Test;

import static org.junit.Assert.*;

public class BalancedBracketsTest {

    @Test
    public void isBalanced() {
        assertEquals("YES", BalancedBrackets.isBalanced("()()()"));
        assertEquals("YES", BalancedBrackets.isBalanced("([{{}}])()()"));
        assertEquals("NO", BalancedBrackets.isBalanced("())()()"));
        assertEquals("NO", BalancedBrackets.isBalanced("("));
        assertEquals("NO", BalancedBrackets.isBalanced("(()()()()()"));
    }
}
