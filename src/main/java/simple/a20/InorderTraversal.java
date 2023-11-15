package simple.a20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InorderTraversal {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        ArrayList<Integer> integers = new ArrayList<>();
        List<Integer> left = inorderTraversal(root.left);
        integers.addAll(left);
        integers.add(root.val);
        List<Integer> right = inorderTraversal(root.right);
        integers.addAll(right);

        return integers;
    }
}
