package hackerrank;

import org.junit.Test;

import static org.junit.Assert.*;

public class SuperDigitTest {

    @Test
    public void superDigit() {

        assertEquals(2, SuperDigit.superDigit("11", 1));
        assertEquals(3, SuperDigit.superDigit("148", 3));
        assertEquals(8, SuperDigit.superDigit("9875", 4));
        assertEquals(3, SuperDigit.superDigit("123", 3));
    }
}
