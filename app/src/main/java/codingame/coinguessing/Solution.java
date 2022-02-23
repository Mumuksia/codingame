package codingame.coinguessing;

import java.util.*;
import java.io.*;
import java.math.*;

public class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int T = in.nextInt();
        int[][] rounds = new int[T][N];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < N; j++) {
                rounds[i][j] = in.nextInt();
            }
        }

        System.out.println(coinGuess(rounds));
    }

    public static String coinGuess(int[][] rounds) {

        Map<Integer, List<Integer>> possibleOptions = initPossibleOptions(rounds);
        for (int[] r : rounds){
            removeOptions(r, possibleOptions);
        }
        removeAssigned(possibleOptions);

        StringBuilder sb = new StringBuilder();
        for (int k: possibleOptions.keySet()){
            sb.append(possibleOptions.get(k).get(0)).append(" ");
        }

        return sb.toString().trim();
    }

    private static void removeAssigned(Map<Integer, List<Integer>> possibilities) {
        int toRemoveCount = 0;
        while (true) {
            List<Integer> toRemove = new ArrayList<>();
            for (int p : possibilities.keySet()) {
                if (possibilities.get(p).size() == 1) {
                    toRemove.add(possibilities.get(p).get(0));
                }
            }
            if (toRemoveCount == toRemove.size()){
                break;
            } else {
                toRemoveCount = toRemove.size();
            }
            for (int p : possibilities.keySet()) {
                if (possibilities.get(p).size() != 1) {
                    possibilities.get(p).removeAll(toRemove);
                }
            }
        }
    }

    private static void removeOptions(int[] round, Map<Integer, List<Integer>> possibilities) {
        List<Integer> orphanEvens = new ArrayList<>();
        for (int i : round) {
            if (i % 2 == 0) {
                orphanEvens.add(i);
            }
        }
        for (int i : round) {
            if (i % 2 != 0) {
                possibilities.get(i).removeAll(orphanEvens);
            }
        }
    }

    private static Map<Integer, List<Integer>> initPossibleOptions(int[][] rounds) {
        Map<Integer, List<Integer>> possibleOptions = new TreeMap<>();
        List<Integer> evens = new ArrayList<>();
        for (int i = 0; i < rounds[0].length*2; i += 2) {
            evens.add(i + 2);
        }
        for (int i = 1; i < rounds[0].length*2; i += 2) {
            possibleOptions.put(i, new ArrayList<>(evens));
        }
        return possibleOptions;
    }
}
