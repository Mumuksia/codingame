package codingame.grandfestival;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    static int[][] memo;
    static int R;
    static int N;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        R = in.nextInt();
        memo = new int[N+1][R+1];
        int[] red = new int[R+1];
        for (int i = 0; i < R + 1; i++) {
            red[i] = -1;
        }
        int[] prizes = new int[N];
        for (int i = 0; i < N; i++) {
            prizes[i] = in.nextInt();
            memo[i] = red;
        }
        memo[N] = red;

        System.out.println(findPrize(prizes, 0, R));
    }

    public static int findPrize(int[] prizes, int day, int step){

        if (day == N){
            return 0;
        }

        if (step == 0){
            return findPrize(prizes, day+1, R);
        }

        int prize_excluded;
        if (memo[day+1][R] == -1){
            prize_excluded = findPrize(prizes, day+1, R);
            memo[day+1][R] = prize_excluded;
        } else {
            prize_excluded = memo[day+1][R];
        }

        int prize_included;
        if (memo[day+1][step-1] == -1){
            prize_included = prizes[day] + findPrize(prizes, day+1, step-1);
            memo[day+1][step-1] = prize_included;
        } else{
            prize_included = memo[day+1][step-1];
        }

        return Math.max(prize_excluded, prize_included);
    }
}
