package hackerrank;

import java.util.List;
import java.util.Stack;

public class LargestRectangle {

    public static long largestRectangle(List<Integer> h) {
        return getMaxArea(h.stream().mapToInt(i->i).toArray(), h.size());
    }

    static int getMaxArea(int[] hist, int n)
    {
        Stack<Integer> indexesStack = new Stack<>();

        int max_area = 0;
        int topOfStack;
        int area_with_top;


        int i = 0;
        while (i < n)
        {
            if (indexesStack.empty() || hist[indexesStack.peek()] <= hist[i])
                indexesStack.push(i++);

                // If this bar is lower than top of stack, then calculate area of rectangle
                // with stack top as the smallest (or minimum height) bar. 'i' is
                // 'right index' for the top and element before top in stack is 'left index'
            else
            {
                topOfStack = indexesStack.peek();  // store the top index
                indexesStack.pop();  // pop the top

                // Calculate the area with hist[tp] stack as smallest bar
                area_with_top = hist[topOfStack] * (indexesStack.empty() ? i : i - indexesStack.peek() - 1);

                // update max area, if needed
                if (max_area < area_with_top)
                    max_area = area_with_top;
            }
        }

        // Now pop the remaining bars from stack and calculate area with every
        // popped bar as the smallest bar
        while (!indexesStack.empty())
        {
            topOfStack = indexesStack.peek();
            indexesStack.pop();
            area_with_top = hist[topOfStack] * (indexesStack.empty() ? i : i - indexesStack.peek() - 1);

            if (max_area < area_with_top)
                max_area = area_with_top;
        }

        return max_area;

    }

}
