package advent_23;

import kotlin.collections.ArrayDeque;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day_8 {

    public int navigation(String[] lines, String instructions){
        Map<String, TreeNode> nodeMap = new HashMap<>();



        // Parse each line
        for (String line : lines) {
            String[] parts = line.split(" = ");
            String nodeName = parts[0].trim().replaceAll("\r", "");
            String[] childNames = parts[1].replaceAll("[()]", "").split(", ");

            // Create or get the node
            TreeNode parentNode = nodeMap.computeIfAbsent(nodeName, TreeNode::new);

            // Assign children to the parent node
            if (childNames.length > 0) {
                TreeNode leftChild = nodeMap.computeIfAbsent(childNames[0].replaceAll("\r", ""), TreeNode::new);
                parentNode.left = leftChild;
            }
            if (childNames.length > 1) {
                TreeNode rightChild = nodeMap.computeIfAbsent(childNames[1].replaceAll("\r", ""), TreeNode::new);
                parentNode.right = rightChild;
            }
        }

        TreeNode root = nodeMap.get("AAA");
        int count = 0;
        char[] steps = instructions.toCharArray();
        for (int i=0;i<steps.length;i++){
            count++;
            if (steps[i] == 'L'){
                root = root.left;
            } else {
                root = root.right;
            }
            if (root.value.equals("ZZZ")){
                return count;
            }
            if (i == steps.length-1){
                i = -1;
            }
        }
        return 0;
    }

    public long navigation_2(String[] lines, String instructions){
        Map<String, TreeNode> nodeMap = new HashMap<>();



        // Parse each line
        for (String line : lines) {
            String[] parts = line.split(" = ");
            String nodeName = parts[0].trim().replaceAll("\r", "");
            String[] childNames = parts[1].replaceAll("[()]", "").split(", ");

            // Create or get the node
            TreeNode parentNode = nodeMap.computeIfAbsent(nodeName, TreeNode::new);

            // Assign children to the parent node
            if (childNames.length > 0) {
                TreeNode leftChild = nodeMap.computeIfAbsent(childNames[0].replaceAll("\r", ""), TreeNode::new);
                parentNode.left = leftChild;
            }
            if (childNames.length > 1) {
                TreeNode rightChild = nodeMap.computeIfAbsent(childNames[1].replaceAll("\r", ""), TreeNode::new);
                parentNode.right = rightChild;
            }
        }

        List<TreeNode> entryPoints = new ArrayList<>();
        List<TreeNode> finish = new ArrayList<>();

        for (String nodeValue : nodeMap.keySet()){
            if(nodeValue.endsWith("A")){
                entryPoints.add(nodeMap.get(nodeValue));
            }
            if(nodeValue.endsWith("Z")){
                finish.add(nodeMap.get(nodeValue));
            }
        }

        long count = 0;
        char[] steps = instructions.toCharArray();
        List<Long> result = new ArrayList<>();
        for (int i=0;i<steps.length;i++){
            count++;
            List<TreeNode> temp = new ArrayList<>();
            if (entryPoints.isEmpty()){
                return lcm(result.stream().mapToLong(r->r).toArray());
            }
            for (TreeNode rootNodes : entryPoints){
                if (steps[i] == 'L'){
                    rootNodes = rootNodes.left;
                } else {
                    rootNodes = rootNodes.right;
                }

                if (finish.contains(rootNodes)){
                    result.add(count);
                } else {
                    temp.add(rootNodes);
                }

            }

            entryPoints = temp;
            if (i == steps.length-1){
                i = -1;
            }
        }

        return 0;
    }

    private static long lcm(long a, long b)
    {
        return a * (b / gcd(a, b));
    }

    private static long lcm(long[] input)
    {
        long result = input[0];
        for(int i = 1; i < input.length; i++) result = lcm(result, input[i]);
        return result;
    }

    private static long gcd(long a, long b)
    {
        while (b > 0)
        {
            long temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }
}
