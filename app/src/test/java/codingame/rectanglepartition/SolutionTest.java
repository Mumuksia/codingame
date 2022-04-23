package codingame.rectanglepartition;



import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void simpleSquare(){
        int[] width = new int[]{0,2,5,10};
        int[] height = new int[]{0,3,5};
        Assert.assertEquals(4, Solution.numberOfSquares(width, height, 10, 5));
    }

    @Test
    public void simpleSquare_2(){
        int[] width = new int[]{0,3,6,9};
        int[] height = new int[]{0,3,6,9};
        Assert.assertEquals(14, Solution.numberOfSquares(width, height, 9, 9));
    }
}