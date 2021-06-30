package hackerrank;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class ATaleOfTwoStacks {
    static class MyQueue<T>{
        Stack<T> in = new Stack<>();
        Stack<T> out = new Stack<>();
        void enqueue(T t){
            in.push(t);
        }
        void dequeue(){
            if (out.isEmpty()){
                while (!in.isEmpty()){
                    out.push(in.pop());
                }
            }
            out.pop();
        }
        T peek(){
            if (out.isEmpty()){
                while (!in.isEmpty()){
                    out.push(in.pop());
                }
            }
            return out.peek();
        }
    }
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
