package codingame.vaneck;

import org.junit.Test;
import org.junit.Assert;

public class SolutionTest {

    @Test
    public void vaneckTest1(){
        Assert.assertEquals(Solution.execute(1000000, 0), "34143");
    }

    @Test
    public void vaneckTest2(){
        Assert.assertEquals(Solution.execute(56804, 1), "29");
    }
}
