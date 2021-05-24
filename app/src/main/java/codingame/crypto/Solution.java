package codingame.crypto;

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
        int N = in.nextInt();
        List<String> words = new ArrayList<>();
        char[] lettersChars = new char[10];

        List<Character> letters = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            String word = in.next();
            for (char c : word.toCharArray()){
                letters.add(c);
            }
            words.add(word);
        }

        letters = letters.stream().distinct().sorted().collect(Collectors.toList());
        for (int i=0; i<letters.size(); i++){
            lettersChars[i] = letters.get(i);
        }

        String total = in.next();

        execute(words, total);
        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        //System.out.println("answer");
    }

    public static void execute(List<String> words, String total){
        List<Character> letters = new ArrayList<>();
        for (String w : words){
            for (char c : w.toCharArray()){
                letters.add(c);
            }
        }

        for (char c : total.toCharArray()){
            letters.add(c);
        }

        letters = letters.stream().distinct().sorted().collect(Collectors.toList());

        char[] lettersChars = new char[10];
        for (int i=0; i<letters.size(); i++){
            lettersChars[i] = letters.get(i);
        }

        List<Character> firstLetters = words.stream().map(w -> w.charAt(0)).collect(Collectors.toList());

        firstLetters.add(total.charAt(0));


        try {
            printAllRecursive(10, new int[]{9, 1, 2, 3, 4, 5, 6, 7, 8, 0}, words, total, lettersChars, letters.size(), firstLetters);
        } catch (Exception e) {
            //do nothing
        }
    }

    private static Integer transformWord(String word, Map<Character, Integer> testMap){
        StringBuilder result = new StringBuilder();
        for (char c: word.toCharArray()){
            result.append(testMap.get(c));
        }
        return Integer.parseInt(result.toString());
    }

    public static void printAllRecursive(
            int n, int[] elements, List<String> words, String total, char[] lettersChars, int size, List<Character> firstLetters) throws Exception {

        if(n == 1) {

            Map<Character, Integer> m = new HashMap<>();
            for (int i=0; i<size; i++){
                m.put(lettersChars[i], elements[i]);                                    
            }
            if (firstLetters.stream().map(m::get).noneMatch(d -> d == 0)){
                if (calculateSum(words, total, m)){
                    printMap(m);
                    throw new Exception("success");
                }
            }

        } else {
            for(int i = 0; i < n-1; i++) {
                printAllRecursive(n - 1, elements, words, total, lettersChars, size, firstLetters);
                if(n % 2 == 0) {
                    swap(elements, i, n-1);
                } else {
                    swap(elements, 0, n-1);
                }
            }
            printAllRecursive(n - 1, elements, words, total, lettersChars, size, firstLetters);
        }
    }

    private static void swap(int[] input, int a, int b) {
        int tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    private static boolean calculateSum(List<String> words, String total, Map<Character, Integer> mapping){
        long sum = 0;

        for (String w : words){
            sum += transformWord(w, mapping);
        }
        return transformWord(total, mapping) == sum;
    }

    private static void printMap(Map<Character, Integer> m){
        m.keySet().stream().sorted().forEach(v -> System.out.println(v + " " + m.get(v)));
    }
}
