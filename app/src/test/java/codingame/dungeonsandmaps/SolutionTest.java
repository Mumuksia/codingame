package codingame.dungeonsandmaps;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void findPath() {

        String[] rows = new String[]{".>>v", ".^#v", "..#v", "...T"};
        char[][] map = new char[4][4];
        for (int i=0;i<4;i++){
            map[i] = rows[i].toCharArray();
        }
        Assert.assertEquals(6, Solution.findPath(map, 1, 1, new boolean[4][4], 0, 4, 4));
    }

    @Test
    public void findPath2() {

        String[] rows = new String[]{"....", ".v#.", ".v#.", ".>>T"};
        char[][] map = new char[4][4];
        for (int i=0;i<4;i++){
            map[i] = rows[i].toCharArray();
        }
        Assert.assertEquals(5, Solution.findPath(map, 1, 1, new boolean[4][4], 0, 4, 4));
    }

    /**
     * ....
     * .v#.
     * .v#.
     * .>>T
     *
     */
}
