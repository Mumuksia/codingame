package codingame.chuck;

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
        String MESSAGE = in.nextLine();

        System.out.println(execute(MESSAGE));
    }

    public static String execute(String MESSAGE){

        char[] chars = MESSAGE.toCharArray();
        StringBuilder binaryRepresentation = new StringBuilder();


        for (char c : chars) {
            String temp = Integer.toBinaryString((int) c);
            binaryRepresentation.append(temp.length() == 7? temp: "0" + temp);
        }

        StringBuilder result = new StringBuilder();
        StringBuilder buffer = new StringBuilder();
        char previous = '2';

        for (char c : binaryRepresentation.toString().toCharArray()){
            if (c == previous){
                buffer.append('0');
            } else {
                result.append(buffer);
                result.append(" ");
                buffer = new StringBuilder();
                if (c == '0'){
                    result.append("00 ");
                    buffer.append('0');
                    previous = '0';
                } else {
                    result.append("0 ");
                    buffer.append('0');
                    previous = '1';
                }
            }
        }
        result.append(buffer);
        return result.toString().trim();
    }
}
