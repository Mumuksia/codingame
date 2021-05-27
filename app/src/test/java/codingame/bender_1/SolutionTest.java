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
        Assert.assertEquals("SZEZNZEZEZ", Solution.execute(map, 1, 1, 5, 6));
    }

    /**
     * 10 10
     * ##########
     * # @      #
     * # B      #
     * #XXX     #
     * # B      #
     * #    BXX$#
     * #XXXXXXXX#
     * #        #
     * #        #
     * ##########
     */

    @Test
    public void executeBreaker() {
        String[] rows = new String[]{"##########", "# @      #", "# B      #", "#XXX     #", "# B      #", "#    BXX$#", "#XXXXXXXX#", "#        #", "#        #", "##########"};
        char[][] map = new char[10][10];
        for (int i=0;i<10;i++){
            map[i] = rows[i].toCharArray();
        }
        Assert.assertEquals("SZSZSZSZEZEZEZEZEZEZ", Solution.execute(map, 1, 2, 10, 10));
    }

    /**
     *10 10
     * ##########
     * #    T   #
     * #        #
     * #        #
     * #        #
     * #@       #
     * #        #
     * #        #
     * #    T  $#
     * ##########
     */

    @Test
    public void executeTeleport() {
        String[] rows = new String[]{"##########", "#    T   #", "#        #", "#        #", "#        #", "#@       #", "#        #", "#        #", "#    T  $#", "##########"};
        char[][] map = new char[10][10];
        for (int i=0;i<10;i++){
            map[i] = rows[i].toCharArray();
        }
        Assert.assertEquals("SZSZSZSZEZEZEZEZEZEZ", Solution.execute(map, 6, 1, 10, 10));
    }

    /**
     *15 15
     ###############
     #      X$     #
     #      X      #
     #  @   X      #
     #      X     T#
     #      XXXXXXX#
     #  B   T      #
     #  X          #
     #  X          #
     #  B          #
     #    B  BI  NX#
     #  XXXXXX     #
     #             #
     #             #
     ###############
     */

    @Test
    public void executeValidation() {
        String[] rows = new String[]{"###############", "#      X$     #", "#      X      #", "#  @   X      #", "#      X     T#",
                "#      XXXXXXX#", "#  B   T      #", "#  X          #", "#  X          #",
                "#  B          #", "#    B  BI  NX#", "#  XXXXXX     #", "#             #", "#             #", "###############"};
        char[][] map = new char[15][15];
        for (int i=0;i<15;i++){
            map[i] = rows[i].toCharArray();
        }
        String result = Solution.execute(map, 3, 3, 15, 15);
        //Solution.printout(result);
        Assert.assertEquals("SZSZSZSZSZSZSZEZEZEZEZEZEZEZEZEZNZNZNZNZWZWZWZWZWZWZWZWZWZWZNZNZNZ", result);
    }
}
