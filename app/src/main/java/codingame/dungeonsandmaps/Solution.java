package codingame.dungeonsandmaps;

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
        int w = in.nextInt();
        int h = in.nextInt();
        int startRow = in.nextInt();
        int startCol = in.nextInt();
        int n = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        char[][] map = new char[h][w];

        int min = 500;
        int result = -1;
        for (int i = 0; i < n; i++) {
            boolean[][] visited = new boolean[h][w];
            for (int j = 0; j < h; j++) {
                String mapRow = in.nextLine();
                map[j] = mapRow.toCharArray();

            }
            int temp = findPath(map, startCol, startRow, visited, 0, w, h);
            if (temp > 0 && temp < min){
                min = temp;
                result = i;
            }
        }

        if (result == -1){
            System.out.println("TRAP");
        } else {
            System.out.println(result);
        }
    }

    public static int findPath(char[][] map, int x, int y, boolean[][] visited, int length, int w, int h){
        if (x >= h || x < 0 || y>=w || y<0 || visited[x][y]){
            return -1;
        }
        visited[y][x] = true;

        switch (map[y][x]){
            case 'T': return length;
            case '.': return -1;
            case '#': return -1;
            case '>': return findPath(map, x+1, y, visited, length+1, w, h);
            case '<': return findPath(map, x-1, y, visited, length+1, w, h);
            case 'v': return findPath(map, x, y+1, visited, length+1, w, h);
            case '^': return findPath(map, x, y-1, visited, length+1, w, h);
            default: return -1;
        }
    }
}
