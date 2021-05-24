package codingame.crypto;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void execute() {
        Solution.execute(new ArrayList<>(Arrays.asList("COCA", "COLA")), "OASIS");
    }

    @Test
    public void basicSample() {
        Solution.execute(new ArrayList<>(Arrays.asList("A", "BB")), "ACC");
    }
}
