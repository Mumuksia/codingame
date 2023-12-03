package advent_23;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Day_3 {

    public int engine(String input) throws IOException, URISyntaxException {
        char[][] engine = readFileIntoCharArray(input);
        boolean keepNumber = false;
        String number = "";
        int sum = 0;
        for (int i = 1; i < engine.length - 1; i++) {
            for (int j = 1; j < engine[i].length - 1; j++) {
                if (engine[i][j] >= '0' && engine[i][j] <= '9') {
                    number += engine[i][j];
                    if (checkAdjustments(engine, i, j)) {
                        keepNumber = true;
                    }
                } else {
                    if (keepNumber && !number.isEmpty()) {
                        sum += Integer.parseInt(number);
                    }

                    keepNumber = false;
                    number = "";
                }

            }

            if (keepNumber && !number.isEmpty()) {
                sum += Integer.parseInt(number);
            }

            keepNumber = false;
        }
        return sum;
    }

    public int engine_2(String input) throws IOException, URISyntaxException {
        char[][] engine = readFileIntoCharArray(input);
        int sum = 0;
        for (int i = 1; i < engine.length - 1; i++) {
            for (int j = 1; j < engine[i].length - 1; j++) {
                if (engine[i][j] == '*'){
                    sum += checkAdjustments_2(engine, i, j);
                }
            }
        }

        return sum;
    }

    private boolean checkAdjustments(char[][] engine, int i, int j) {
        return engine[i + 1][j] != '.' || engine[i - 1][j] != '.' || engine[i + 1][j + 1] != '.' || engine[i + 1][j - 1] != '.' || engine[i - 1][j + 1] != '.' || engine[i - 1][j - 1] != '.' || !isDigitOrDot(
                engine[i][j + 1]) || !isDigitOrDot(engine[i][j - 1]);
    }

    private int checkAdjustments_2(char[][] engine, int i, int j) {
        int power  = 1;
        int count = 0;
        //check top/bottom row (if the middle is digit it means it adjusted only to 1 number at top.
        if (isDigit(engine[i-1][j])){
            count ++;
            power*=Integer.parseInt(getMiddleNumber(engine, i-1, j, engine[i-1][j]+""));
        } else {
            if (isDigit(engine[i-1][j-1])){
                count ++;
                power*=Integer.parseInt(getLeftNumber(engine, i-1, j-1, engine[i-1][j-1]+""));
            }
            if (isDigit(engine[i-1][j+1])){
                count ++;
                power*=Integer.parseInt(getRightNumber(engine, i-1, j+1, engine[i-1][j+1]+""));
            }
        }

        if (isDigit(engine[i+1][j])){
            count ++;
            power*=Integer.parseInt(getMiddleNumber(engine, i+1, j, engine[i+1][j]+""));
        } else {
            if (isDigit(engine[i+1][j-1])){
                count ++;
                power*=Integer.parseInt(getLeftNumber(engine, i+1, j-1, engine[i+1][j-1]+""));
            }
            if (isDigit(engine[i+1][j+1])){
                count ++;
                power*=Integer.parseInt(getRightNumber(engine, i+1, j+1, engine[i+1][j+1]+""));
            }
        }
        if (isDigit(engine[i][j-1])){
            count ++;
            power*=Integer.parseInt(getLeftNumber(engine, i, j-1, engine[i][j-1]+""));
        }
        if (isDigit(engine[i][j+1])){
            count ++;
            power*=Integer.parseInt(getRightNumber(engine, i, j+1, engine[i][j+1]+""));
        }


        if (count != 2){
            return 0;
        }
        return power;
    }

    private String getMiddleNumber(char[][] engine, int i, int j, String number){
        if (!isDigit(engine[i][j-1]) && !isDigit(engine[i][j+1])){
            return number;
        }
        if (isDigit(engine[i][j-1]) && isDigit(engine[i][j+1])){

            return getLeftNumber(engine, i, j-1, engine[i][j-1] + "") + number +
                    getRightNumber(engine, i, j+1, engine[i][j+1] + "");
        }
        if (isDigit(engine[i][j-1])){
            return getLeftNumber(engine, i, j-1, engine[i][j-1] + number);
        }
        if (isDigit(engine[i][j+1])){
            return getRightNumber(engine, i, j+1, number + engine[i][j+1]);
        }
        return number;
    }

    private String getLeftNumber(char[][] engine, int i, int j, String number){
        if (!isDigit(engine[i][j-1])){
            return number;
        }
        return getLeftNumber(engine, i, j-1, engine[i][j-1] + number);
    }

    private String getRightNumber(char[][] engine, int i, int j, String number){
        if (!isDigit(engine[i][j+1])){
            return number;
        }
        return getRightNumber(engine, i, j+1, number + engine[i][j+1]);
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isDigitOrDot(char c) {
        return c >= '0' && c <= '9' || c == '.';
    }




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
