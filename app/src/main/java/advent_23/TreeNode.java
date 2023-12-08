package advent_23;

public class TreeNode {
    public String value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(String value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return value;
    }
}
