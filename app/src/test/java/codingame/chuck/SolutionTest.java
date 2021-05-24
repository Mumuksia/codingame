package codingame.chuck;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void execute() {

        //System.out.println(Integer.toBinaryString((int) '%'));
        Assert.assertEquals("0 0 00 0000 0 000 00 0000 0 00", Solution.execute("CC"));
    }

    @Test
    public void execute2() {

        //System.out.println(Integer.toBinaryString((int) '%'));
        Assert.assertEquals("00 0 0 0 00 00 0 0 00 0 0 0", Solution.execute("%"));
    }
}
