package codingame.card_counting;
import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    private static int numberOfCardsUsed = 0;
    private static int numberOfCardsLessUsed = 0;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String streamOfConsciousness = in.nextLine();
        int bustThreshold = in.nextInt();

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println("percentageChance%");
    }

    public static long cardCounting(String s, int threshold){

        String[] cards = s.split("\\.");
        for (String seq : cards){
           calculateCards(seq, threshold);
        }

        double totalGoodCards = 4 + (threshold - 2)*4;

        return Math.round((totalGoodCards - numberOfCardsLessUsed)*100/(52-numberOfCardsUsed));
    }

    public static void calculateCards(String s, int threshold){
        int total = 0;
        for (char c: s.toCharArray()){
            if (c != 'A' && c!='J' && c!='Q' && c!='K' && c!='T' && (c<'2' || c>'9')){
                return;
            }
            switch (c){
                case 'A': total+=1;
                break;
                case 'J':
                case 'Q':
                case 'K':
                case 'T':
                break;
                default: int value = Integer.parseInt(String.valueOf(c));
                if (value < threshold){
                    total +=1;
                }
            }
        }
        numberOfCardsLessUsed += total;
        numberOfCardsUsed +=s.length();
    }
}
