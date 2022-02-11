package turing;

import java.util.Stack;

public class BalancedParenthesis {


    public static boolean isValid(String s){
        char[] sc = s.toCharArray();
        Stack<Character> stc = new Stack<>();

        for (int i=0;i<sc.length;i++){
            if (sc[i] == '(' || sc[i] == '[' || sc[i] == '{'){
                stc.push(sc[i]);
            } else {
                if (stc.isEmpty()){
                    return false;
                }
                Character c = stc.pop();
                if (sc[i] == ')' && c !='('){
                    return false;
                }
                if (sc[i] == ']' && c !='['){
                    return false;
                }
                if (sc[i] == '}' && c !='{'){
                    return false;
                }
            }
        }
        return stc.isEmpty();
    }
}
