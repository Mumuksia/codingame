package codingame.weregoingcircles;

import org.junit.Assert;
import org.junit.Test;


public class SolutionTest{

    @Test
    public void simpleCircle(){

        String row1 = ">.>.v";
        String row2 = "....v";
        String row3 = "....v";
        String row4 = "^<<<<";

        char[][] grid = new char[4][5];
        grid[0] = row1.toCharArray();
        grid[1] = row2.toCharArray();
        grid[2] = row3.toCharArray();
        grid[3] = row4.toCharArray();

        Assert.assertEquals(1, Solution.exposedSolution(grid, 4, 5));
    }

    @Test
    public void nto_simpleCircle(){

        String row1 = "v...<";
        String row2 = ".....";
        String row3 = ">.v.^";

        char[][] grid = new char[4][5];
        grid[0] = row1.toCharArray();
        grid[1] = row2.toCharArray();
        grid[2] = row3.toCharArray();

        Assert.assertEquals(0, Solution.exposedSolution(grid, 3, 5));
    }

    @Test
    public void nto_simpleCircle_2(){

        String row1 = "v...<";
        String row2 = ".>.v.";
        String row3 = ".^^<.";
        String row4 = ">.v.^";

        char[][] grid = new char[4][5];
        grid[0] = row1.toCharArray();
        grid[1] = row2.toCharArray();
        grid[2] = row3.toCharArray();
        grid[3] = row3.toCharArray();

        Assert.assertEquals(0, Solution.exposedSolution(grid, 4, 5));
    }

}