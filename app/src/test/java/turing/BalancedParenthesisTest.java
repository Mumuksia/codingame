package turing;

import org.junit.Assert;
import org.junit.Test;

public class BalancedParenthesisTest {

    @Test
    public void testValid(){
        Assert.assertTrue(BalancedParenthesis.isValid("{[]}"));
        Assert.assertTrue(BalancedParenthesis.isValid("{}"));
        Assert.assertTrue(BalancedParenthesis.isValid("{[((()))]}"));
    }

    @Test
    public void testNotValid(){
        Assert.assertFalse(BalancedParenthesis.isValid("{[]}("));
        Assert.assertFalse(BalancedParenthesis.isValid("{[}}"));
        Assert.assertFalse(BalancedParenthesis.isValid("{[((([)]))]}"));
    }

}