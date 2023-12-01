package codingame.waysofsum;

public class Solution {

    public static int ways(int total, int k) {
        int totalWays = 0;

        if (total == 1)
            return 1;

        for (int weight = 1; weight <= k ; weight++) {
            if (weight <= total) //8 -> tw +=ways(7, 2) + ways(6,2) + 6,2 + 5,2 + 5,2 + 4,2 + 4,2 + 3,2
                totalWays += ways(total - weight, k);
        }

        // ways (3,2) -> ways (2,2) , ways (1, 1)
        // ways (2,2)


        return total;
    }

    public static void main(String args[]) {
        System.out.println(ways(8, 2));
    }
}
