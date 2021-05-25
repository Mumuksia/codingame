package codingame.enigmaencryption;

import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String operation = in.nextLine();
        int pseudoRandomNumber = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        String[] rotors = new String[3];

        for (int i = 0; i < 3; i++) {
            rotors[i] = in.nextLine();

        }
        String message = in.nextLine();

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");
        System.out.println(execute(operation, message, pseudoRandomNumber, rotors));

    }

    public static String execute(String operation, String msg, int p, String[] rotors){
        if ("ENCODE".equals(operation)){
            return encode(shiftMessage(msg, p), rotors);
        } else {
            return String.valueOf(shiftMessageDecode(decode(msg.toCharArray(), rotors), p));
        }
    }



    public static String encode(char[] msg, String[] rotors){
        StringBuilder result = new StringBuilder();
        for (char c : msg) {
            int alphabetPosM = (int) c - 65;
            int alphabetPos0 = (int) rotors[0].charAt(alphabetPosM) - 65;
            int alphabetPos1 = (int) rotors[1].charAt(alphabetPos0) - 65;
            result.append(rotors[2].charAt(alphabetPos1));
            //result[i] = rotors[0].indexOf(msg[i])
        }
        return result.toString();
    }

    public static String decode(char[] msg, String[] rotors){
        StringBuilder result = new StringBuilder();
        for (char c : msg) {
            char alphabetPosM = Character.toString(rotors[2].indexOf(c) + 65).charAt(0);
            char alphabetPos1 = Character.toString(rotors[1].indexOf(alphabetPosM) + 65).charAt(0);
            char alphabetPos0 = Character.toString(rotors[0].indexOf(alphabetPos1) + 65).charAt(0);

            result.append(alphabetPos0);
            //result[i] = rotors[0].indexOf(msg[i])
        }
        return result.toString();
    }

    //65-90
    public static char[] shiftMessage(String msg, int shift){
        char[] m = msg.toCharArray();
        char[] result = new char[m.length];
        for (int i=0;i<m.length;i++){
            int temp = (int) m[i] + shift + i;
            result[i] = Character.toString((temp - 65)%26 + 65).charAt(0);
        }
        return result;
    }

    //65-90 for decoding we get negative numbers
    public static char[] shiftMessageDecode(String msg, int shift){
        char[] m = msg.toCharArray();
        char[] result = new char[m.length];
        for (int i=0;i<m.length;i++){
            int temp = (int) m[i] - shift - i;
            temp = makeNormal(temp);
            result[i] = Character.toString(temp).charAt(0);
        }
        return result;
    }

    private static int makeNormal(int t){
        if (t>=65) return t;
        return makeNormal(t+26);
    }
}
