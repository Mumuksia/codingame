package advent_23;

import junit.framework.TestCase;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day_8Test extends TestCase {

    private String instructions = "LRRRLRRRLRRLRLRRLRLRRLRRLRLLRRRLRLRLRRRLRRRLRLRLRLLRRLLRRLRRRLLRLRRRLRLRLRRRLLRLRRLRRRLRLRRRLLRLRRLRRRLRRLRRLRLRRLRRRLRLRRRLRRLLRRLRRLRLRRRLRRLRRRLRRRLRLRRLRLRRRLRLRRLRRLRRRLRRRLRRRLLRRLRRRLRLRLRLRRRLRLRLRRLRRRLRRRLRRLRRLLRLRRLLRLRRLRRLLRLLRRRLLRRLLRRLRRLRLRLRRRLLRRLRRRR";

    public void testNavigation() {
        // Your structure
        String input = "AAA = (BBB, CCC)\n" +
                "BBB = (DDD, EEE)\n" +
                "CCC = (ZZZ, GGG)\n" +
                "DDD = (DDD, DDD)\n" +
                "EEE = (EEE, EEE)\n" +
                "GGG = (GGG, GGG)\n" +
                "ZZZ = (ZZZ, ZZZ)";

        // Split the input into lines
        String[] lines = input.split("\n");

        Day_8 day8 = new Day_8();
        assertEquals(2, day8.navigation(lines, "RL"));
    }

    public void testNavigation_2() {
        // Your structure
        String input = "AAA = (BBB, BBB)\n" +
                "BBB = (AAA, ZZZ)\n" +
                "ZZZ = (ZZZ, ZZZ)";

        // Split the input into lines
        String[] lines = input.split("\n");

        Day_8 day8 = new Day_8();
        assertEquals(6, day8.navigation(lines, "LLR"));
    }

    public void testNavigation_3() throws URISyntaxException, IOException {
        // Your structure
        String input = Files.readString(Paths.get(getClass().getResource("/advent_23/day8.txt").toURI()));

        // Split the input into lines
        String[] lines = input.split("\n");

        Day_8 day8 = new Day_8();
        assertEquals(6, day8.navigation(lines, instructions));
    }

    public void testNavigation_part2_1() {
        // Your structure
        String input = "11A = (11B, XXX)\n" +
                "11B = (XXX, 11Z)\n" +
                "11Z = (11B, XXX)\n" +
                "22A = (22B, XXX)\n" +
                "22B = (22C, 22C)\n" +
                "22C = (22Z, 22Z)\n" +
                "22Z = (22B, 22B)\n" +
                "XXX = (XXX, XXX)";

        // Split the input into lines
        String[] lines = input.split("\n");

        Day_8 day8 = new Day_8();
        assertEquals(6, day8.navigation_2(lines, "LR"));
    }

    public void testNavigation_part2_2() throws URISyntaxException, IOException {
        // Your structure
        String input = Files.readString(Paths.get(getClass().getResource("/advent_23/day8.txt").toURI()));

        // Split the input into lines
        String[] lines = input.split("\n");

        Day_8 day8 = new Day_8();
        assertEquals(6, day8.navigation_2(lines, instructions));
    }
}