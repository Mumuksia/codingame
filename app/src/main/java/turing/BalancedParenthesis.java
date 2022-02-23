package turing;

import java.util.Stack;

public class BalancedParenthesis {


    public static boolean isValid(String s){
        char[] sc = s.toCharArray();
        Stack<Character> stc = new Stack<>();

        for (char value : sc) {
            if (value == '(' || value == '[' || value == '{') {
                stc.push(value);
            } else {
                if (stc.isEmpty()) {
                    return false;
                }
                Character c = stc.pop();
                if (value == ')' && c != '(') {
                    return false;
                }
                if (value == ']' && c != '[') {
                    return false;
                }
                if (value == '}' && c != '{') {
                    return false;
                }
            }
        }
        return stc.isEmpty();
    }
}
