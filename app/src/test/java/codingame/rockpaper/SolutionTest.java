package codingame.rockpaper;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void execute() {

        Assert.assertEquals(2,
                Solution.execute(new int[]{4, 1, 8, 3, 7, 5, 6, 2}, new char[]{'R', 'P', 'P', 'R', 'C', 'S', 'L', 'L'}, 8));
    }
}
