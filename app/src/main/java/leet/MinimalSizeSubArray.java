package leet;

public class MinimalSizeSubArray {

    public int minSubArrayLen(int target, int[] nums) {

        for (int i = 1; i< nums.length+1;i++){
            int curr_sum;
            int max_sum = 0;
            for (int j = 0; j<i; j++){
                max_sum+=nums[j];
            }

            curr_sum = max_sum;
            for (int j = i; j<nums.length; j++){
                curr_sum += nums[j] - nums[j-i];
                max_sum = Math.max(curr_sum, max_sum);
            }
            if (max_sum >= target){
                return i;
            }
        }
        return 0;
    }
}
