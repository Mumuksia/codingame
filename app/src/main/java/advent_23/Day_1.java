package advent_23;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day_1 {

    public int getCalibratedSum(String path) throws IOException, URISyntaxException {
        return Files.lines(Paths.get(getClass().getResource(path).toURI()))
                .mapToInt(this::calculateCalibratedValue)
                .sum();
    }

    public int getCalibratedSum_2(String path) throws IOException, URISyntaxException {
        return Files.lines(Paths.get(getClass().getResource(path).toURI()))
                .mapToInt(this::calculateCalibratedValue2)
                .sum();
    }

    private int calculateCalibratedValue(String s) {
        //remove all characters except digits
        String digits = s.replaceAll("[^\\d-]", "");
        return Character.getNumericValue(digits.charAt(0))*10 + Character.getNumericValue(digits.charAt(digits.length() - 1));
    }

    private int calculateCalibratedValue2(String s) {
        s= s.replaceAll("one", "o1ne");
        s= s.replaceAll("two", "t2wo");
        s= s.replaceAll("three", "t3ree");
        s= s.replaceAll("four", "fo4our");
        s= s.replaceAll("five", "fi5ve");
        s= s.replaceAll("six", "s6ix");
        s= s.replaceAll("seven", "sev7n");
        s= s.replaceAll("eight", "e8ight");
        s= s.replaceAll("nine", "n9ine");
        String digits = s.replaceAll("[^\\d-]", "");
        return Character.getNumericValue(digits.charAt(0))*10 + Character.getNumericValue(digits.charAt(digits.length() - 1));
    }
}
