package leet;

import java.util.ArrayDeque;
import java.util.Queue;

public class SameTree {

    Queue<TreeNode> seenP = new ArrayDeque<>();

    Queue<TreeNode> seenQ = new ArrayDeque<>();

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null || q == null){
            return p == q;
        }

        if (p.val != q.val){
            return false;
        }
        seenP.add(p);
        seenQ.add(q);

        while (!seenP.isEmpty() && !seenQ.isEmpty()){
            TreeNode tp = seenP.poll();
            TreeNode tq = seenQ.poll();


            if (tp.val != tq.val){
                return false;
            }
            if (tp.left != null && tq.left != null){
                seenP.add(tp.left);
                seenQ.add(tq.left);
            }
            if (tp.right != null && tq.right != null){
                seenP.add(tp.right);
                seenQ.add(tq.right);
            }

            if ((tp.left == null || tq.left == null) && tp.left != tq.left){
                return false;
            }
            if ((tp.right == null || tq.right == null) && tp.right != tq.right){
                return false;
            }
        }
        return seenP.isEmpty() && seenQ.isEmpty();
    }
}
