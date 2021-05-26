package codingame.bender_1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void execute() {
        String[] rows = new String[]{"######", "#@E $#", "# N  #", "#X   #", "######"};
        char[][] map = new char[5][6];
        for (int i=0;i<5;i++){
            map[i] = rows[i].toCharArray();
        }
        Assert.assertEquals("", Solution.execute(map, 1, 1, 5, 6));
    }
}
