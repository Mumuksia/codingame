package codingame.weregoingcircles;
import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    static int w;
    static int h;
    static int numberOfLoops = 0;
    static char[][] grid;
    static boolean[][] partOfLoop;
    static boolean[][] partOfNoLoop;

    public static void main(String args[]) {
        numberOfLoops = 0;
        Scanner in = new Scanner(System.in);
        w = in.nextInt();
        h = in.nextInt();
        grid = new char[h][w];
        partOfLoop = new boolean[h][w];
        partOfNoLoop = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            String row = in.next();
            grid[i] = row.toCharArray();
        }

        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++) {
                List<CPair> route = Arrays.asList(new CPair(i, j));
                graphStep(i, j, route, grid[i][j]);
            }

        System.out.println(numberOfLoops);
    }

    public static int exposedSolution(char[][] gridx, int hx, int wx){
        numberOfLoops = 0;
        w= wx;
        h = hx;
        grid = gridx.clone();
        partOfLoop = new boolean[h][w];
        partOfNoLoop = new boolean[h][w];

        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++) {
                List<CPair> route = new ArrayList<>();
                graphStep(i, j, route, grid[i][j]);
            }

        return numberOfLoops;
    }

    private static void graphStep(int x, int y, List<CPair> route, char direction){
        if (x<0 || y<0 || x>=h || y>=w || partOfNoLoop[x][y]){
            partOfNoLoop = addCurrentToStateLoop(route, partOfNoLoop);
            return;
        }
        if (partOfLoop[x][y]){
            partOfLoop = addCurrentToStateLoop(route, partOfLoop);
            return;
        }

        if (route.contains(new CPair(x, y))){
            int temp = route.indexOf(new CPair(x, y));
            partOfNoLoop = addCurrentToStateLoop(route.subList(0, temp), partOfNoLoop);
            partOfLoop = addCurrentToStateLoop(route.subList(temp, route.size()), partOfLoop);
            numberOfLoops++;
            return;
        }
        if (grid[x][y] != '.'){
            route.add(new CPair(x, y));
        }


        char newDirection = grid[x][y] == '.'?direction:grid[x][y];
        switch (newDirection) {
            case '>' -> {
                //route.add(new CPair(x, y + 1));
                graphStep(x, y + 1, route, '>');
            }
            case '<' -> {
                //route.add(new CPair(x, y - 1));
                graphStep(x, y - 1, route, '<');
            }
            case '^' -> {
                //route.add(new CPair(x - 1, y));
                graphStep(x - 1, y, route, '^');
            }
            case 'v' -> {
                //route.add(new CPair(x + 1, y));
                graphStep(x + 1, y, route, 'v');
            }
            default -> {
            }
        }
    }

    private static boolean[][] addCurrentToStateLoop(List<CPair> route, boolean[][] currentState)
    {

        boolean[][] result = currentState.clone();

        for (CPair cp: route){
            result[cp.wx][cp.wy] = true;
        }
        return result;
    }

    static class CPair{
        int wx;
        int wy;

        public CPair(int wx, int wy) {
            this.wx = wx;
            this.wy = wy;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CPair cPair = (CPair) o;
            return wx == cPair.wx && wy == cPair.wy;
        }

        @Override
        public int hashCode() {
            return Objects.hash(wx, wy);
        }
    }

}