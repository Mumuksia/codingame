package codingame.rectanglepartition;

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
        int countX = in.nextInt();
        int countY = in.nextInt();
        int width[] = new int[countX+2];
        int height[] = new int[countY+2];

        for (int i = 0; i < countX; i++) {
            width[i] = in.nextInt();
        }
        for (int i = 0; i < countY; i++) {
            height[i] = in.nextInt();
        }
        width[countX] = w;
        width[countX+1] = 0;

        width[countY] = h;
        width[countY+1] = 0;
        int[] possibleWidths = new int[(countX+2)*(countX+2)];
        int[] possibleHeights = new int[(countY+2)*(countY+2)];
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(numberOfSquares(width, height, w, h));
    }

    public static long numberOfSquares(int[] width, int[] height, int w, int h){
        int[] possibleW = new int[w + 2];
        int[] possibleH = new int[h + 2];

        Arrays.sort(width);
        Arrays.sort(height);

        long result = 0;

        for (int i=0;i<width.length;i++){
            for (int j = i+1; j<width.length;j++){
                possibleW[width[j]-width[i]]++;
            }
        }
        for (int i=0;i<height.length;i++){
            for (int j = i+1; j<height.length;j++){
                possibleH[height[j]-height[i]]++;
            }
        }

        for (int i=0;i<possibleW.length;i++){
            if (i < possibleH.length)
                result += (long) possibleW[i] * possibleH[i];
        }
        return result;
    }
}