package codingame.rockpaper;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

/**
 * Rock (R)
 * Paper (P)
 * sCissors (C)
 * Lizard (L)
 * Spock (S)
 *
 * Scissors cuts Paper
 * Paper covers Rock
 * Rock crushes Lizard
 * Lizard poisons Spock
 * Spock smashes Scissors
 * Scissors decapitates Lizard
 * Lizard eats Paper
 * Paper disproves Spock
 * Spock vaporizes Rock
 * Rock crushes Scissors
 */
class Solution {

    static Map<Integer, List<Integer>> path = new HashMap<>();

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] players = new int[N];
        char[] state = new char[N];
        for (int i = 0; i < N; i++) {
            int NUMPLAYER = in.nextInt();
            String SIGNPLAYER = in.next();
            players[i] = NUMPLAYER;
            state[i] = SIGNPLAYER.charAt(0);
        }


        int winner = execute(players, state, N);
        System.out.println(winner);

        path.get(winner).forEach(n -> System.out.print(n + " "));
    }

    public static int execute(int[] players, char[] state, int size){
        if (size == 1){
            return players[0];
        }


        int[] newPlayers = new int[size/2];
        char[] newState = new char[size/2];
        for (int i=1; i < size; i+=2){
            if (checkIfWinner(state[i], state[i-1], players[i], players[i-1])){
                if (!path.containsKey(players[i]))
                    path.put(players[i], new ArrayList<>());
                newPlayers[(i-1)/2] = players[i];
                newState[(i-1)/2] = state[i];
                path.get(players[i]).add(players[i-1]);
            } else {
                if (!path.containsKey(players[i-1]))
                    path.put(players[i-1], new ArrayList<>());

                newPlayers[(i-1)/2] = players[i-1];
                newState[(i-1)/2] = state[i-1];
                path.get(players[i-1]).add(players[i]);
            }
        }

        return execute(newPlayers, newState, size/2);
    }

    private static boolean checkIfWinner(char p, char o, int pp, int po){
        switch (p) {
            case 'R': return o == 'L' || o == 'C' || (o == 'R' && pp < po);
            case 'P': return o == 'R' || o == 'S' || (o == 'P' && pp < po);
            case 'C': return o == 'P' || o == 'L' || (o == 'C' && pp < po);
            case 'L': return o == 'S' || o == 'P' || (o == 'L' && pp < po);
            case 'S': return o == 'R' || o == 'C' || (o == 'S' && pp < po);
            default: return true;
        }
    }
}
