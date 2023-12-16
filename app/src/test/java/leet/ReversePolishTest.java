package leet;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReversePolishTest {

    ReversePolish reversePolish = new ReversePolish();

    @Test
    public void evalRPN() {

        assertEquals(9, reversePolish.evalRPN(new String[]{"2","1","+","3","*"}));
    }
}