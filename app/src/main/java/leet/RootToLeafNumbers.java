package leet;

import java.util.ArrayDeque;
import java.util.Queue;

public class RootToLeafNumbers {

    Queue<TreeNode> seen = new ArrayDeque<>();

    public int sumNumbers(TreeNode root) {
        int sum = 0;

        if (root == null){
            return sum;
        }

        if (root.left == null && root.right == null){
            return root.val;
        }

        seen.add(root);

        while (!seen.isEmpty()){
            TreeNode temp = seen.poll();

            TreeNode left = temp.left;
            TreeNode right = temp.right;

            if (left == null && right == null){
                sum += temp.val;
            }
            if (left != null){
                left.val = Integer.valueOf("" + temp.val + left.val);
                seen.add(left);
            }
            if (right != null){
                right.val = Integer.valueOf("" + temp.val + right.val);
                seen.add(right);
            }
        }
        return sum;
    }


}
