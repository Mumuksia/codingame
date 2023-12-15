package leet;

import java.util.Stack;

public class ValidParenthesis {


    public boolean isValid(String s) {
        Stack<Character> pa = new Stack<>();

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(' -> pa.push(c);
                case '{' -> pa.push(c);
                case '[' -> pa.push(c);
                case ')' -> {
                    if (pa.isEmpty() || pa.peek() != '(') {
                        return false;
                    }
                    pa.pop();
                }
                case '}' -> {
                    if (pa.isEmpty() || pa.peek() != '{') {
                        return false;
                    }
                    pa.pop();
                }
                case ']' -> {
                    if (pa.isEmpty() || pa.peek() != '[') {
                        return false;
                    }
                    pa.pop();
                }
            }
        }
        return pa.isEmpty();
    }
}
