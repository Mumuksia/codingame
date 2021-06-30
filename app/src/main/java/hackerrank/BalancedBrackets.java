package hackerrank;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedBrackets {

    public static String isBalanced(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c: s.toCharArray()){
            if (c ==')'){

                if (stack.isEmpty() || stack.pop() != '('){
                    return "NO";
                }
            } else
            if (c =='}'){
                if (stack.isEmpty() || stack.pop() != '{'){
                    return "NO";
                }
            } else
            if (c ==']'){

                if (stack.isEmpty() || stack.pop() != '['){
                    return "NO";
                }
            } else{
                stack.push(c);
            }
        }
        return stack.isEmpty()?"YES":"NO";
    }
}
