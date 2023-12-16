package leet;

import java.util.Stack;

public class ReversePolish {

    Stack<Integer> digits = new Stack<>();

    public int evalRPN(String[] tokens) {

        for (String current : tokens){
            switch (current) {
                case "*": {
                    int a = digits.pop();
                    int b = digits.pop();
                    digits.push(a*b);
                    break;
                }
                case "+": {
                    int a = digits.pop();
                    int b = digits.pop();
                    digits.push(a+b);
                    break;
                }
                case "-": {
                    int a = digits.pop();
                    int b = digits.pop();
                    digits.push(b-a);
                    break;
                }
                case "/": {
                    int a = digits.pop();
                    int b = digits.pop();
                    digits.push(b/a);
                    break;
                }
                default: {
                    digits.push(Integer.valueOf(current));
                }
            }
        }
        return digits.pop();
    }
}
