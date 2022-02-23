package codingame.coinguessing;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void testCoinGuess() {
        int[][] rounds = {
                {4, 2},
                {2, 4},
                {4, 3}
        };
        assertEquals("4 2", Solution.coinGuess(rounds));

    }

    public void testCoinGuess_threeCoins() {
        int[][] rounds = {
                {3, 1, 6},
                {4, 1, 6}
        };
        assertEquals("2 4 6", Solution.coinGuess(rounds));

    }
}