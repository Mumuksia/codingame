package leet;

import java.util.*;

public class BinaryTreeZigZag {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>(Arrays.asList(root));
        boolean left = true;
        while (!q.isEmpty()) {
            List<Integer> currLevel = new ArrayList<>();
            for (int sz = q.size(); sz > 0; --sz) {
                TreeNode node = q.poll();
                currLevel.add(node.val);
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
            if (!left){
                Collections.reverse(currLevel);
            }
            left = !left;
            ans.add(currLevel);
        }

        return ans;
    }
}
