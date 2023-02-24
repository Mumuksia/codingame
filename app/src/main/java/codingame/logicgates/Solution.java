package codingame.logicgates;

import java.util.*;
import java.io.*;
import java.math.*;
import java.util.stream.Collectors;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        for (int i = 0; i < n; i++) {
            String inputName = in.next();
            String inputSignal = in.next();
        }
        for (int i = 0; i < m; i++) {
            String outputName = in.next();
            String type = in.next();
            String inputName1 = in.next();
            String inputName2 = in.next();
            System.out.println(outputName + " " + convertSignal(inputName1, inputName2, type));
        }
    }

    public static String convertSignal(String a, String b, String command){

        List<Boolean> ab = transform(a);
        List<Boolean> bb = transform(b);

        switch (command){
            case "AND" : return decode(operationAnd(ab, bb));
            case "OR" : return decode(operationOr(ab, bb));
            case "XOR" : return decode(operationXor(ab, bb));
            case "NOR" : return decode(operationOrInv(ab, bb));
            case "NAND" : return decode(operationAndInv(ab, bb));
            case "NXOR" : return decode(operationXorInv(ab, bb));
            default: return "";
        }

    }

    private static List<Boolean> operationAnd(List<Boolean> a, List<Boolean> b){
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i<a.size(); i++){
            res.add(a.get(i) && b.get(i));
        }
        return res;
    }

    private static List<Boolean> operationOr(List<Boolean> a, List<Boolean> b){
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i<a.size(); i++){
            res.add(a.get(i) || b.get(i));
        }
        return res;
    }


    private static List<Boolean> operationXor(List<Boolean> a, List<Boolean> b){
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i<a.size(); i++){
            res.add((a.get(i)^b.get(i)));
        }
        return res;
    }

    private static List<Boolean> operationAndInv(List<Boolean> a, List<Boolean> b){
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i<a.size(); i++){
            res.add(!(a.get(i) && b.get(i)));
        }
        return res;
    }

    private static List<Boolean> operationOrInv(List<Boolean> a, List<Boolean> b){
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i<a.size(); i++){
            res.add(!(a.get(i) || b.get(i)));
        }
        return res;
    }

    private static List<Boolean> operationXorInv(List<Boolean> a, List<Boolean> b){
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i<a.size(); i++){
            res.add(a.get(i) == b.get(i));
        }
        return res;
    }

    private static List<Boolean> transform(String s){
        return s.chars().mapToObj(c-> c == '-').collect(Collectors.toList());
    }

    private static String decode(List<Boolean> str){
        return str.stream().map(s -> s?"-":"_").collect(Collectors.joining());
    }


}
