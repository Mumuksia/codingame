package codingame.enigmaencryption;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void shiftMessage() {
        Assert.assertEquals("EFG", String.valueOf(Solution.shiftMessage("AAA", 4)));
    }

    @Test
    public void shiftMessageD() {
        Assert.assertEquals("AAA", String.valueOf(Solution.shiftMessageDecode("EFG", 4)));
    }

    @Test
    public void shiftMessage2() {
        Assert.assertEquals("DMJDSQEFTFFJMQDJAWSOECB", String.valueOf(Solution.shiftMessage("WEATHERREPORTWINDYTODAY", 7)));
    }

    @Test
    public void shiftMessageD2() {
        Assert.assertEquals("WEATHERREPORTWINDYTODAY", String.valueOf(Solution.shiftMessageDecode("DMJDSQEFTFFJMQDJAWSOECB", 7)));
    }


    @Test
    public void encodeMsg() {
        Assert.assertEquals("KQF", String.valueOf(Solution.encode("EFG".toCharArray(), new String[]{"BDFHJLCPRTXVZNYEIWGAKMUSQO", "AJDKSIRUXBLHWTMCQGZNPYFVOE", "EKMFLGDQVZNTOWYHXUSPAIBRCJ"})));

    }

    @Test
    public void encodeMsg2() {
        Assert.assertEquals("ALWAURKQEQQWLRAWZHUYKVN",
                String.valueOf(Solution.encode("DMJDSQEFTFFJMQDJAWSOECB".toCharArray(), new String[]{"BDFHJLCPRTXVZNYEIWGAKMUSQO", "AJDKSIRUXBLHWTMCQGZNPYFVOE",
                        "EKMFLGDQVZNTOWYHXUSPAIBRCJ"})));

    }

    @Test
    public void decodeMsg() {
        Assert.assertEquals("EFG", String.valueOf(Solution.decode("KQF".toCharArray(), new String[]{"BDFHJLCPRTXVZNYEIWGAKMUSQO", "AJDKSIRUXBLHWTMCQGZNPYFVOE", "EKMFLGDQVZNTOWYHXUSPAIBRCJ"})));
    }

    @Test
    public void decodeMsg2() {
        Assert.assertEquals("DMJDSQEFTFFJMQDJAWSOECB",
                String.valueOf(Solution.decode("ALWAURKQEQQWLRAWZHUYKVN".toCharArray(), new String[]{"BDFHJLCPRTXVZNYEIWGAKMUSQO", "AJDKSIRUXBLHWTMCQGZNPYFVOE",
                        "EKMFLGDQVZNTOWYHXUSPAIBRCJ"})));

    }

    @Test
    public void execute() {
        Assert.assertEquals("KQF", String.valueOf(Solution.execute("ENCODE", "AAA", 4, new String[]{"BDFHJLCPRTXVZNYEIWGAKMUSQO", "AJDKSIRUXBLHWTMCQGZNPYFVOE", "EKMFLGDQVZNTOWYHXUSPAIBRCJ"})));
    }

    @Test
    public void executeD() {
        Assert.assertEquals("AAA", String.valueOf(Solution.execute("DECODE", "KQF", 4, new String[]{"BDFHJLCPRTXVZNYEIWGAKMUSQO", "AJDKSIRUXBLHWTMCQGZNPYFVOE", "EKMFLGDQVZNTOWYHXUSPAIBRCJ"})));
    }

}
