package codingame.card_counting;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void cardCounting(){
        assertEquals(67L,
                Solution.cardCounting("222.333.444.some distraction.555.5.678.678.678.678.another distraction.9999.TTTT.JJJJ.QQQQ.KKKK.AAAA", 4));
    }
}
