package codingame.logicgates;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    String a = "A __---___---___---___---___";


    @Test
    public void convertSignal() {

        Solution.convertSignal(a, a, "NAND");
    }
}
