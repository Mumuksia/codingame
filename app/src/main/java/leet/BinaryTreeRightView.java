package leet;

import java.util.*;

public class BinaryTreeRightView {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>(Arrays.asList(root));
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
            Collections.reverse(currLevel);
            result.add(currLevel.get(0));
        }

        return result;
    }
}
