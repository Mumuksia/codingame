package codingame.spreadshits;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    static HashMap<Integer, Integer> cached = new HashMap<>();

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String[] cells = new String[N];
        for (int i = 0; i < N; i++) {
            String operation = in.next();
            String arg1 = in.next();
            String arg2 = in.next();
            if ("VALUE".equals(operation)){
                cells[i] = arg1;
            } else {
                cells[i] = operation + " " + arg1 + " " + arg2;
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(getValue(cells, "$" + i));
        }
    }

    public static void execute(String[] cells, int N){
        for (int i = 0; i < N; i++) {
            System.out.println(getValue(cells, "$" + i));
        }
    }

    private static int getValue(String[] cells, String i){
        if (!i.contains("$")){
            return Integer.parseInt(i);
        }
        if (cached.containsKey(cutCellIndex(i))){
            return cached.get(cutCellIndex(i));
        }
        String[] line = cells[cutCellIndex(i)].split(" ");
        switch (line[0]) {
            case "ADD": cached.put(cutCellIndex(i), getValue(cells, (line[1])) + getValue(cells, (line[2])));break;
            case "SUB": cached.put(cutCellIndex(i), getValue(cells, (line[1])) - getValue(cells, (line[2])));break;
            case "MULT": cached.put(cutCellIndex(i), getValue(cells, (line[1])) * getValue(cells, (line[2])));break;
            default: if (!line[0].contains("$")) {
                cached.put(cutCellIndex(i), Integer.parseInt(line[0]));
                return Integer.parseInt(line[0]);
            } else {
                cached.put(cutCellIndex(i), getValue(cells, line[0]));
            }
        }
        return cached.get(cutCellIndex(i));
    }

    private static int cutCellIndex(String ci){
        return Integer.parseInt(ci.replace("$", ""));
    }
}
