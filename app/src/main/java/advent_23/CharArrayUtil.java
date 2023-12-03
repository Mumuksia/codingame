package advent_23;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CharArrayUtil {

    private char[][] readFileIntoCharArray(String filePath) throws IOException, URISyntaxException {
        char[][] charArray;
        Path path = Paths.get(getClass().getResource(filePath).toURI());
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        int numRows = lines.size() + 2;
        int maxRowLength = lines.stream().mapToInt(String::length).max().orElse(0);
        int numCols = maxRowLength + 2;

        charArray = new char[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                charArray[i][j] = '.';
            }
        }

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            line.getChars(0, line.length(), charArray[i + 1], 1);
        }

        return charArray;

    }
}
