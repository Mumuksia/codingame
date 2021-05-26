package codingame.bender_1;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int C = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        int x = 0,y = 0;

        char[][] map = new char[L][C];

        for (int i = 0; i < L; i++) {
            String row = in.nextLine();
            map[i] = row.toCharArray();
            if (row.contains("@")){
                x = i;
                y = row.indexOf('@');
                System.err.println("Starting position " + x + " " + y);
            }
        }

        printout(execute(map, x, y, L, C));
    }

    public static String execute(char[][] map, int x, int y, int L, int C){
        int[][] visited = new int[L][C];
        return step(map, x, y, visited, false, false, 'S', new StringBuilder());
    }

    //TODO breaker, Multiple Loops, Teleport
    public static String step(char[][] map, int x, int y, int[][] visited, boolean beer, boolean inverted, char modifier, StringBuilder path){
        if (visited[x][y] == (10 + getBeerModifier(beer) + getInvModifier(inverted) + getIntModifier(modifier))){
            return "LOOP";
        }
        visited[x][y] = (10 + getBeerModifier(beer) + getInvModifier(inverted) + getIntModifier(modifier));



        switch (map[x][y]) {
            case 'B': beer = !beer;
            break;
            case '$': return path.toString();
            case 'I': inverted = !inverted;
            case ' ':
            case '@':
                break;
            case 'X': map[x][y] = ' ';
            default: modifier = map[x][y];
        }

        char nextCell = getNextCell(x, y, modifier, map);

        switch (nextCell){
            case '#': char m = getObstacleModifier(map, x, y, beer, inverted);
                return step(map, getXForModifier(x, m), getYForModifier(y, m), visited, beer, inverted, m, path.append(m).append("Z"));
            case 'X': if (beer){
                return step(map, getXForModifier(x, modifier), getYForModifier(y, modifier), visited, true, inverted, modifier, path.append(modifier).append("Z"));
            } else {
                char m2 = getObstacleModifier(map, x, y, false, inverted);
                return step(map, getXForModifier(x, m2), getYForModifier(y, m2), visited, false, inverted, m2, path.append(m2).append("Z"));
            }
            default: return step(map, getXForModifier(x, modifier), getYForModifier(y, modifier), visited, beer, inverted, modifier, path.append(modifier).append("Z"));
        }
    }

    //add teleport points
    private static char getNextCell(int x, int y, char modifier, char[][] map){
        switch (modifier){
            case ('W'): return map[x][y-1];
            case ('E'): return map[x][y+1];
            case ('S'): return map[x+1][y];
            case ('N'): return map[x-1][y];
            default: return '#';
        }
    }

    private static char getObstacleModifier(char[][] map, int x, int y, boolean beer, boolean inverted){
        if (inverted){
            return getInvertedObstacleModifier(map, x, y, beer);
        }

        if (map[x+1][y] != '#' && (map[x+1][y] != 'X' || beer))
            return 'S';
        if (map[x][y+1] != '#' && (map[x][y+1] != 'X' || beer))
            return 'E';
        if (map[x-1][y] != '#' && (map[x-1][y] != 'X' || beer))
            return 'N';
        if (map[x][y-1] != '#' && (map[x][y-1] != 'X' || beer))
            return 'W';

        return ' ';
    }

    private static char getInvertedObstacleModifier(char[][] map, int x, int y, boolean beer){
        if (map[x][y-1] != '#' || (map[x][y-1] == 'X' && beer))
            return 'W';
        if (map[x-1][y] != '#' || (map[x-1][y] == 'X' && beer))
            return 'N';
        if (map[x][y+1] != '#' || (map[x][y+1] == 'X' && beer))
            return 'E';
        if (map[x+1][y] != '#' || (map[x+1][y] == 'X' && beer))
            return 'S';
        return ' ';

    }

    private static int getYForModifier(int y, char modifier){
        switch (modifier){
            case ('W'): return y-1;
            case ('E'): return y+1;
            default: return y;
        }
    }

    private static int getXForModifier(int x, char modifier){
        switch (modifier){
            case ('S'): return x+1;
            case ('N'): return x-1;
            default: return x;
        }
    }




    private static int getIntModifier(char modifier){
        switch (modifier){
            case ('W'): return 1;
            case ('E'): return 2;
            case ('S'): return 3;
            case ('N'): return 4;
            default: return 0;
        }
    }

    private static int getBeerModifier(boolean beer){
        return beer?100:0;
    }

    private static int getInvModifier(boolean inverted){
        return inverted?1000:0;
    }

    private static void printout(String sb){
        String[] lines = sb.split("Z");
        for (String s : lines)
            System.out.println(transformModifier(s));
    }

    private static String transformModifier(String m){
        switch (m){
            case ("W"): return "WEST";
            case ("E"): return "EAST";
            case ("S"): return "SOUTH";
            case ("N"): return "NORTH";
            default: return "LOOP";
        }
    }
}
