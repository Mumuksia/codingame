package leet;

public class MaxDepthTreeNode {

    int max  = 0;

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
    }
}
