package leet;

import java.util.*;

public class AverageLevelBinaryTree {
    List<Double> result = new ArrayList<>();
    Queue<TreeNode> nodesLevel = new ArrayDeque<>();
    public List<Double> averageOfLevels(TreeNode root) {
        nodesLevel.add(root);
        while (!nodesLevel.isEmpty()){
            long sum = 0;
            int size = nodesLevel.size();
            for (int i = 0; i<size; i++){
                TreeNode node = nodesLevel.poll();
                sum += node.val;
                if (node.left != null){
                    nodesLevel.add(node.left);
                }
                if (node.right != null){
                    nodesLevel.add(node.right);
                }
            }
            result.add(sum/(double)size);
        }

        return result;
    }


}
