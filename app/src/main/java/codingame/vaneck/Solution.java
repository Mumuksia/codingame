package codingame.vaneck;
import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    private static Map<Long, Long> numbers = new HashMap<>();
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int A1 = in.nextInt();
        int N = in.nextInt();



        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(execute(N, A1));
    }

    public static String execute(int N, int A1){
        //System.err.println(A1);
        numbers.put((long) A1, 1L);
        if (N == 1){
            System.out.println(A1);
            return String.valueOf(A1);
        }

        long prev = 0;
        for (int i = 2; i < N; i++){
            if (prev == 0){
                //System.err.println(0);
                if (numbers.containsKey((long) 0)){
                    prev = i - numbers.get((long) 0);
                }
                numbers.put(0L, (long) i);
            } else {
                //System.err.println(prev);
                if (numbers.containsKey(prev)) {

                    long temp = i - numbers.get(prev);
                    numbers.put(prev, (long) i);
                    prev = temp;
                } else {
                    numbers.put(prev, (long) i);
                    prev = 0;
                }

            }
        }
        return String.valueOf(prev);
    }
}
