package simple.a20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 后序遍历二叉树
 */
public class PostorderTraversal {
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

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        ArrayList<Integer> integers = new ArrayList<>();
        List<Integer> left = postorderTraversal(root.left);
        integers.addAll(left);
        List<Integer> right = postorderTraversal(root.right);
        integers.addAll(right);
        integers.add(root.val);
        return integers;
    }
}
