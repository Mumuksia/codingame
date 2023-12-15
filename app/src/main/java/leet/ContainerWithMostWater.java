package leet;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max =0;
        int start = 0;
        int end = height.length-1;

        while (start < end){
            int current = Math.min(height[start],height[end])*(end-start);
            max = Math.max(max, current);
            if (height[start] > height[end]){
                end--;
            } else {
                start++;
            }
        }
        return max;
    }
}
