package leet;

public class TwoSumSortedArray {

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i< numbers.length-1;i++){
            for (int j=i+1; j<numbers.length;j++){
                if (numbers[i] + numbers[j] == target){
                    return prepareAnswer(i, j);
                }
                if (numbers[i] + numbers[j] > target){
                    break;
                }
            }

        }
        return new int[]{};
    }

    private int[] prepareAnswer(int i, int j){
        return new int[]{++i, ++j};
    }
}
